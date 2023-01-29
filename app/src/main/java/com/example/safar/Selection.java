package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {
Button btnState;
Button btnType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        btnState=findViewById(R.id.btnState);
        btnType=findViewById(R.id.btnType);
        btnState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(Selection.this,Db_state.class);
                //startActivity(intent);
            }
        });


        btnType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(Selection.this,Db_type.class);
               // startActivity(intent);
            }
        });
    }
}