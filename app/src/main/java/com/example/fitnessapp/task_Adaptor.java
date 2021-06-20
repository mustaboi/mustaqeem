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

public class task_Adaptor extends ArrayAdapter {
    Context c;
    ArrayList<task> task_list;

    public task_Adaptor(Context context, ArrayList<task> n) {
        super(context,R.layout.dailytasklist_layout,n);
        this.c = context;
        this.task_list = n;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext()) ;
        View layout = inflater.inflate(R.layout.dailytasklist_layout, parent,false);
        TextView tv_item1 = layout.findViewById(R.id.tvTitle);
        TextView tv_item2 = layout.findViewById(R.id.tvDescription);
        task obj = new task();
        obj = task_list.get(position);
        String x = obj.getTask_name();
        String y = obj.getDescription();
        tv_item1.setText(x);
        tv_item2.setText(y);
        return layout;
    }

}
