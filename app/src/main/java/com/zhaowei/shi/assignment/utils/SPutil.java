package com.zhaowei.shi.assignment.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPutil {
    private  static SharedPreferences sp;

    public static void put_lock_imformation(Context context,String key,String value){
        sp =context.getSharedPreferences("config_lock",Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
    public static String get_lock_imformation(Context context,String key,String defvalue){
        sp =context.getSharedPreferences("config_lock",Context.MODE_PRIVATE);
        return sp.getString(key,defvalue);
    }


    public static void put_count(Context context,String key,int value){
        sp=context.getSharedPreferences("config1",Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
    public static int get_count(Context context,String key,int defvalue){
        sp=context.getSharedPreferences("config1",Context.MODE_PRIVATE);
        return  sp.getInt(key,defvalue);
    }


    public static void put_answer(Context context,String key,int value){
        sp=context.getSharedPreferences("config1",Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }
    public static int get_answer(Context context,String key,int defvalue){
            sp=context.getSharedPreferences("config1",Context.MODE_PRIVATE);
        return sp.getInt(key,defvalue);
    }


    public void clear_sp(Context context){
        sp=context.getSharedPreferences("config1",Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor =sp.edit();
        editor.clear().commit();
    }
}
