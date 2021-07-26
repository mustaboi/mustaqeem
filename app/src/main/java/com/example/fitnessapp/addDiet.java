package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addDiet extends AppCompatActivity {
   TextView t1,t2,t3;
   Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diet);

        t1=findViewById(R.id.textView7);
        t2=findViewById(R.id.textView13);
        t3=findViewById(R.id.textView21);
        b1= findViewById(R.id.button5);
        b2=findViewById(R.id.button10);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(addDiet.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x,y,z;
                x=t1.getText().toString();
                y=t2.getText().toString();
                z=t3.getText().toString();
                Intent intent = new Intent(addDiet.this,Diet.class);
                DataBaseHandler db = new DataBaseHandler(addDiet.this);
                food temp=new food(x,y,z);
                db.ins_diet_Data(temp);
                startActivity(intent);
            }
        });
    }
}