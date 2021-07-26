package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class workout extends AppCompatActivity {
    ListView listview;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        b1= findViewById(R.id.button2);
        b2=findViewById(R.id.button15);
        ArrayList<exercise> list =new  ArrayList<>();
        exercise obj = new exercise();
        listview=(ListView)findViewById(R.id.listvieww);
        obj.equipments = "Floor Mat";
        obj.ex_name = "Push ups";
        obj.level = "Beginner";
        list.add(obj);

        DataBaseHandler db = new DataBaseHandler(workout.this);
        ArrayList<exercise> templist= new ArrayList<>();
        templist=db.Get_workout_Data();
        list=templist;
        exerciseAdaptor adapter=new exerciseAdaptor(this,list );
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(workout.this, addworkout.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(workout.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}