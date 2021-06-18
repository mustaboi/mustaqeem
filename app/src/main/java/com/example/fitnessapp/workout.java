package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class workout extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        ArrayList<exercise> list =new  ArrayList<>();
        exercise obj = new exercise();
        obj.equipments = "kfja";
        obj.ex_name = "dja";
        obj.level = "dajk";
        list.add(obj);
        exerciseAdaptor adapter=new exerciseAdaptor(this,list );
        listview=(ListView)findViewById(R.id.listvieww);
        listview.setAdapter(adapter);
    }
}