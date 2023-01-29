package com.example.safar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.ViewHolder> {
    private Context context;
    private ArrayList<StatePlacesData> nameList;

    public SpAdapter(Context context, ArrayList<StatePlacesData> nameList) {
        this.context = context;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public SpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.state_places_temp,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpAdapter.ViewHolder holder, int position) {
        holder.textView.setText(nameList.get(position).getName());
        Glide.with(context).load(nameList.get(position).getUrl()).load(holder.imageView);





    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


          ImageView imageView;
          TextView textView;

          public ViewHolder(@NonNull View itemView) {
              super(itemView);
              imageView=itemView.findViewById(R.id.sptImage);


              textView=itemView.findViewById(R.id.stateName);
          }
      }
}
