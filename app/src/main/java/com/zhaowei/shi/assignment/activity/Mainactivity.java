package com.zhaowei.shi.assignment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhaowei.shi.assignment.Fragment.Fragment_01;
import com.zhaowei.shi.assignment.Fragment.Fragment_02;
import com.zhaowei.shi.assignment.Fragment.Fragment_03;
import com.zhaowei.shi.assignment.R;

public class Mainactivity extends AppCompatActivity implements View.OnClickListener {
    private  static  final String TAG ="TabFragmentActivity";
    private FragmentTabHost tabHost;
    private ImageView bt_01,bt_02,bt_03;
    private FragmentManager fragmentManager;
    private Fragment_01 fragment_01;
    private Fragment_02 fragment_02;
    private Fragment_03 fragment_03;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = this.getSupportFragmentManager();
        bindViews();

        FragmentTransaction transaction_1 =fragmentManager.beginTransaction();
        transaction_1 =fragmentManager.beginTransaction();


        fragment_02 =new Fragment_02();
        transaction_1.add(R.id.ly_content,fragment_02);
        transaction_1.show(fragment_02);
        transaction_1.commit();
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
                if(fragment_02 == null){fragment_02 =new Fragment_02();transaction.add(R.id.ly_content,fragment_02);}
                else{transaction.show(fragment_02);}

            }
            if(v.getId() == R.id.bt_03){
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                if(fragment_03 == null){fragment_03 =new Fragment_03();transaction.add(R.id.ly_content,fragment_03);}
                else{transaction.show(fragment_03);}

            }

            transaction.commit();
    }
}
