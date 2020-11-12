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

//mail format in regex
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";


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

//checking either user had entered name or not(empty)
            if(TextUtils.isEmpty(FullName)){
                fullName.setError("Name is Required");
                return;
            }


//checking either user had entered phone number or not
            if(TextUtils.isEmpty(phoneNo)){
                uPhone.setError("Mobile Number is Required");
                return;
            }


//checking entered number  format is correct or not
                if((MainActivity.valMobile(phoneNo)==false)){
                    uPhone.setError("Enter Valid Number");
                    return;
                }




//checking either licence key is entered or not
            if(TextUtils.isEmpty(key)){
                lKey.setError("Key is Required");
                return;
            }

//checking either Email address is entered by user or not if entered then it format is correct or not
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