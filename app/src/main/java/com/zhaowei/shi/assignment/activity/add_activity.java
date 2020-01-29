package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zhaowei.shi.assignment.R;

public class add_activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView bt_back,bt_add_f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        bt_back =findViewById(R.id.bt_back);
        bt_add_f =findViewById(R.id.bt_add_f);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_back){

            startActivity(new Intent(add_activity.this,Mainactivity.class));finish();
        }
        if(v.getId() == R.id.bt_add_f){


        }
    }
}
