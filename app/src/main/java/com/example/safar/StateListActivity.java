package com.example.safar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.safar.adapter.StateListAdapter;
import com.example.safar.model.StateListModel;

import java.util.ArrayList;

public class StateListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    StateListAdapter adapter;
    ArrayList<StateListModel> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_list);
        recyclerView = findViewById(R.id.stateList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fillArrayList();
        adapter = new StateListAdapter(modelArrayList, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
            {
                Intent intent=new Intent(StateListActivity.this,HomeActivity.class);
                intent.putExtra("stateId","000");
                startActivity(intent);
                break;
            }
            case R.id.item2:
            {
                Intent intent=new Intent(StateListActivity.this,UploadVideoActivity.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }



    void fillArrayList(){
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new StateListModel("Bihar", "https://www.holidify.com/images/bgImages/BODH-GAYA.jpg", "001"));
        modelArrayList.add(new StateListModel("Jharkhand", "https://www.holidify.com/images/bgImages/DEOGHAR.jpg", "002"));
        modelArrayList.add(new StateListModel("Punjab", "https://www.holidify.com/images/bgImages/AMRITSAR.jpg", "009"));
        modelArrayList.add(new StateListModel("Rajasthan", "https://www.holidify.com/images/bgImages/UDAIPUR.jpg", "006"));
        modelArrayList.add(new StateListModel("Himachal Pradesh", "https://www.holidify.com/images/bgImages/MANALI.jpg", "005"));
        modelArrayList.add(new StateListModel("Uttar Pradesh", "https://www.holidify.com/images/bgImages/AGRA.jpg", "003"));
        modelArrayList.add(new StateListModel("Goa", "https://www.holidify.com/images/cmsuploads/compressed/shutterstock_1314723038_20190822145625.jpg", "004"));
        modelArrayList.add(new StateListModel("Gujarat", "https://www.holidify.com/images/bgImages/GIR-NATIONAL-PARK.jpg", "007"));
        modelArrayList.add(new StateListModel("Maharashtra", "https://www.holidify.com/images/bgImages/AJANTA-AND-ELLORA-CAVES.jpg", "008"));
        modelArrayList.add(new StateListModel("Karnataka", "https://www.holidify.com/images/bgImages/COORG.jpg", "010"));
    }
}