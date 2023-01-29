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
import com.example.safar.HomeActivity;
import com.example.safar.R;
import com.example.safar.model.StateListModel;


import java.util.ArrayList;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.ItemViewHolder>{

    ArrayList<StateListModel> modelArrayList;
    Context context;

    public StateListAdapter(ArrayList<StateListModel> modelArrayList, Context context){
        this.modelArrayList = modelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.state_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        StateListModel model = modelArrayList.get(position);
        holder.textView.setText(model.getName());
        Glide.with(context).load(model.getImage()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("stateId", model.getCode());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.placeItemImage);
            textView = itemView.findViewById(R.id.placeItemName);
        }
    }

}
