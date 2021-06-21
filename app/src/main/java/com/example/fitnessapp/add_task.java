package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class add_task extends AppCompatActivity {
 TextView txt1,txt2;
 Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        txt1=(TextView)findViewById(R.id.Title);
        txt2=(TextView)findViewById(R.id.Dscrpt);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x,y;
                x=txt1.getText().toString();
                y=txt2.getText().toString();
                Intent intent = new Intent(add_task.this,dailytasks.class);
                intent.putExtra("title",x);
                intent.putExtra("dis",y);
                intent.putExtra("flag",true);
                startActivity(intent);
            }
        });

    }


}