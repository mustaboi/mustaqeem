package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class dailytasks extends AppCompatActivity {
     ListView listView;
     Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailytasks);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button13);
        ArrayList<task> list =new  ArrayList<>();

        task obj = new task();

        listView=(ListView)findViewById(R.id.tasklist);
       obj.task_name = "Brushing Teeth";
        obj.description = "brushing your teeth for a few minutes develops oral hygiene ";

        list.add(obj);

        DataBaseHandler db = new DataBaseHandler(dailytasks.this);
        ArrayList<task> templist= new ArrayList<>();
        templist=db.Get_task_Data();
        list=templist;
        task_Adaptor adapter=new task_Adaptor(this,list );
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(dailytasks.this, add_task.class);

                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(dailytasks.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}