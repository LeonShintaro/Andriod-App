package com.zhaowei.shi.assignment.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaowei.shi.assignment.Adapter.myadapter;
import com.zhaowei.shi.assignment.Bean.food_list_q_item;
import com.zhaowei.shi.assignment.MyDatabase.MyDataBaseHelper;
import com.zhaowei.shi.assignment.R;

import java.util.ArrayList;
import java.util.List;

public class add_activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView bt_back,bt_add_f;
    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;
    private List<food_list_q_item> list =new ArrayList<food_list_q_item>();

    private ListView lv_list;
    private Button save_day;

   static int month,week,day;

    private boolean isExit=false;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        get_my_Intent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        lv_list =findViewById(R.id.lv_aa);
        bt_back =findViewById(R.id.bt_back);
        bt_add_f =findViewById(R.id.bt_add_f);
        bt_back.setOnClickListener(this);
        bt_add_f.setOnClickListener(this);
        save_day =findViewById(R.id.save_day);
        save_day.setOnClickListener(this);
        getData();

    }

    public void get_my_Intent(){
        Intent intent =getIntent();
        Bundle bundle =intent.getExtras();
        if(bundle == null){
            Toast.makeText(getApplicationContext(),month+"-"+week+"-"+day,Toast.LENGTH_SHORT).show();
        }
        else{
            month =bundle.getInt("month");
            week =bundle.getInt("week");
            day =bundle.getInt("day");
            Toast.makeText(getApplicationContext(),month+"-"+week+"-"+day,Toast.LENGTH_SHORT).show();
        }

    }

    public void  getData(){
        myDataBaseHelper =new MyDataBaseHelper(add_activity.this,"test_01",null,1);
        db =myDataBaseHelper.getReadableDatabase();
        String select_sql ="select name,num,ene from food_list";
        Cursor cursor =db.rawQuery(select_sql,null);
        if(cursor!=null){
            list.clear();
            while(cursor.moveToNext()){
                food_list_q_item f1 =new food_list_q_item();
                f1.setName(cursor.getString(0));
                f1.setNum(cursor.getString(1));
                f1.setEne(cursor.getString(2));
                Log.d("data:",""+f1.getName());
                list.add(f1);
            }

        }
        else{
            list.clear();
            Toast.makeText(getApplicationContext(),"No selection made!",Toast.LENGTH_SHORT).show();

        }

        lv_list.setAdapter(new myadapter(add_activity.this,list));
        lv_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String name,num,ene;
                TextView tv_temp =view.findViewById(R.id.it_tv_01);
                TextView tv_temp_01 =view.findViewById(R.id.it_tv_02);
                name =tv_temp.getText().toString();
                num =tv_temp_01.getText().toString();
                alert_edit(name,num);
                return false;
            }
        });


        db.close();
        cursor.close();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_back){

            startActivity(new Intent(add_activity.this, Mainactivity.class));finish();
        }
        if(v.getId() == R.id.bt_add_f){
            startActivity(new Intent(add_activity.this, Food_menu_activity.class));finish();

        }
        if(v.getId() == R.id.save_day){
            myDataBaseHelper = new MyDataBaseHelper(getApplicationContext(),"test_01",null,1);
            db =myDataBaseHelper.getReadableDatabase();

            String select_ene ="select ene from food_list";
            Cursor cursor_ene =db.rawQuery(select_ene,null);
            if(cursor_ene!=null){
                int total=0;
                while(cursor_ene.moveToNext()){
                    Log.d("add_a_ene:",cursor_ene.getString(0));
                    total =total+Integer.parseInt(cursor_ene.getString(0));
                }
                db.delete("food_list",null,null);

                db.close();
                cursor_ene.close();

                db =myDataBaseHelper.getWritableDatabase();
                String inisert_day ="insert into ene_list(month,week,day,ene) values(?,?,?,?)";
                //Toast.makeText(getApplicationContext(),month+"-"+week+"-"+day,Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(),""+String.valueOf(month)+"-"+String.valueOf(week)
                  //      +"-"+String.valueOf(day)+"-"+String.valueOf(total),Toast.LENGTH_SHORT).show();
                db.execSQL(inisert_day,new String[]{String.valueOf(month),String.valueOf(week),String.valueOf(day),String.valueOf(total)});
                db.close();

                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Mainactivity.class));finish();
            }
            else{
                Toast.makeText(getApplicationContext(),"No selection made!",Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void alert_edit(String name, String num){
        final String name_temp =name;
        final String num_temp =num;
        new AlertDialog.Builder(this).setTitle("Are you sure to delete the data：")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myDataBaseHelper =new MyDataBaseHelper(add_activity.this,"test_01",null,1);
                        db =myDataBaseHelper.getWritableDatabase();

                        String delete_sql ="delete from food_list where name=? and num=?";
                        db.execSQL(delete_sql,new String[]{name_temp,num_temp});
                        db.close();
                        getData();
                    }
                })
                .setNegativeButton("Cancel",null).show();
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
