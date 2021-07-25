package com.example.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdaptor extends RecyclerView.Adapter<recyclerAdaptor.ViewHolder> {

    Context c;
    ArrayList<remind> list;
    public recyclerAdaptor(Context context, ArrayList<remind> list) {
        this.c = context;
        this.list = list;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.reminlist_layout,parent,false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull recyclerAdaptor.ViewHolder holder, int position) {
        remind object;

        object = list.get(position);
        holder.t1.setText(object.getRem_name());
        String temp= object.getDt().toString();
        holder.t2.setText(temp);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remind itemLabel = list.get(position);
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,list.size());
                Toast.makeText(c,"Removed : " + itemLabel,Toast.LENGTH_LONG).show();
            }
        });
       if(holder.c1.isChecked()){
           Toast.makeText(c, "User Already logged in", Toast.LENGTH_LONG).show();
       }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageButton button;
        CheckBox c1;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            t1= itemView.findViewById(R.id.textView18);
            t2 = itemView.findViewById(R.id.textView19);
            button= itemView.findViewById(R.id.imageButton2);
            c1= itemView.findViewById(R.id.checkBox3);

        }
    }

}
