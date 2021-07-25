package com.example.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DietAdaptor extends ArrayAdapter {
    Context c;
    ArrayList<food> task_list;

    public DietAdaptor(Context context, ArrayList<food> n) {
        super(context,R.layout.diet_item,n);
        this.c = context;
        this.task_list = n;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext()) ;
        View layout = inflater.inflate(R.layout.diet_item, parent,false);
        TextView tv_item1 = layout.findViewById(R.id.textView15);
        TextView tv_item2 = layout.findViewById(R.id.textView16);
        TextView tv_item3 = layout.findViewById(R.id.textView20);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        ImageView imgview= layout.findViewById(R.id.imageView3);
        food obj = new food();
        obj = task_list.get(position);
        String x = obj.getName();
        String y = obj.getType();
        String z = obj.getContents();
        tv_item1.setText(x);
        tv_item2.setText(y);
        tv_item3.setText(z);


        if(y=="Keto Diet") {
            DatabaseReference getImage = databaseReference.child("keto");

            getImage.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String link = snapshot.getValue(String.class);
                    Picasso.get().load(link).into(imgview);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else if(y=="atkins Diet"){
            DatabaseReference getImage2 = databaseReference.child("Atkins");
            getImage2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String link = snapshot.getValue(String.class);
                    Picasso.get().load(link).into(imgview);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else{
            DatabaseReference getImage3 = databaseReference.child("vegan");
            getImage3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String link = snapshot.getValue(String.class);
                    Picasso.get().load(link).into(imgview);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        return layout;
    }

}
