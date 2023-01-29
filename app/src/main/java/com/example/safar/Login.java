package com.example.safar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {
    EditText num1;
    EditText num2;
    EditText num3;
    EditText num4;
    EditText num5;
    EditText num6;
    EditText num7;
    EditText num8;
    EditText num9;
    EditText num10;
    Button genOtp;
    EditText mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        num6=findViewById(R.id.num6);
        num7=findViewById(R.id.num7);
        num8=findViewById(R.id.num8);
        num9=findViewById(R.id.num9);
        num10=findViewById(R.id.num10);
        genOtp=findViewById(R.id.genOtp);
        mobile=findViewById(R.id.mobile);
        String mob=num1.getText().toString().trim() + num2.getText().toString().trim()  +
                num3.getText().toString().trim()  + num4.getText().toString().trim()
                + num5.getText().toString().trim()  + num6.getText().toString().trim()  +
                num7.getText().toString().trim()  + num8.getText().toString().trim()
                + num9.getText().toString().trim()  + num10.getText().toString().trim() ;
        genOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(mob!=null)

                {
                    String req="+91"+num1.getText().toString().trim() + num2.getText().toString().trim()  +
                            num3.getText().toString().trim()  + num4.getText().toString().trim()
                            + num5.getText().toString().trim()  + num6.getText().toString().trim()  +
                            num7.getText().toString().trim()  + num8.getText().toString().trim()
                            + num9.getText().toString().trim()  + num10.getText().toString().trim();
                    Toast.makeText(Login.this,req,Toast.LENGTH_SHORT).show();
                    // sendOtop(req);
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(req, 60, TimeUnit.SECONDS
                            , Login.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                @Override
                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


                                }

                                @Override
                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                    Toast.makeText(Login.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();

                                }

                                @Override
                                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                    Intent intent=new Intent(getApplicationContext(),Verification.class);
                                    intent.putExtra("backendOtp",s);
                                    startActivity(intent);

                                }
                            });






                }
                else
                {
                    Toast.makeText(Login.this,"Please Enter all Numbers",Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(Login.this,mob,Toast.LENGTH_SHORT).show();
            }
        });




        move();

        //Intent intent=new Intent(Login.this,Verification.class);
        //startActivity(intent);

    }

    private void sendOtop(String req) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(req, 60, TimeUnit.SECONDS
                , Login.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        // Toast.makeText(Login.this,"Completed",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Login.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Login.this,mob,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        Intent intent=new Intent(getApplicationContext(),Verification.class);
                        intent.putExtra("mobile",req);
                        //Toast.makeText(Login.this,s,Toast.LENGTH_SHORT).show();
                        intent.putExtra("backendOtp",s);
                        startActivity(intent);

                    }
                });
    }


    private  void move()
    {
       num1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {
               if(!s.toString().trim().isEmpty())
               {
                  num2.requestFocus();
               }

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num7.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num8.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num9.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        num9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty())
                {
                    num10.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}