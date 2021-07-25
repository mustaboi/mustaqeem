package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Reminder extends AppCompatActivity {
    recyclerAdaptor adaptor;
    ArrayList<remind> list= new ArrayList<>();
    RecyclerView rview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        rview= findViewById(R.id.rcycler);


    }
}