package com.zhaowei.shi.assignment.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.zhaowei.shi.assignment.Adapter.seek_data_adapter;
import com.zhaowei.shi.assignment.Bean.ene_record;
import com.zhaowei.shi.assignment.MyDatabase.MyDataBaseHelper;
import com.zhaowei.shi.assignment.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_03 extends Fragment implements View.OnClickListener {
    private Button bt_clean;
    private Button bt_seek_data;
    private ListView lv;

    private MyDataBaseHelper myDataBaseHelper;
    private SQLiteDatabase db;

    private List<ene_record> list =new ArrayList<ene_record>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_03,container,false);
        bt_clean =view.findViewById(R.id.bt_clean);
        bt_clean.setOnClickListener(this);
        bt_seek_data =view.findViewById(R.id.bt_seek);
        bt_seek_data.setOnClickListener(this);
        lv =view.findViewById(R.id.lv_seek_dt);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_clean){
            myDataBaseHelper =new MyDataBaseHelper(getActivity().getApplicationContext(),"test_01",null,1);
            db =myDataBaseHelper.getWritableDatabase();
            db.delete("food_list",null,null);
            db.delete("ene_list",null,null);
            db.close();
        }

        if (v.getId() == R.id.bt_seek){
            myDataBaseHelper = new MyDataBaseHelper(getActivity().getApplicationContext(),"test_01",null,1);
            db =myDataBaseHelper.getReadableDatabase();

            String sql_select ="select * from ene_list";
            Cursor cursor =db.rawQuery(sql_select,null);
            if (cursor!=null){
                list.clear();
                while(cursor.moveToNext()){
                    ene_record e1 =new ene_record();
                    e1.setMonth(cursor.getString(0));
                    e1.setWeek(cursor.getString(1));
                    e1.setDay(cursor.getString(2));
                    e1.setEne(cursor.getString(3));
                    list.add(e1);
                }
                lv.setAdapter(new seek_data_adapter(getActivity().getApplicationContext(),list));

            }else{
                list.clear();
                Toast.makeText(getActivity().getApplicationContext(),"No data found!",Toast.LENGTH_SHORT).show();
            }
            db.close();
            cursor.close();
        }
    }
}
