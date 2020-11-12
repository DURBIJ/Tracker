package com.durbijkewat.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class memorisation {




    // update funcation it will update the mobile number changes{
    public static void updates(String[] mNumber) {

        ArrayList<String> numbers = new ArrayList<>();


//          At most 5 numbers user can enter
        for (int i = 0; i < 5; i++) {

//            checking either number is entered by user or not(empty or Null)
//            in MainActivity putting Null in string if string is empty
            if (mNumber[i] != null) {
                numbers.add(mNumber[i]);
            }
        }

//        saving the data in sharedPreferences  which are changes by user (Mobile number) in mainActivity
        try {
            MainActivity.sharedPreferences.edit().putString("mNumbers", ObjectSerializer.serialize(numbers)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

// }





//      Filling the text editor with the mobile numbers which are stored in sharedPreferences { Start


    public static void fill(ArrayList<String> mNumber){



        for(int i=0;i<mNumber.size();i++) {

//            checking either number is their or empty
            if (mNumber.get(i) != null) {
                MainActivity.Phone[i].setText(mNumber.get(i));

//                updating counts for handling plus minus button in MainActivity
                MainActivity.cnts = i;


//            if more then one numbers was saved then un hiding the text editor and Removing button (minus)
            if (i > 0) {
                MainActivity.Phone[i].setVisibility(View.VISIBLE);
                MainActivity.minus.setVisibility(View.VISIBLE);
            }

//            if maximum limit of number reached then hiding add more Text editor button
            if (i == 4) {
                MainActivity.plus.setVisibility(View.INVISIBLE);
            }
        }
        }
    }


//    } End



//    Removing last element from storage when user is Removing any (minus)  family mobile numbers from the database{ Start

    public static void removeLast(ArrayList<String> numbers){

//        At least one mobile number is compulsory
        if(numbers.size()>1){
//            removing last number from saved mobile number
            numbers.remove(numbers.size()-1);

//            updating sharedPreferences while removing saved mobile number
            try {
                MainActivity.sharedPreferences.edit().putString("mNumbers", ObjectSerializer.serialize(numbers)).apply();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    } End

}
