package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Edwin");
        friends.add("James");
        friends.add("Muthoni");

        //serialize
        try {
            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
            Log.i("friends",ObjectSerializer.serialize(friends));


        }
        catch (Exception e){
            e.printStackTrace();
        }

            //information coming out of shared preferences
        //deserialize

            ArrayList<String> newFriends = new ArrayList<>();
        try{
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("new friends",newFriends.toString());


        //putting information into the shared preferences
        //sharedPreferences.edit().putString("username","edwin").apply();
        //grab information from the shared preferences
        //String username = sharedPreferences.getString("username", "");

        //Log.i("This is the username", username);
    }
}