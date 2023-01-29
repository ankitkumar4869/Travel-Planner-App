package com.example.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    EditText RegFname;
    EditText RegEmail;
    EditText RegLname;
    Button btnReg;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String ph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        RegFname=findViewById(R.id.RegFname);
        RegEmail=findViewById(R.id.RegLname);
        RegLname=findViewById(R.id.RegEmail);
        btnReg=findViewById(R.id.btnReg);
        ph=getIntent().getStringExtra("number");
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase=FirebaseDatabase.getInstance();
                databaseReference=firebaseDatabase.getReference("Users");
                RegistrationData registrationData=new RegistrationData(RegEmail.getText().toString(),RegFname.getText().toString(),RegLname.getText()
                .toString(),ph);
                databaseReference.setValue(registrationData);
                Toast.makeText(Registration.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Registration.this,StateListActivity.class);
                startActivity(intent);
            }
        });


    }
}