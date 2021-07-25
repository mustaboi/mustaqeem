package com.example.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class exerciseAdaptor extends ArrayAdapter {
    Context c;
    ArrayList<exercise> n;

    public exerciseAdaptor(Context context, ArrayList<exercise> n) {
        super(context,R.layout.exerciselistlayout,n);
        this.c = context;
        this.n = n;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext()) ;
        View layout = inflater.inflate(R.layout.exerciselistlayout, parent,false);
        TextView tv_item1 = layout.findViewById(R.id.textView3);
        TextView tv_item2 = layout.findViewById(R.id.textView4);
        TextView tv_item3 = layout.findViewById(R.id.textView14);
        exercise obj = new exercise();
        obj = n.get(position);
        String x = obj.getEquipments();
        String y = obj.getEx_name();
        String z = obj.getLevel();
        tv_item1.setText(z);
        tv_item2.setText(y);
        tv_item3.setText(x);

        return layout;
    }
}
