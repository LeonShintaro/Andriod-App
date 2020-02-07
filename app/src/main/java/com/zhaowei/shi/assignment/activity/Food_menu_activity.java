package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaowei.shi.assignment.MyDatabase.MyDataBaseHelper;
import com.zhaowei.shi.assignment.R;

public class Food_menu_activity extends AppCompatActivity implements View.OnClickListener {

        private MyDataBaseHelper myDataBaseHelper;
        private SQLiteDatabase db;

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

        private Button bt_save_fm;

        int num=0;

        int num_f [] ={0,0,0,0,0,0,0,0,0,0,0,0};//12
        String name [] ={"Coffe","Salad","Soft Drink","Nuts","Chicken","Beef","Rolls","Pork","Burger","Alchol","Dairy"};//11
        int ene []={4,544,172,1800,752,1152,1064,1084,1168,1352,288};//11

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
        bt_01_add.setOnClickListener(this);
        bt_01_dl.setOnClickListener(this);

        bt_02_add =findViewById(R.id.ti_02_add);
        bt_02_dl =findViewById(R.id.ti_02_dl);
        bt_02_add.setOnClickListener(this);
        bt_02_dl.setOnClickListener(this);

        bt_03_add =findViewById(R.id.ti_03_add);
        bt_03_dl =findViewById(R.id.ti_03_dl);
        bt_03_add.setOnClickListener(this);
        bt_03_dl.setOnClickListener(this);

        bt_04_add =findViewById(R.id.ti_04_add);
        bt_04_dl =findViewById(R.id.ti_04_dl);
        bt_04_add.setOnClickListener(this);
        bt_04_dl.setOnClickListener(this);

        bt_05_add =findViewById(R.id.ti_05_add);
        bt_05_dl =findViewById(R.id.ti_05_dl);
        bt_05_add.setOnClickListener(this);
        bt_05_dl.setOnClickListener(this);

        bt_06_add =findViewById(R.id.ti_06_add);
        bt_06_dl =findViewById(R.id.ti_06_dl);
        bt_06_add.setOnClickListener(this);
        bt_06_dl.setOnClickListener(this);

        bt_07_add =findViewById(R.id.ti_07_add);
        bt_07_dl =findViewById(R.id.ti_07_dl);
        bt_07_add.setOnClickListener(this);
        bt_07_dl.setOnClickListener(this);

        bt_08_add =findViewById(R.id.ti_08_add);
        bt_08_dl =findViewById(R.id.ti_08_dl);
        bt_08_add.setOnClickListener(this);
        bt_08_dl.setOnClickListener(this);

        bt_09_add =findViewById(R.id.ti_09_add);
        bt_09_dl =findViewById(R.id.ti_09_dl);
        bt_09_add.setOnClickListener(this);
        bt_09_dl.setOnClickListener(this);

        bt_10_add =findViewById(R.id.ti_10_add);
        bt_10_dl =findViewById(R.id.ti_10_dl);
        bt_10_add.setOnClickListener(this);
        bt_10_dl.setOnClickListener(this);

        bt_11_add =findViewById(R.id.ti_11_add);
        bt_11_dl =findViewById(R.id.ti_11_dl);
        bt_11_add.setOnClickListener(this);
        bt_11_dl.setOnClickListener(this);

        bt_save_fm =findViewById(R.id.save_fm);

        bt_save_fm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_back){

            startActivity(new Intent(Food_menu_activity.this, add_activity.class));finish();
        }
        if(v.getId() == R.id.bt_config){
        }

        if (v.getId() == R.id.ti_01_add){num_f[1]++;tv_01_03.setText(String.valueOf(num_f[1]));}
        if(v.getId() == R.id.ti_01_dl){
            if(num_f[1]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[1]--;tv_01_03.setText(String.valueOf(num_f[1]));
            }

        }

        if (v.getId() == R.id.ti_02_add){num_f[2]++;tv_02_03.setText(String.valueOf(num_f[2]));}
        if(v.getId() == R.id.ti_02_dl){
            if(num_f[2]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[2]--;tv_02_03.setText(String.valueOf(num_f[2]));
            }

        }

        if (v.getId() == R.id.ti_03_add){num_f[3]++;tv_03_03.setText(String.valueOf(num_f[3]));}
        if(v.getId() == R.id.ti_03_dl){
            if(num_f[3]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[3]--;tv_03_03.setText(String.valueOf(num_f[3]));
            }
        }

        if (v.getId() == R.id.ti_04_add){num_f[4]++;tv_04_03.setText(String.valueOf(num_f[4]));}
        if(v.getId() == R.id.ti_04_dl){
            if(num_f[4]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[4]--;tv_04_03.setText(String.valueOf(num_f[4]));
            }

        }

        if (v.getId() == R.id.ti_05_add){num_f[5]++;tv_05_03.setText(String.valueOf(num_f[5]));}
        if(v.getId() == R.id.ti_05_dl){
            if(num_f[5]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[5]--;tv_05_03.setText(String.valueOf(num_f[5]));
            }

        }

        if (v.getId() == R.id.ti_06_add){num_f[6]++;tv_06_03.setText(String.valueOf(num_f[6]));}
        if(v.getId() == R.id.ti_06_dl){
            if(num_f[6]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[6]--;tv_06_03.setText(String.valueOf(num_f[6]));
            }

        }

        if (v.getId() == R.id.ti_07_add){num_f[7]++;tv_07_03.setText(String.valueOf(num_f[7]));}
        if(v.getId() == R.id.ti_07_dl){
            if(num_f[7]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[7]--;tv_07_03.setText(String.valueOf(num_f[7]));
            }

        }

        if (v.getId() == R.id.ti_08_add){num_f[8]++;tv_08_03.setText(String.valueOf(num_f[8]));}
        if(v.getId() == R.id.ti_08_dl){
            if(num_f[8]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[8]--;tv_08_03.setText(String.valueOf(num_f[8]));
            }

        }

        if (v.getId() == R.id.ti_09_add){num_f[9]++;tv_09_03.setText(String.valueOf(num_f[9]));}
        if(v.getId() == R.id.ti_09_dl){
            if(num_f[9]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[9]--;tv_09_03.setText(String.valueOf(num_f[9]));
            }

        }

        if (v.getId() == R.id.ti_10_add){num_f[10]++;tv_10_03.setText(String.valueOf(num_f[10]));}
        if(v.getId() == R.id.ti_10_dl){
            if(num_f[10]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[10]--;tv_10_03.setText(String.valueOf(num_f[10]));
            }

        }

        if (v.getId() == R.id.ti_11_add){num_f[11]++;tv_11_03.setText(String.valueOf(num_f[11]));}
        if(v.getId() == R.id.ti_11_dl){
            if(num_f[11]<=0){
                Toast.makeText(getApplicationContext(),"Choice can not be less than 0",Toast.LENGTH_SHORT).show();
            }
            else{
                num_f[11]--;tv_11_03.setText(String.valueOf(num_f[11]));
            }

        }

        if(v.getId() == R.id.save_fm){

            myDataBaseHelper =new MyDataBaseHelper(Food_menu_activity.this,"test_01",null,1);
            db =myDataBaseHelper.getWritableDatabase();


            String insert_sq ="insert into food_list(name,num,ene) values(?,?,?)";

            for(int i=1;i<12;i++){
                if(num_f[i]!=0){
                    int temp =num_f[i]*ene[i-1];
                    db.execSQL(insert_sq,new String[] {name[i-1],String.valueOf(num_f[i]),String.valueOf(temp)});
                }

            }

            for(int i=1;i<12;i++){
                num_f[i]=0;
            }
            tv_01_03.setText(String.valueOf(num_f[1]));
            tv_02_03.setText(String.valueOf(num_f[2]));
            tv_03_03.setText(String.valueOf(num_f[3]));
            tv_04_03.setText(String.valueOf(num_f[4]));
            tv_05_03.setText(String.valueOf(num_f[5]));
            tv_06_03.setText(String.valueOf(num_f[6]));
            tv_07_03.setText(String.valueOf(num_f[7]));
            tv_08_03.setText(String.valueOf(num_f[8]));
            tv_09_03.setText(String.valueOf(num_f[9]));
            tv_10_03.setText(String.valueOf(num_f[10]));
            tv_11_03.setText(String.valueOf(num_f[11]));
            db.close();

        }
    }


}
