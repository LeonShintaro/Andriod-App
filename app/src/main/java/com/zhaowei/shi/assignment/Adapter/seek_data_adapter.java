package com.zhaowei.shi.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhaowei.shi.assignment.Bean.ene_record;
import com.zhaowei.shi.assignment.R;

import java.util.List;

public class seek_data_adapter extends BaseAdapter {
        private List<ene_record> list;
        private LayoutInflater inflater;
        private Context context;

    public seek_data_adapter(Context context, List<ene_record> list) {
        this.list =list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public final class Vieholder{
            private TextView tv_month;
            private TextView tv_week;
            private TextView tv_day;
            private TextView ene;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Vieholder vieholder;
        if(view ==null){
            vieholder =new Vieholder();
            view =View.inflate(context, R.layout.record_item,null);
            vieholder.tv_month =view.findViewById(R.id.tv_month);
            vieholder.tv_week =view.findViewById(R.id.tv_week);
            vieholder.tv_day =view.findViewById(R.id.tv_day);
            vieholder.ene =view.findViewById(R.id.tv_ene);
            view.setTag(vieholder);
        }else{
            vieholder =(Vieholder) view.getTag();
        }

        ene_record e1 =list.get(position);
        vieholder.tv_month.setText(e1.getMonth());
        vieholder.tv_week.setText(e1.getWeek());
        vieholder.tv_day.setText(e1.getDay());
        vieholder.ene.setText(e1.getEne()+"KJ");
        return view;
    }
}
