package com.example.food.recyclerviews;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.R;
import com.example.food.model.Almuerzo;
import com.example.food.model.Desayuno;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class RecyclerActivityAlmuerzo extends AppCompatActivity {

    private RecyclerView mAlmuerzosList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_almuerzos);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Almuerzo");
        mDatabase.keepSynced(true);

        mAlmuerzosList = (RecyclerView) findViewById(R.id.almuerzoRecyclerView);
        mAlmuerzosList.setHasFixedSize(true);
        mAlmuerzosList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Almuerzo, AlmuerzoViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Almuerzo, AlmuerzoViewHolder>
                (Almuerzo.class, R.layout.single_item, AlmuerzoViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(AlmuerzoViewHolder almuerzoViewHolder, Almuerzo almuerzo, int i) {
                almuerzoViewHolder.setImage(getApplicationContext(), almuerzo.getImagen());
                almuerzoViewHolder.setNombre(almuerzo.getNombre());
                almuerzoViewHolder.setPrecio(almuerzo.getPrecio());
                almuerzoViewHolder.setTiempo(almuerzo.getTiempo());

            }
        };
        mAlmuerzosList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class AlmuerzoViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public AlmuerzoViewHolder(View itemView) {
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