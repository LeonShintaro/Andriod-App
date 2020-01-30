package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaowei.shi.assignment.R;

public class Food_menu_activity extends AppCompatActivity implements View.OnClickListener {

        private ImageView bt_back,bt_config,bt_01_add,bt_01_dl,
                 bt_02_add,bt_02_dl,
                 bt_03_add,bt_03_dl,
                 bt_04_add,bt_04_dl,
                 bt_05_add,bt_05_dl,
                 bt_06_add,bt_06_dl,
                 bt_07_add,bt_07_dl,
                 bt_08_add,bt_08_dl,
                 bt_09_add,bt_09_dl,
                 bt_10_add,bt_10_dl,
                 bt_11_add,bt_11_dl;

        private TextView tv_01_01,tv_01_02,tv_01_03,
                tv_02_01,tv_02_02,tv_02_03,
                tv_03_01,tv_03_02,tv_03_03,
                tv_04_01,tv_04_02,tv_04_03,
                tv_05_01,tv_05_02,tv_05_03,
                tv_06_01,tv_06_02,tv_06_03,
                tv_07_01,tv_07_02,tv_07_03,
                tv_08_01,tv_08_02,tv_08_03,
                tv_09_01,tv_09_02,tv_09_03,
                tv_10_01,tv_10_02,tv_10_03,
                tv_11_01,tv_11_02,tv_11_03;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodmenu);
        bindviews();

    }

    public void bindviews(){

        tv_01_03 =findViewById(R.id.ti_tv_01);
        tv_02_03 =findViewById(R.id.ti_tv_02);
        tv_03_03 =findViewById(R.id.ti_tv_03);
        tv_04_03 =findViewById(R.id.ti_tv_04);
        tv_05_03 =findViewById(R.id.ti_tv_05);
        tv_06_03 =findViewById(R.id.ti_tv_06);
        tv_07_03 =findViewById(R.id.ti_tv_07);
        tv_08_03 =findViewById(R.id.ti_tv_08);
        tv_09_03 =findViewById(R.id.ti_tv_09);
        tv_10_03 =findViewById(R.id.ti_tv_10);
        tv_11_03 =findViewById(R.id.ti_tv_11);



        bt_back =findViewById(R.id.bt_back);
        bt_config =findViewById(R.id.bt_config);
        bt_back.setOnClickListener(this);
        bt_config.setOnClickListener(this);
        bt_01_add =findViewById(R.id.ti_01_add);
        bt_01_dl =findViewById(R.id.ti_01_dl);
        bt_02_add =findViewById(R.id.ti_02_add);
        bt_02_dl =findViewById(R.id.ti_02_dl);
        bt_03_add =findViewById(R.id.ti_03_add);
        bt_03_dl =findViewById(R.id.ti_03_dl);
        bt_04_add =findViewById(R.id.ti_04_add);
        bt_04_dl =findViewById(R.id.ti_04_dl);

        bt_05_add =findViewById(R.id.ti_05_add);
        bt_05_dl =findViewById(R.id.ti_05_dl);

        bt_06_add =findViewById(R.id.ti_06_add);
        bt_06_dl =findViewById(R.id.ti_06_dl);

        bt_07_add =findViewById(R.id.ti_07_add);
        bt_07_dl =findViewById(R.id.ti_07_dl);

        bt_08_add =findViewById(R.id.ti_08_add);
        bt_09_dl =findViewById(R.id.ti_09_dl);

        bt_10_add =findViewById(R.id.ti_10_add);
        bt_10_dl =findViewById(R.id.ti_10_dl);

        bt_11_add =findViewById(R.id.ti_11_add);
        bt_11_dl =findViewById(R.id.ti_11_dl);

        bt_04_add =findViewById(R.id.ti_04_add);
        bt_04_dl =findViewById(R.id.ti_04_dl);

        bt_04_add =findViewById(R.id.ti_04_add);
        bt_04_dl =findViewById(R.id.ti_04_dl);

        bt_04_add =findViewById(R.id.ti_04_add);
        bt_04_dl =findViewById(R.id.ti_04_dl);

        bt_04_add =findViewById(R.id.ti_04_add);
        bt_04_dl =findViewById(R.id.ti_04_dl);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_back){

            startActivity(new Intent(Food_menu_activity.this,add_activity.class));finish();
        }
        if(v.getId() == R.id.bt_config){
        }

    }


}
