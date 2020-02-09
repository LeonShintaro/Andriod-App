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

    private boolean isExit=false;


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

            }
        },sleep);


    }

    public void init_data(){
        Calendar calendar =Calendar.getInstance();
        String month =String.valueOf(calendar.get(Calendar.MONTH)+1);
        String week  =String.valueOf(calendar.get(Calendar.WEEK_OF_MONTH));
        String day   =String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        Intent intent =new Intent(Splash.this, Mainactivity.class);
        Bundle bundle = new Bundle();

        myDataBaseHelper =new MyDataBaseHelper(Splash.this,"test_01",null,1);
        db=myDataBaseHelper.getReadableDatabase();

        String select_day ="select ene from ene_list where month=?  and day=?";
        Cursor cursor_day  =db.rawQuery(select_day,new String[]{month,day});

        if(cursor_day!=null){
            int temp =0;
            while (cursor_day.moveToNext()){
                temp=temp+Integer.parseInt(cursor_day.getString(0));
            }
            bundle.putString("day",String.valueOf(temp));
            Log.d("day_day:",""+temp);

        }else{Toast.makeText(getApplicationContext(),"No data recorded yet!",Toast.LENGTH_SHORT).show();
        }
        cursor_day.close();
        String select_week="select ene from ene_list where month=? and week=?";
        Cursor cursor_week =db.rawQuery(select_week,new String[]{month,week});
        if (cursor_week!=null){
            int temp =0;
            while(cursor_week.moveToNext()) {
                    int ene =Integer.parseInt(cursor_week.getString(0));
                    Log.d("day_week:",cursor_week.getString(0));
                    temp=temp+ene;
            }
            String week_ene =format(temp/7.0);
            Log.d("week_week:",""+week_ene);
            bundle.putString("week",week_ene);
        }
        cursor_week.close();

        String select_month ="select ene from ene_list where month=?";
        Cursor cursor_month =db.rawQuery(select_month,new String[]{month});

        if(cursor_month!=null){
            int temp =0;
            while(cursor_month.moveToNext()){
                int ene =Integer.parseInt(cursor_month.getString(0));
                Log.d("day_month:",cursor_month.getString(0));
                temp=temp+ene;
            }
            String month_ene =format(temp/30.0);
            Log.d("month_month:",month_ene);
            bundle.putString("month",month_ene);
        }
        cursor_month.close();
        intent.putExtras(bundle);
        db.close();
        startActivity(intent);finish();
    }

    public String format(double d){
        return String.format("%.2f",d);

    }

    @Override
    public void onBackPressed() {
        if (isExit) {
            finish();
        } else {
            //Click once then the notification pops up
            Toast.makeText(this, "Tap again to exit the app", Toast.LENGTH_SHORT).show();
            isExit = true;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isExit = false;
                }
            }.start();
        }
    }
}
