package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhaowei.shi.assignment.Fragment.Fragment_01;
import com.zhaowei.shi.assignment.Fragment.Fragment_02;
import com.zhaowei.shi.assignment.Fragment.Fragment_03;
import com.zhaowei.shi.assignment.MyDatabase.MyDataBaseHelper;
import com.zhaowei.shi.assignment.R;

import java.util.Calendar;

public class Mainactivity extends AppCompatActivity implements View.OnClickListener {
    private  static  final String TAG ="TabFragmentActivity";
    private FragmentTabHost tabHost;
    private ImageView bt_01,bt_02,bt_03;
    private FragmentManager fragmentManager;
    private Fragment_01 fragment_01;
    private Fragment_02 fragment_02;
    private Fragment_03 fragment_03;

    private static String month_ene;
    private static String week_ene;
    private static String day_ene;

    private boolean isExit=false;

    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = this.getSupportFragmentManager();
        get_data_f_S();
        get_data_temp();
        bindViews();

        FragmentTransaction transaction_1 =fragmentManager.beginTransaction();
        transaction_1 =fragmentManager.beginTransaction();


        fragment_02 =new Fragment_02();
        Bundle bundle =new Bundle();
        bundle.putString("month",month_ene);
        bundle.putString("week",week_ene);
        bundle.putString("day",day_ene);
        fragment_02.setArguments(bundle);
        transaction_1.add(R.id.ly_content,fragment_02);
        transaction_1.show(fragment_02);
        transaction_1.commit();
    }

    public void get_data_f_S(){
        Intent intent =getIntent();
        Bundle bundle= intent.getExtras();
        if (bundle !=null){
            month_ene =bundle.getString("month","NONE");
            week_ene =bundle.getString("week","NONE");
            day_ene =bundle.getString("day","NONE");
        }

    }

    public void get_data_temp(){
        Calendar calendar =Calendar.getInstance();
        String month =String.valueOf(calendar.get(Calendar.MONTH)+1);
        String week  =String.valueOf(calendar.get(Calendar.WEEK_OF_MONTH));
        String day   =String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

        myDataBaseHelper =new MyDataBaseHelper(Mainactivity.this,"test_01",null,1);
        db=myDataBaseHelper.getReadableDatabase();

        String select_day ="select ene from ene_list where month=?  and day=?";
        Cursor cursor_day  =db.rawQuery(select_day,new String[]{month,day});

        if(cursor_day!=null){
            int temp =0;
            while (cursor_day.moveToNext()){
                temp=temp+Integer.parseInt(cursor_day.getString(0));
            }
            day_ene =String.valueOf(temp);
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
            String week_ene_01 =format(temp/7.0);
            week_ene =week_ene_01;
            Log.d("week_week:",""+week_ene);
            ;
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
            String month_ene_01 =format(temp/30.0);
            Log.d("month_month:",month_ene);
            month_ene=month_ene_01;
        }
        cursor_month.close();
        db.close();

    }
    private  void bindViews() {
        bt_01 =findViewById(R.id.bt_01);
        bt_02 =findViewById(R.id.bt_02);
        bt_03 =findViewById(R.id.bt_03);

        bt_01.setOnClickListener(this);
        bt_02.setOnClickListener(this);
        bt_03.setOnClickListener(this);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fragment_01 != null)fragmentTransaction.hide(fragment_01);
        if(fragment_02 != null)fragmentTransaction.hide(fragment_02);
        if(fragment_03!= null)fragmentTransaction.hide(fragment_03);
    }

    public String format(double d){
        return String.format("%.2f",d);

    }



    @Override
    public void onClick(View v) {
        FragmentTransaction transaction =fragmentManager.beginTransaction();
            hideAllFragment(transaction);
            if(v.getId() == R.id.bt_01){
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                if(fragment_01 == null){fragment_01 =new Fragment_01();transaction.add(R.id.ly_content,fragment_01);}
                else{transaction.show(fragment_01);}

            }
            if(v.getId() == R.id.bt_02){
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                if(fragment_02 == null){fragment_02 =new Fragment_02();
                    Bundle bundle =new Bundle();
                    bundle.putString("month",month_ene);
                    bundle.putString("week",week_ene);
                    bundle.putString("day",day_ene);
                    fragment_02.setArguments(bundle);
                transaction.add(R.id.ly_content,fragment_02);}
                else{transaction.show(fragment_02);}

            }
            if(v.getId() == R.id.bt_03){
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                if(fragment_03 == null){fragment_03 =new Fragment_03();transaction.add(R.id.ly_content,fragment_03);}
                else{transaction.show(fragment_03);}

            }
            transaction.commit();
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
