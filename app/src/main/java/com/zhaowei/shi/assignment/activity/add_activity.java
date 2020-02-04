package com.zhaowei.shi.assignment.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.zhaowei.shi.assignment.Adapter.myadapter;
import com.zhaowei.shi.assignment.Bean.food_list_q_item;
import com.zhaowei.shi.assignment.MyDatabase.MyDataBaseHelper;
import com.zhaowei.shi.assignment.R;

import java.util.ArrayList;
import java.util.List;

public class add_activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView bt_back,bt_add_f,bt_shua;
    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;
    private List<food_list_q_item> list =new ArrayList<food_list_q_item>();

    private ListView lv_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        lv_list =findViewById(R.id.lv_aa);
        bt_back =findViewById(R.id.bt_back);
        bt_add_f =findViewById(R.id.bt_add_f);
        bt_shua =findViewById(R.id.bt_shua);
        bt_back.setOnClickListener(this);
        bt_add_f.setOnClickListener(this);
        bt_shua.setOnClickListener(this);
    }

    public void  getData(){
        myDataBaseHelper =new MyDataBaseHelper(add_activity.this,"zhaoweishi",null,1);
        db =myDataBaseHelper.getReadableDatabase();
        String select_sql ="select name,num,ene from food_list";
        Cursor cursor =db.rawQuery(select_sql,null);
        if(cursor.moveToNext()){
            while(cursor.moveToNext()){
                food_list_q_item f1 =new food_list_q_item();
                f1.setName(cursor.getString(0));
                f1.setNum(cursor.getString(1));
                f1.setEne(cursor.getString(2));
                Log.d("data:",f1.getName()+"  "+f1.getNum()+"  "+f1.getEne());
                list.add(f1);
            }

        }
        else{
            Toast.makeText(getApplicationContext(),"No selection made!",Toast.LENGTH_SHORT).show();

        }


        db.close();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_back){

            startActivity(new Intent(add_activity.this, Mainactivity.class));finish();
        }
        if(v.getId() == R.id.bt_add_f){
            startActivity(new Intent(add_activity.this, Food_menu_activity.class));finish();

        }
        if(v.getId() == R.id.bt_shua){
            getData();
            lv_list.setAdapter(new myadapter(add_activity.this,list));
        }
    }
}
