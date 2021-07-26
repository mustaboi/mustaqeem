package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Diet extends AppCompatActivity {

    ListView lv;
    ArrayList<food> list= new ArrayList<>();
    Button button,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        lv=findViewById(R.id.dietlist);
        b2=findViewById(R.id.button14);
        food obj = new food();
        obj.name="High Carb Diet";
        obj.type="Keto Diet";
        obj.contents="Rice, Salmon with sauteed Tofu";
        list.add(obj);
        DataBaseHandler db = new DataBaseHandler(Diet.this);
        ArrayList<food> templist= new ArrayList<>();
        templist=db.Get_diet_Data();
        list=templist;
        DietAdaptor adapter=new DietAdaptor(this,list );
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        button=findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Diet.this, addDiet.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Diet.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
