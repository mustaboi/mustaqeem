package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addworkout extends AppCompatActivity {
    TextView txt1,txt2,txt3;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworkout);
        txt1=(TextView)findViewById(R.id.exname);
        txt3=(TextView)findViewById(R.id.exlevel);
        txt2=(TextView)findViewById(R.id.exequip);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x,y,z;
                x=txt1.getText().toString();
                y=txt2.getText().toString();
                z=txt3.getText().toString();
                Intent intent = new Intent(addworkout.this,workout.class);
                intent.putExtra("name",x);
                intent.putExtra("level",y);
                intent.putExtra("equip",z);
                intent.putExtra("flag",true);
                startActivity(intent);
            }
        });


    }
}