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
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        b1= findViewById(R.id.button2);
        ArrayList<exercise> list =new  ArrayList<>();
        exercise obj = new exercise();
        exerciseAdaptor adapter=new exerciseAdaptor(this,list );
        listview=(ListView)findViewById(R.id.listvieww);
        obj.equipments = "Floor Mat";
        obj.ex_name = "Push ups";
        obj.level = "Beginner";
        list.add(obj);
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(workout.this, addworkout.class);
                startActivity(intent);
            }
        });
        boolean flag = getIntent().getBooleanExtra("flag",false);
        if(flag)
        {
            exercise obj1 = new exercise();
            String x = getIntent().getStringExtra("name");
            String y = getIntent().getStringExtra("level");
            String z = getIntent().getStringExtra("equip");
            obj1.setEx_name(x);
            obj1.setLevel(y);
            obj1.setEquipments(z);
            list.add(obj1);
            adapter.notifyDataSetChanged();
        }

    }
}