package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static String DB_NAME = "fitness_record.db";
    private static String TBL_NAME1 = "remindInfo";
    private static String remind_NAME = "name";
    private static String remind_time = "time";
    private static String TBL_NAME2 = "workoutInfo";
    private static String workout_NAME = "name";
    private static String workout_level = "level";
    private static String workout_equip = "equip";
    private static String TBL_NAME3 = "taskInfo";
    private static String task_NAME = "name";
    private static String task_description = "description";
    private static String TBL_NAME4 = "dietInfo";
    private static String diet_NAME = "name";
    private static String diet_des = "des";
    private Context context;
    public DataBaseHandler(Context context)
    {
        super(context,DB_NAME,null,1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Query = "CREATE TABLE "+TBL_NAME1+" ("+remind_NAME+" TEXT, "+remind_time+" TEXT);";
        db.execSQL(Create_Query);
        Toast.makeText(context, "Reminder Table Created Successfully", Toast.LENGTH_SHORT).show();
        Create_Query = "CREATE TABLE "+TBL_NAME1+" ("+remind_NAME+" TEXT, "+remind_time+" TEXT);";
        db.execSQL(Create_Query);
        Toast.makeText(context, "Reminder Table Created Successfully", Toast.LENGTH_SHORT).show();
        Create_Query = "CREATE TABLE "+TBL_NAME1+" ("+remind_NAME+" TEXT, "+remind_time+" TEXT);";
        db.execSQL(Create_Query);
        Toast.makeText(context, "Reminder Table Created Successfully", Toast.LENGTH_SHORT).show();
        Create_Query = "CREATE TABLE "+TBL_NAME1+" ("+remind_NAME+" TEXT, "+remind_time+" TEXT);";
        db.execSQL(Create_Query);
        Toast.makeText(context, "Reminder Table Created Successfully", Toast.LENGTH_SHORT).show();
    }
    public void ins_remind_Data(remind obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(remind_NAME, obj.getRem_name());
        String temp= obj.getDt().toString();
        value.put(remind_time, temp);
        db.insert(TBL_NAME1, null, value);
    }




}
