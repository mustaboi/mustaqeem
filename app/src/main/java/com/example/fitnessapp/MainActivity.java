package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclick_workout(View view){
        Intent intent = new Intent(this, workout.class);
        startActivity(intent);
    }
    public void onclick_diet(View view){
        Intent intent = new Intent(this, Diet.class);
        startActivity(intent);
    }
    public void onclick_routine(View view){
        Intent intent = new Intent(this, dailytasks.class);
        startActivity(intent);
    }
    public void onclick_reminder(View view){
        Intent intent = new Intent(this, Reminder.class);
        startActivity(intent);
    }

}