package com.example.safar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    int[] imageId;
    String[] sName;
    Context context;
    LayoutInflater layoutInflater;

    GridAdapter(int[] imageId,String[] sName,Context context)
    {
       this.context=context;
       this.imageId=imageId;
       this.sName=sName;
    }


    @Override
    public int getCount() {
       return sName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    if(layoutInflater==null)
    {
       layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    if(convertView==null)
convertView=layoutInflater.inflate(R.layout.grid_items,null);
        ImageView image=convertView.findViewById(R.id.imagegrid);
        TextView name=convertView.findViewById(R.id.tv_grid);
         image.setImageResource(imageId[position]);
         name.setText(sName[position]);
return convertView;


    }
}
