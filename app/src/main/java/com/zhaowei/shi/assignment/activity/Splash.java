package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.zhaowei.shi.assignment.MyDatabase.MyDataBaseHelper;
import com.zhaowei.shi.assignment.R;
import com.zhaowei.shi.assignment.utils.StatusBarUtil;

import java.util.Calendar;

public class Splash extends AppCompatActivity {
    private  long sleep =5000l;
    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        StatusBarUtil.setTranslucentStatus(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                        init_data();


                startActivity(new Intent(Splash.this, Mainactivity.class));finish();
            }
        },sleep);


    }

    public void init_data(){
        Calendar calendar =Calendar.getInstance();
        String month =String.valueOf(calendar.get(Calendar.MONTH));
        String week  =String.valueOf(calendar.get(Calendar.WEEK_OF_MONTH));
        String day   =String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        Intent intent =new Intent(Splash.this, Mainactivity.class);
        Bundle bundle = new Bundle();

        myDataBaseHelper =new MyDataBaseHelper(Splash.this,"test_01",null,1);
        db=myDataBaseHelper.getReadableDatabase();

        String select_day ="select ene from ene_list where month=? and week=? and day=?";
        Cursor cursor_day  =db.rawQuery(select_day,new String[]{month,week,day});

        if(cursor_day.moveToNext()){

            bundle.putString("day",cursor_day.getString(0));
            Log.d("day_day:",cursor_day.getString(0));

        }else{Toast.makeText(getApplicationContext(),"No data recorded!",Toast.LENGTH_SHORT).show();
        }

        String select_week="select ene from ene_list where month=? and week=?";
        Cursor cursor_week =db.rawQuery(select_week,new String[]{month,week});
        if (cursor_week.moveToNext()){
            int temp =0;
            while(cursor_week.moveToNext()) {
                    int ene =Integer.parseInt(cursor_week.getString(0));
                    Log.d("day_week:",cursor_week.getString(0));
                    temp=temp+ene;
            }
            String week_ene =format(temp/7.0);
            bundle.putString("week",week_ene);
        }


        String select_month ="select ene from ene_list where month=?";
        Cursor cursor_month =db.rawQuery(select_month,new String[]{month});

        if(cursor_month.moveToNext()){
            int temp =0;
            while(cursor_month.moveToNext()){
                int ene =Integer.parseInt(cursor_month.getString(0));
                Log.d("day_month:",cursor_month.getString(0));
                temp=temp+ene;
            }
            String month_ene =format(temp/30.0);
            bundle.putString("month",month_ene);
        }

        intent.putExtras(bundle);
        db.close();
        startActivity(intent);
    }

    public String format(double d){
        return String.format("%.2f",d);

    }
}
