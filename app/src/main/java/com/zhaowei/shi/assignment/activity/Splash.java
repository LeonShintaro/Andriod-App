package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhaowei.shi.assignment.R;
import com.zhaowei.shi.assignment.utils.StatusBarUtil;

public class Splash extends AppCompatActivity {
    private  long sleep =5000l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        StatusBarUtil.setTranslucentStatus(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,Mainactivity.class));finish();
            }
        },sleep);


    }
}
