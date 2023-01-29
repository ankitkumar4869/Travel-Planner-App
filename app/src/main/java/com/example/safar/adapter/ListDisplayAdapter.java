package com.example.safar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safar.R;
import com.example.safar.model.DetailPlaceActivity;
import com.example.safar.model.StateDescriptionModel;

import java.util.ArrayList;

public class ListDisplayAdapter extends RecyclerView.Adapter<ListDisplayAdapter.ItemViewHolder> {

    Context context;
    ArrayList<StateDescriptionModel> list;

    public ListDisplayAdapter(Context context, ArrayList<StateDescriptionModel> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        StateDescriptionModel model = list.get(position);
        holder.textView.setText(model.getName());
        holder.textView1.setText(model.getType());
        Glide.with(context)
                .load(model.getImage())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailPlaceActivity.class);
                intent.putExtra("model", model);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        TextView textView1;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.placeItemName);
            textView1 = itemView.findViewById(R.id.typeItemPlace);
            imageView = itemView.findViewById(R.id.placeItemImage);

        }



    }

}
