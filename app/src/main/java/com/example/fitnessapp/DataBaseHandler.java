package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

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
    private static String diet_level = "level";
    private Context context;
    public DataBaseHandler(Context context)
    {
        super(context,DB_NAME,null,1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_Query =  "CREATE TABLE "+TBL_NAME1+" ( "+remind_NAME+" TEXT, "+remind_time+" TEXT);";
        db.execSQL(Create_Query);
        Toast.makeText(context, "Reminder Table Created Successfully", Toast.LENGTH_SHORT).show();

       String Create_Query2 = "CREATE TABLE "+TBL_NAME2+" ("+workout_NAME+" TEXT, "+workout_level+" TEXT,"+workout_equip+" TEXT);";
        db.execSQL(Create_Query2);
        Toast.makeText(context, "Workout Table Created Successfully", Toast.LENGTH_SHORT).show();

       String Create_Query3 = "CREATE TABLE "+TBL_NAME3+" ("+task_NAME+" TEXT, "+task_description+" TEXT);";
        db.execSQL(Create_Query3);
        Toast.makeText(context, "Task Table Created Successfully", Toast.LENGTH_SHORT).show();
      String  Create_Query4 = "CREATE TABLE "+TBL_NAME4+" ("+diet_NAME+" TEXT, "+diet_des+" TEXT, "+diet_level+" TEXT);";
        db.execSQL(Create_Query4);
        Toast.makeText(context, "Diet Table Created Successfully", Toast.LENGTH_SHORT).show();
    }
    public void ins_remind_Data(remind obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(remind_NAME, obj.getRem_name());
        String temp= obj.getDt().toString();
        value.put(remind_time, temp);
        db.insert(TBL_NAME1, null, value);
    }
    public void ins_task_Data(task obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(task_NAME, obj.getTask_name());
        String temp= obj.getDescription();
        value.put(task_description, temp);
        db.insert(TBL_NAME3, null, value);
        Toast.makeText(context, "Insert Succesful", Toast.LENGTH_SHORT).show();
    }
    public void ins_diet_Data(food obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(diet_NAME, obj.getName());
        value.put(diet_des, obj.getContents());
        value.put(diet_level, obj.getType());
        db.insert(TBL_NAME4, null, value);
    }
    public void ins_work_Data(exercise obj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(workout_NAME, obj.getEx_name());
        value.put(workout_level,obj.getLevel());
        value.put(workout_equip,obj.getEquipments());
        db.insert(TBL_NAME2, null, value);
    }

    public ArrayList<remind> Get_remind_Data() {
        ArrayList<remind> ArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String Read_Query = "SELECT * FROM "+ TBL_NAME1;
        Cursor cursor = db.rawQuery(Read_Query, null);
        if(cursor.moveToFirst()) {
            do {
                remind read_obj = new remind();
                read_obj.setRem_name(cursor.getString(0));
                read_obj.setDt(cursor.getString(1));
                ArrayList.add(read_obj);
            } while (cursor.moveToNext());
        }
        return ArrayList;
    }
    public ArrayList<exercise> Get_workout_Data() {
        ArrayList<exercise> ArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String Read_Query = "SELECT * FROM "+ TBL_NAME2;
        Cursor cursor = db.rawQuery(Read_Query, null);
        if(cursor.moveToFirst()) {
            do {
                exercise read_obj = new exercise();
                read_obj.setEx_name(cursor.getString(0));
                read_obj.setLevel(cursor.getString(1));
                read_obj.setEquipments(cursor.getString(2));
                ArrayList.add(read_obj);
            } while (cursor.moveToNext());
        }
        return ArrayList;
    }
    public ArrayList<task> Get_task_Data() {
        ArrayList<task> ArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String Read_Query = "SELECT * FROM "+ TBL_NAME3;
        Cursor cursor = db.rawQuery(Read_Query, null);
        if(cursor.moveToFirst()) {
            do {
                task read_obj = new task();
                read_obj.setTask_name(cursor.getString(0));
                read_obj.setDescription(cursor.getString(1));
                ArrayList.add(read_obj);
            } while (cursor.moveToNext());
        }
        Toast.makeText(context, "Retrive Succesful", Toast.LENGTH_SHORT).show();
        return ArrayList;
    }
    public ArrayList<food> Get_diet_Data() {
        ArrayList<food> ArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String Read_Query = "SELECT * FROM "+ TBL_NAME4;
        Cursor cursor = db.rawQuery(Read_Query, null);
        if(cursor.moveToFirst()) {
            do {
                food read_obj = new food();
                read_obj.setName(cursor.getString(0));
                read_obj.setType(cursor.getString(2));
                read_obj.setContents(cursor.getString(1));
                ArrayList.add(read_obj);
            } while (cursor.moveToNext());
        }
        return ArrayList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME1);
            db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME2);
            db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME3);
            db.execSQL("DROP TABLE IF EXISTS " + TBL_NAME4);
            onCreate(db);
        }

    }
}
