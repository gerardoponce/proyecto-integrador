package com.example.food.mainViews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.food.R;
import com.example.food.otros.ProfileActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainSignIn extends AppCompatActivity {

    //Para Sign-In
    private EditText mEditTextName, mEditTextEmail, mEditTextPassword;
    private Button mButtonRegistrar;

    //Para Sign-In : DATOS DE USER
    private String name = "";
    private String email = "";
    private String password = "";
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



        //Para Sign-In

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mEditTextName =(EditText) findViewById(R.id.txt_nombreUsuario);
        mEditTextEmail = (EditText) findViewById(R.id.txt_email);
        mEditTextPassword = (EditText) findViewById(R.id.txt_password);
        mButtonRegistrar = (Button) findViewById(R.id.btn_registrar);

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mEditTextName.getText().toString();
                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    if (password.length() >= 6) {
                        registerUser();
                    } else {
                        Toast.makeText(MainSignIn.this, "Su contraseña debe contener más de 6 carácteres", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainSignIn.this, "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email", email);
                    map.put("password", password);

                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task_sign) {
                            if (task_sign.isSuccessful()) {
                                startActivity(new Intent(MainSignIn.this, ProfileActivity.class));
                            } else {
                                Toast.makeText(MainSignIn.this, "No se pudieron registrar los datos del usuario.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainSignIn.this, "No se pudo registrar al usuario.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
