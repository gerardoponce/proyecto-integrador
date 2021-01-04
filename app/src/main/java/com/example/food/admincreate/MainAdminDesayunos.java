package com.example.food.admincreate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.food.R;
import com.example.food.model.Desayuno;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainAdminDesayunos extends AppCompatActivity {

    private List<Desayuno> listDesayuno = new ArrayList<Desayuno>();
    ArrayAdapter<Desayuno> arrayAdapterDesayuno;

    EditText imagenD, nombreD, precioD, tiempoD;

    ListView listV_desayunos;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Desayuno desayunoSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_createdesayunos);

        imagenD = findViewById(R.id.txt_imagenDesayuno);
        nombreD = findViewById(R.id.txt_nombreDesayuno);
        precioD = findViewById(R.id.txt_precioDesayuno);
        tiempoD = findViewById(R.id.txt_tiempoDesayuno);



        listV_desayunos = findViewById(R.id.lv_datosDesayunos);

        inicializarFirebase();
        listarDatos();

        listV_desayunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                desayunoSelected = (Desayuno) parent.getItemAtPosition(position);
                imagenD.setText(desayunoSelected.getImagen());
                nombreD.setText(desayunoSelected.getNombre());
                precioD.setText(desayunoSelected.getPrecio());
                tiempoD.setText(desayunoSelected.getTiempo());
            }
        });


    }


    private void listarDatos() {
        databaseReference.child("Desayuno").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listDesayuno.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Desayuno d = objSnapshot.getValue(Desayuno.class);
                    listDesayuno.add(d);

                    arrayAdapterDesayuno = new ArrayAdapter<Desayuno>(MainAdminDesayunos.this, android.R.layout.simple_list_item_1, listDesayuno);
                    listV_desayunos.setAdapter(arrayAdapterDesayuno);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        String imagen = imagenD.getText().toString();
        String nombre = nombreD.getText().toString();
        String precio = precioD.getText().toString();
        String tiempo = tiempoD.getText().toString();


        switch (item.getItemId()) {

            case R.id.icon_add: {

                if (nombre.equals("") || imagen.equals("") || precio.equals("") || tiempo.equals("")) {
                    validacion();
                    break;
                } else {
                    Desayuno d = new Desayuno();
                    d.setUid(UUID.randomUUID().toString());
                    d.setImagen(imagen);
                    d.setNombre(nombre);
                    d.setPrecio(precio);
                    d.setTiempo(tiempo);
                    databaseReference.child("Desayuno").child(d.getUid()).setValue(d);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_save: {
                Desayuno d = new Desayuno();
                d.setUid(desayunoSelected.getUid());
                d.setImagen(imagenD.getText().toString().trim());
                d.setNombre(nombreD.getText().toString().trim());
                d.setPrecio(precioD.getText().toString().trim());
                d.setTiempo(tiempoD.getText().toString().trim());
                databaseReference.child("Desayuno").child(d.getUid()).setValue(d);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            case R.id.icon_delete: {
                Desayuno d = new Desayuno();
                d.setUid(desayunoSelected.getUid());
                databaseReference.child("Desayuno").child(d.getUid()).removeValue();
                Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void limpiarCajas() {
        imagenD.setText("");
        nombreD.setText("");
        precioD.setText("");
        tiempoD.setText("");

    }

    private void validacion() {
        String imagen = imagenD.getText().toString();
        String nombre = nombreD.getText().toString();
        String precio = precioD.getText().toString();
        String tiempo = tiempoD.getText().toString();

        if (imagen.equals("")) {
            imagenD.setError("Porfavor, agrega la URL de la imagen");
        } else if (nombre.equals("")) {
            nombreD.setError("Porfavor, agrega el nombre");
        } else if (precio.equals("")) {
            precioD.setError("Porfavor, agrega el precio");
        } else if (tiempo.equals("")) {
            tiempoD.setError("Porfavor, agrega el tiempo de entrega");
        }

    }


}