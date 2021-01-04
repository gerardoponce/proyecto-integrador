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
import com.example.food.model.Almuerzo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainAdminAlmuerzos extends AppCompatActivity {

    private List<Almuerzo> listAlmuerzo = new ArrayList<Almuerzo>();
    ArrayAdapter<Almuerzo> arrayAdapterAlmuerzo;

    EditText imagenA, nombreA, precioA, tiempoA;

    ListView listV_almuerzos;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Almuerzo almuerzoSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_createalmuerzos);

        imagenA = findViewById(R.id.txt_imagenAlmuerzo);
        nombreA = findViewById(R.id.txt_nombreAlmuerzo);
        precioA = findViewById(R.id.txt_precioAlmuerzo);
        tiempoA = findViewById(R.id.txt_tiempoAlmuerzo);



        listV_almuerzos = findViewById(R.id.lv_datosAlmuerzos);

        inicializarFirebase();
        listarDatos();

        listV_almuerzos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                almuerzoSelected = (Almuerzo) parent.getItemAtPosition(position);
                imagenA.setText(almuerzoSelected.getImagen());
                nombreA.setText(almuerzoSelected.getNombre());
                precioA.setText(almuerzoSelected.getPrecio());
                tiempoA.setText(almuerzoSelected.getTiempo());
            }
        });


    }


    private void listarDatos() {
        databaseReference.child("Almuerzo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAlmuerzo.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Almuerzo a = objSnapshot.getValue(Almuerzo.class);
                    listAlmuerzo.add(a);

                    arrayAdapterAlmuerzo = new ArrayAdapter<Almuerzo>(MainAdminAlmuerzos.this, android.R.layout.simple_list_item_1, listAlmuerzo);
                    listV_almuerzos.setAdapter(arrayAdapterAlmuerzo);
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


        String imagen = imagenA.getText().toString();
        String nombre = nombreA.getText().toString();
        String precio = precioA.getText().toString();
        String tiempo = tiempoA.getText().toString();


        switch (item.getItemId()) {

            case R.id.icon_add: {

                if (nombre.equals("") || imagen.equals("") || precio.equals("") || tiempo.equals("")) {
                    validacion();
                    break;
                } else {
                    Almuerzo a = new Almuerzo();
                    a.setUid(UUID.randomUUID().toString());
                    a.setImagen(imagen);
                    a.setNombre(nombre);
                    a.setPrecio(precio);
                    a.setTiempo(tiempo);
                    databaseReference.child("Almuerzo").child(a.getUid()).setValue(a);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.icon_save: {
                Almuerzo a = new Almuerzo();
                a.setUid(almuerzoSelected.getUid());
                a.setImagen(imagenA.getText().toString().trim());
                a.setNombre(nombreA.getText().toString().trim());
                a.setPrecio(precioA.getText().toString().trim());
                a.setTiempo(tiempoA.getText().toString().trim());
                databaseReference.child("Almuerzo").child(a.getUid()).setValue(a);
                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            case R.id.icon_delete: {
                Almuerzo a = new Almuerzo();
                a.setUid(almuerzoSelected.getUid());
                databaseReference.child("Almuerzo").child(a.getUid()).removeValue();
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
        imagenA.setText("");
        nombreA.setText("");
        precioA.setText("");
        tiempoA.setText("");

    }

    private void validacion() {
        String imagen = imagenA.getText().toString();
        String nombre = nombreA.getText().toString();
        String precio = precioA.getText().toString();
        String tiempo = tiempoA.getText().toString();

        if (imagen.equals("")) {
            imagenA.setError("Porfavor, agrega la URL de la imagen");
        } else if (nombre.equals("")) {
            nombreA.setError("Porfavor, agrega el nombre");
        } else if (precio.equals("")) {
            precioA.setError("Porfavor, agrega el precio");
        } else if (tiempo.equals("")) {
            tiempoA.setError("Porfavor, agrega el tiempo de entrega");
        }

    }


}