package com.example.safar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.safar.adapter.ListDisplayAdapter;
import com.example.safar.model.StateDescriptionModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    ListDisplayAdapter adapter;
    ArrayList<StateDescriptionModel> descriptionModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadUI();
    }
    private void loadUI(){
        recyclerView = findViewById(R.id.placeList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        setUpFirebaseRecyclerView();
    }

    private void setUpFirebaseRecyclerView(){

        descriptionModelArrayList = new ArrayList<>();
        adapter = new ListDisplayAdapter(this, descriptionModelArrayList);
        recyclerView.setAdapter(adapter);
        databaseReference = database.getReference("State Description");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String code = getIntent().getExtras().getString("stateId");
                if(code.equals("000")){
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        for(DataSnapshot snapshot1 : dataSnapshot.getChildren()){
                            StateDescriptionModel model = snapshot1.getValue(StateDescriptionModel.class);
                            descriptionModelArrayList.add(model);
                        }
                    }
                }else{
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        if(dataSnapshot.getKey().equals(code)){
                            for(DataSnapshot snapshot1 : dataSnapshot.getChildren()){
                                StateDescriptionModel model = snapshot1.getValue(StateDescriptionModel.class);
                                descriptionModelArrayList.add(model);
                            }
                        }

                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });





    }
}