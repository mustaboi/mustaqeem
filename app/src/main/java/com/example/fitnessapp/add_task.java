package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class add_task extends AppCompatActivity {
 EditText txt1,txt2;
 Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        txt1=(EditText) findViewById(R.id.ex_name);
        txt2=(EditText) findViewById(R.id.ex_equip);
        b1=(Button) findViewById(R.id.button);
        b2=findViewById(R.id.button11);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(add_task.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x,y;
                x=txt1.getText().toString();
                y=txt2.getText().toString();
                Intent intent = new Intent(add_task.this,dailytasks.class);
                DataBaseHandler db = new DataBaseHandler(add_task.this);
                task temp=new task(x,y);
                db.ins_task_Data(temp);
                startActivity(intent);
            }
        });

    }


}