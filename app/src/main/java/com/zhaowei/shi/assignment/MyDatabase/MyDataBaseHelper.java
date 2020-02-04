package com.zhaowei.shi.assignment.MyDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private  Context context;

    public static String CREATE_TABLE_FOOD ="create table food_list (" +
            "name string," +
            "num string," +
            "ene string)";

    public static  String CREATE_TABLE_ENE="create table ene_list(" +
            "day string," +
            "ene string)";

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.context =context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FOOD);
        db.execSQL(CREATE_TABLE_ENE);
        Toast.makeText(context,"Successfully created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
