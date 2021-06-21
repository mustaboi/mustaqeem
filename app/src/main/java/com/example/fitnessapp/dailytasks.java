package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class dailytasks extends AppCompatActivity {
     ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailytasks);
        ArrayList<task> list =new  ArrayList<>();
        task obj = new task();
        task_Adaptor adapter=new task_Adaptor(this,list );
        listView=(ListView)findViewById(R.id.tasklist);
        obj.task_name = "Brushing Teeth";
        obj.description = "brushing your teeth for a few minutes develops oral hygiene ";
        list.add(obj);
        listView.setAdapter(adapter);

        boolean flag = getIntent().getBooleanExtra("flag",false);
        if(flag)
        {
            task obj1 = new task();
            String x = getIntent().getStringExtra("title");
            String y = getIntent().getStringExtra("dis");
            obj1.setTask_name(x);
            obj1.setDescription(y);
            list.add(obj1);
            adapter.notifyDataSetChanged();
        }

    }
}