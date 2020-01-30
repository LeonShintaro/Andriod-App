package com.zhaowei.shi.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.zhaowei.shi.assignment.Bean.food;
import com.zhaowei.shi.assignment.R;

public class myadapter extends BaseAdapter  implements View.OnClickListener {
    private List<food> mylist;
    private LayoutInflater layoutInflater;
    private int num=0;
    private Context context;
    public myadapter(Context context){
        mylist =new ArrayList<food>();
        mylist.add(new food("Coffee",4));
        mylist.add(new food("Salad",544));
        mylist.add(new food("Soft Drink",172));
        mylist.add(new food("Nuts",1800));
        mylist.add(new food("Chicken",752));
        mylist.add(new food("Beef",1152));
        mylist.add(new food("Rolls",1064));
        mylist.add(new food("Pork",1084));
        mylist.add(new food("Burger",1168));
        mylist.add(new food("Alcohol",1352));
        mylist.add(new food("Dairy",288));
        layoutInflater=LayoutInflater.from(context);
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

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ti_add){
            num++;
            Toast.makeText(context,"add",Toast.LENGTH_SHORT).show();
        }
        if(v.getId() == R.id.ti_dl){
            num--;
            Toast.makeText(context,"delete",Toast.LENGTH_SHORT).show();
        }
    }


    public final class Vieholder{
        public TextView ti_tv_01;
        public TextView ti_tv_02;
        public ImageView add_ti;
        public TextView  ti_tv_03;
        public ImageView  ti_dl;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
       num=position;
        Vieholder vieholder ;
        if(view==null){
            vieholder =new Vieholder();
            view =layoutInflater.inflate(R.layout.the_item,null);
            vieholder.ti_tv_01 =(TextView)view.findViewById(R.id.it_tv_01);
            vieholder.ti_tv_02 =(TextView) view.findViewById(R.id.ti_tv_02);
            vieholder.add_ti =view.findViewById(R.id.ti_add);
            vieholder.ti_tv_03 =view.findViewById(R.id.ti_tv_03);
            vieholder.ti_dl =view.findViewById(R.id.ti_dl);
            vieholder.add_ti.setOnClickListener(this);
            vieholder.ti_dl.setOnClickListener(this);
           // vieholder.ti_tv_03.setText(num);
            view.setTag(vieholder);
        }else{
            vieholder =(Vieholder) view.getTag();
            vieholder.add_ti.setOnClickListener(this);
            vieholder.ti_dl.setOnClickListener(this);
            vieholder.ti_tv_03.setText(num);
        }
        //Load data
        food bean =mylist.get(position);
        vieholder.ti_tv_01.setText(bean.getName());
        vieholder.ti_tv_02.setText(bean.getEne()+"KJ");
        //vieholder.ti_tv_03.setText(num);
        return view;
    }
}
