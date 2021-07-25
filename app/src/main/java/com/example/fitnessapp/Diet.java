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
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        lv=findViewById(R.id.dietlist);
        food obj = new food();
        DietAdaptor adapter=new DietAdaptor(this,list );
        obj.name="High Carb Diet";
        obj.type="Keto Diet";
        obj.contents="Rice, Salmon with sauteed Tofu";
        list.add(obj);
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

        boolean flag = getIntent().getBooleanExtra("flag",false);
        if(flag)
        {
            food obj1 = new food();
            String x = getIntent().getStringExtra("name");
            String y = getIntent().getStringExtra("type");
            String z = getIntent().getStringExtra("cont");
            obj1.setName(x);
            obj1.setType(y);
            obj1.setContents(z);
            list.add(obj1);
            adapter.notifyDataSetChanged();
        }
    }
}
