package com.example.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.model.Desayuno;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder>{

    private Context context;
    private List<Desayuno> popularList;

    public PopularAdapter(Context context, List<Desayuno> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.single_item, parent,false);
        return new PopularViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.popularName.setText(popularList.get(position).getNombre());
        Glide.with(context).load(popularList.get(position)).into(holder.popularImage);

    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder{

        ImageView popularImage;
        TextView popularName, popularCost;


        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularImage=itemView.findViewById(R.id.pop_image);
            popularName=itemView.findViewById(R.id.pop_nombre);
            popularCost=itemView.findViewById(R.id.pop_cost);
        }
    }
}
