package com.example.safar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StatePlaces extends AppCompatActivity {
RecyclerView recyclerView;
private DatabaseReference reference;
private ArrayList<StatePlacesData> nameList;
private SpAdapter spAdapter;
private Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_places);
        recyclerView=findViewById(R.id.statePlacesRecycler);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //Firebase
        reference= FirebaseDatabase.getInstance().getReference();
        //ArrayList
        nameList=new ArrayList<>();
        //clearAll();

        //Get Dtaa Mewthod
        getDataFromFirebase();
    }

    private void getDataFromFirebase() {
        Query query=reference.child("Maharashtra");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    StatePlacesData statePlacesData=new StatePlacesData();
                    statePlacesData.setUrl(snapshot1.child("Image").getValue().toString());
                    statePlacesData.setName(snapshot1.child("Name").getValue().toString());
                    nameList.add(statePlacesData);
                }
                spAdapter=new SpAdapter(mcontext,nameList);
                recyclerView.setAdapter(spAdapter);
                spAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(StatePlaces.this,error.toString(),Toast.LENGTH_SHORT).show();

            }
        });



    }

    private void clearAll()
    {
        if(nameList !=null)
        {
            nameList.clear();
            spAdapter.notifyDataSetChanged();
        }

        nameList=new ArrayList<>();
    }

}