package com.durbijkewat.tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static SharedPreferences sharedPreferences;
    static Button submit,plus,minus;
    static EditText [] Phone=new EditText [5];
    ProgressBar progressBar;
    static int cnts=0;
    static ArrayList<String> mNumbers =new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    memorisation memorisations;



    // mobile Number validating{

    public static boolean valMobile(String phoneNo){


        if(phoneNo.length()!=10){

            if(!(((phoneNo.length() == 11) && (phoneNo.charAt(0)=='0')) || ((phoneNo.length() == 13) && (phoneNo.charAt(0)=='+') && (phoneNo.charAt(1)=='9') && (phoneNo.charAt(2)=='1')))){
                return false;
            }

        }
        return true;

    }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Phone[0]=findViewById(R.id.phoneNo0);
        Phone[1]=findViewById(R.id.phoneNo1);
        Phone[2]=findViewById(R.id.phoneNo2);
        Phone[3]=findViewById(R.id.phoneNo3);
        Phone[4]=findViewById(R.id.phoneNo4);

        submit = findViewById(R.id.Submit);
        plus=findViewById(R.id.AddPhone);
        minus=findViewById(R.id.DeletePhone);

        memorisations=new memorisation();

        sharedPreferences=this.getSharedPreferences("MyDatas",MODE_PRIVATE);
        mNumbers.clear();

        //deserialize numbers from storage
        try {
            mNumbers=(ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("mNumbers",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        memorisations.fill(mNumbers);



//        Onclick Listener on plus button

        plus.setOnClickListener(view -> {
            if(cnts<4){

                cnts++;
                Phone[cnts].setVisibility(View.VISIBLE);

                if(cnts==1){
                    minus.setVisibility(View.VISIBLE);
                }
                if(cnts==4){
                    plus.setVisibility(View.INVISIBLE);
                }

            }
            else{
//                code??
            }
        });





//        Onclick Listener on minus button
        minus.setOnClickListener(view -> {Log.i("tag ","minus");
            if(cnts>0){

                Phone[cnts].setVisibility(View.INVISIBLE);
                Phone[cnts].getText().clear();      //clearing the text editer when doing invisible
                cnts--;



//            Updating mobile number Storage
                memorisations.removeLast(mNumbers);


                if(cnts==0){
                    minus.setVisibility(View.INVISIBLE);
                }

                if(cnts<4){
                    plus.setVisibility(View.VISIBLE);
                }

            }
            else{
//                code??
            }
        });






//        Onclick Listener on submit button

        submit.setOnClickListener(view -> {

            final String [] phoneNo = new String[5];
            phoneNo[0] = Phone[0].getText().toString().trim();
            phoneNo[1] = Phone[1].getText().toString().trim();
            phoneNo[2] = Phone[2].getText().toString().trim();
            phoneNo[3] = Phone[3].getText().toString().trim();
            phoneNo[4] = Phone[4].getText().toString().trim();


//            Validation{

            if(TextUtils.isEmpty(phoneNo[0]) && TextUtils.isEmpty(phoneNo[1]) && TextUtils.isEmpty(phoneNo[2]) && TextUtils.isEmpty(phoneNo[3]) && TextUtils.isEmpty(phoneNo[4])){
                Phone[0].setError("At Least one Mobile Number is Required");
                return;
            }


            if(!TextUtils.isEmpty(phoneNo[0]) && valMobile(phoneNo[0])==false){
                Phone[0].setError("Enter Valid Mobile Number");
                return;
            }


            if(!TextUtils.isEmpty(phoneNo[1]) && valMobile(phoneNo[1])==false){
                Phone[1].setError("Enter Valid Mobile Number");
                return;
            }


            if(!TextUtils.isEmpty(phoneNo[2]) && valMobile(phoneNo[2])==false){
                Phone[2].setError("Enter Valid Mobile Number");
                return;
            }


            if(!TextUtils.isEmpty(phoneNo[3]) && valMobile(phoneNo[3])==false){
                Phone[3].setError("Enter Valid Mobile Number");
                return;
            }


            if(!TextUtils.isEmpty(phoneNo[4]) && valMobile(phoneNo[4])==false){
                Phone[4].setError("Enter Valid Mobile Number");
                return;
            }

//            Assined null to all number which are empty{
            for(int i=0;i<5;i++){
                if(TextUtils.isEmpty(phoneNo[i])){
                    phoneNo[i]=null;
                }
            }

//            Updating mobile number Storage
            memorisations.updates(phoneNo);

//            }

            Log.i("Mb 2= ","kjk"+phoneNo[1]);
            Log.i("Tag= ",phoneNo[0]);




        });


    }
}