package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addReminder extends AppCompatActivity {
    EditText t1,t2;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        t1=findViewById(R.id.textView23);
        t2=findViewById(R.id.textView24);
        btn1=findViewById(R.id.button8);
        btn2=findViewById(R.id.button9);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(addReminder.this, Reminder.class);
                String x= t1.getText().toString();
                String y= t1.getText().toString();
                remind temp= new remind(x,y);
                DataBaseHandler db= new DataBaseHandler(addReminder.this);
                db.ins_remind_Data(temp);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(addReminder.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}