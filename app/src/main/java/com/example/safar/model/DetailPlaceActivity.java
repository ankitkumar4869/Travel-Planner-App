package com.example.safar.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.safar.R;

public class DetailPlaceActivity extends AppCompatActivity {

    StateDescriptionModel model;
    ImageView imageView;
    TextView description;
    TextView bestTimeToVisit;
    TextView placeItemName;
    TextView placeType;
    ImageButton youtube;
    ImageButton location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);
        model = (StateDescriptionModel) getIntent().getSerializableExtra("model");
        loadUI();
        fillData();
    }

    void loadUI(){
        imageView = findViewById(R.id.placeItemImage);
        description = findViewById(R.id.description);
        bestTimeToVisit = findViewById(R.id.bttv);
        placeItemName = findViewById(R.id.placeItemName);
        placeType = findViewById(R.id.placeType);
        youtube = findViewById(R.id.youtube);
        location = findViewById(R.id.location);
    }


    void fillData(){
        Glide.with(this).load(model.getImage()).into(imageView);
        description.setText(model.getDescription());
        bestTimeToVisit.setText(model.getClimate());
        placeItemName.setText(model.getName());
        placeType.setText(model.getType());
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchYoutubeVideo(model.getVideo());
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(model.getLocation()));
                startActivity(intent);
            }
        });
    }


    void watchYoutubeVideo(String id) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse( id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}