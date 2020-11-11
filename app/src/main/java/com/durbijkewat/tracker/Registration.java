package com.durbijkewat.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {


    Button RegisterBtn;
    EditText fullName,lKey,uEmail,uPhone;
    ProgressBar progressBar;


    // Email validating{

    public static boolean valEmail(String inputStr){

        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Log.i("Tag: ", String.valueOf(inputStr.matches(regex)));
        return inputStr.matches(regex);

    }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        RegisterBtn = findViewById(R.id.Register);
        uEmail = findViewById(R.id.EmailId);
        fullName=findViewById(R.id.UserName);
        lKey=findViewById(R.id.licenceKey);
        uPhone=findViewById(R.id.UserMbNo);
        progressBar = findViewById(R.id.progressBar);



//Onclick listener on register button
/*
        RegisterBtn.setOnClickListener(view -> {

            final String email=uEmail.getText().toString().trim();
            final String key = lKey.getText().toString().trim();
            final String FullName = fullName.getText().toString().trim();
            final String phoneNo = uPhone.getText().toString().trim();



// Validating inputs {

            if(TextUtils.isEmpty(FullName)){
                fullName.setError("Name is Required");
                return;
            }



            if(TextUtils.isEmpty(phoneNo)){
                uPhone.setError("Mobile Number is Required");
                return;
            }


            if(phoneNo.length()!=10){

                if(!(((phoneNo.length() == 11) && (phoneNo.charAt(0)=='0')) || ((phoneNo.length() == 13) && (phoneNo.charAt(0)=='+') && (phoneNo.charAt(1)=='9') && (phoneNo.charAt(2)=='1')))){
                    uPhone.setError("Enter Valid Number");
                    return;
                }

            }



            if(TextUtils.isEmpty(key)){
                lKey.setError("Key is Required");
                return;
            }


            if(!TextUtils.isEmpty(email) && valEmail(email)==false){
                uEmail.setError("Enter Valid Email");
                return;
            }


//            }


            progressBar.setVisibility(View.VISIBLE);


        });




*/






//        Opening MainActivity

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}