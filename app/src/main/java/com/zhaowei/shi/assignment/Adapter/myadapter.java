package com.zhaowei.shi.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhaowei.shi.assignment.Bean.food_list_q_item;
import com.zhaowei.shi.assignment.R;

import java.util.List;

public class myadapter extends BaseAdapter   {
    private List<food_list_q_item> mylist;
    private LayoutInflater layoutInflater;
    private int num=0;
    private Context context;
    public myadapter(Context context, List<food_list_q_item> list){
        mylist =list;
        this.context =context;
    }
    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    public final class Vieholder{
        public TextView ti_tv_01;
        public TextView ti_tv_02;
        public TextView  ti_tv_03;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Vieholder vieholder ;
        if(view==null){
            vieholder =new Vieholder();
            view =View.inflate(context, R.layout.the_item,null);
            vieholder.ti_tv_01 =(TextView)view.findViewById(R.id.it_tv_01);
            vieholder.ti_tv_02 =(TextView) view.findViewById(R.id.ti_tv_02);
            vieholder.ti_tv_03 =(TextView) view.findViewById(R.id.ti_tv_03);
            view.setTag(vieholder);
        }else{
            vieholder =(Vieholder) view.getTag();

        }
        //Load data
        food_list_q_item bean =mylist.get(position);
        vieholder.ti_tv_01.setText(bean.getName());
        vieholder.ti_tv_02.setText(bean.getNum());
        vieholder.ti_tv_03.setText(bean.getEne()+"KJ");
        return view;
    }
}
