package com.example.food.recyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food.R;
import com.example.food.model.Desayuno;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class RecyclerActivityDesayuno extends AppCompatActivity {

    private RecyclerView mDesayunosList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_desayunos);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Desayuno");
        mDatabase.keepSynced(true);

        mDesayunosList = (RecyclerView) findViewById(R.id.desayunoRecyclerView);
        mDesayunosList.setHasFixedSize(true);
        mDesayunosList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Desayuno, DesayunoViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Desayuno, DesayunoViewHolder>
                (Desayuno.class, R.layout.single_item, DesayunoViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(DesayunoViewHolder desayunoViewHolder, Desayuno desayuno, int i) {
                desayunoViewHolder.setImage(getApplicationContext(), desayuno.getImagen());
                desayunoViewHolder.setNombre(desayuno.getNombre());
                desayunoViewHolder.setPrecio(desayuno.getPrecio());
                desayunoViewHolder.setTiempo(desayuno.getTiempo());

            }
        };
        mDesayunosList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class DesayunoViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public DesayunoViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setImage(Context ctx, String image) {
            ImageView post_ImageView = (ImageView) mView.findViewById(R.id.post_Image);
            Picasso.get().load(image).into(post_ImageView);
        }

        public void setNombre(String nombre) {
            TextView post_nombre = (TextView) mView.findViewById(R.id.post_nombre);
            post_nombre.setText(nombre);
        }

        public void setPrecio(String precio) {
            TextView post_precio = (TextView) mView.findViewById(R.id.post_precio);
            post_precio.setText(precio);
        }

        public void setTiempo(String tiempo) {
            TextView post_tiempo = (TextView) mView.findViewById(R.id.post_tiempo);
            post_tiempo.setText(tiempo);
        }

    }
}