package com.example.food.admincreate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.food.R;
import com.example.food.model.Postre;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainAdminPostres extends AppCompatActivity {

    private List<Postre> listPostre = new ArrayList<Postre>();
    ArrayAdapter<Postre> arrayAdapterPostre;

    EditText imagenP, nombreP, precioP, tiempoP;

    ListView listV_postres;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Postre postreSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_createpostres);

        imagenP = findViewById(R.id.txt_imagenPostre);
        nombreP = findViewById(R.id.txt_nombrePostre);
        precioP = findViewById(R.id.txt_precioPostre);
        tiempoP = findViewById(R.id.txt_tiempoPostre);



        listV_postres = findViewById(R.id.lv_datosPostres);

        inicializarFirebase();
        listarDatos();

        listV_postres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                postreSelected = (Postre) parent.getItemAtPosition(position);
                imagenP.setText(postreSelected.getImagen());
                nombreP.setText(postreSelected.getNombre());
                precioP.setText(postreSelected.getPrecio());
                tiempoP.setText(postreSelected.getTiempo());
            }
        });


    }


    private void listarDatos() {
        databaseReference.child("Postre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPostre.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Postre p = objSnapshot.getValue(Postre.class);
                    listPostre.add(p);

                    arrayAdapterPostre = new ArrayAdapter<Postre>(MainAdminPostres.this, android.R.layout.simple_list_item_1, listPostre);
                    listV_postres.setAdapter(arrayAdapterPostre);
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


        String imagen = imagenP.getText().toString();
        String nombre = nombreP.getText().toString();
        String precio = precioP.getText().toString();
        String tiempo = tiempoP.getText().toString();


        switch (item.getItemId()) {

            case R.id.icon_add: {

                if (nombre.equals("") || imagen.equals("") || precio.equals("") || tiempo.equals("")) {
                    validacion();
                    break;
                } else {
                    Postre p = new Postre();
                    p.setUid(UUID.randomUUID().toString());
                    p.setImagen(imagen);
                    p.setNombre(nombre);
                    p.setPrecio(precio);
                    p.setTiempo(tiempo);
                    databaseReference.child("Postre").child(p.getUid()).setValue(p);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_save: {
                Postre p = new Postre();
                p.setUid(postreSelected.getUid());
                p.setImagen(imagenP.getText().toString().trim());
                p.setNombre(nombreP.getText().toString().trim());
                p.setPrecio(precioP.getText().toString().trim());
                p.setTiempo(tiempoP.getText().toString().trim());
                databaseReference.child("Postre").child(p.getUid()).setValue(p);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            case R.id.icon_delete: {
                Postre p = new Postre();
                p.setUid(postreSelected.getUid());
                databaseReference.child("Postre").child(p.getUid()).removeValue();
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
        imagenP.setText("");
        nombreP.setText("");
        precioP.setText("");
        tiempoP.setText("");

    }

    private void validacion() {
        String imagen = imagenP.getText().toString();
        String nombre = nombreP.getText().toString();
        String precio = precioP.getText().toString();
        String tiempo = tiempoP.getText().toString();

        if (imagen.equals("")) {
            imagenP.setError("Porfavor, agrega la URL de la imagen");
        } else if (nombre.equals("")) {
            nombreP.setError("Porfavor, agrega el nombre");
        } else if (precio.equals("")) {
            precioP.setError("Porfavor, agrega el precio");
        } else if (tiempo.equals("")) {
            tiempoP.setError("Porfavor, agrega el tiempo de entrega");
        }

    }


}