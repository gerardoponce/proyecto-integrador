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
import com.example.food.model.Postre;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class RecyclerActivityPostre extends AppCompatActivity {

    private RecyclerView mPostresList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_postres);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Postre");
        mDatabase.keepSynced(true);

        mPostresList = (RecyclerView) findViewById(R.id.postresRecyclerView);
        mPostresList.setHasFixedSize(true);
        mPostresList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Postre, PostreViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Postre, PostreViewHolder>
                (Postre.class, R.layout.single_item, PostreViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(PostreViewHolder postreViewHolder, Postre postre, int i) {
                postreViewHolder.setImage(getApplicationContext(), postre.getImagen());
                postreViewHolder.setNombre(postre.getNombre());
                postreViewHolder.setPrecio(postre.getPrecio());
                postreViewHolder.setTiempo(postre.getTiempo());

            }
        };
        mPostresList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class PostreViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public PostreViewHolder(View itemView) {
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