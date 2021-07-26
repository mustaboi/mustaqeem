package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class Reminder extends AppCompatActivity {
    RecyclerView rview;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        rview= findViewById(R.id.rcycler);
        b1= findViewById(R.id.button6);
        b2= findViewById(R.id.button7);
        DataBaseHandler db = new DataBaseHandler(Reminder.this);
        ArrayList<remind> list = new ArrayList<>();
        db.ins_remind_Data(new remind("Pray Namaz","6 AM, 1 PM, 5 PM, 8 PM"));
        db.ins_remind_Data(new remind("Watch tutorials","3 PM"));

        ArrayList<remind> templist= new ArrayList<>();
        templist=db.Get_remind_Data();
        list=templist;
        recyclerAdaptor adapter = new recyclerAdaptor(Reminder.this,list);
        rview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        rview.setLayoutManager(new LinearLayoutManager(Reminder.this));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Reminder.this,addReminder.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Reminder.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}