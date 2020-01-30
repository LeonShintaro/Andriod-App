package com.zhaowei.shi.assignment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

import com.zhaowei.shi.assignment.R;

import com.zhaowei.shi.assignment.activity.add_activity;

public class Fragment_01 extends Fragment implements View.OnClickListener {

    private DatePicker datePicker;
    private ImageView bt_add;
    private int year;
    private int month;
    private int day;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_01,container,false);
        init(view);
        return view;
    }

    public void init(View view){
        datePicker =view.findViewById(R.id.dp_01);
        bt_add =view.findViewById(R.id.bt_add);
        bt_add.setOnClickListener(this);
        final Calendar c =Calendar.getInstance();
        year =c.get(Calendar.YEAR);
        month =c.get(Calendar.MONTH);
        day =c.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getContext(),"The Current date is" + year + "-" + (pad(monthOfYear + 1)) +"-"+(pad(dayOfMonth)), Toast.LENGTH_SHORT).show();
                bt_add.setVisibility(View.VISIBLE);
            }
        });
    }

    private  String pad(int c){

        if(c>=10){
            return String.valueOf(c);
        }

        else{
            return "0"+String.valueOf(c);
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_add){
            startActivity(new Intent(getActivity(),add_activity.class));
        }
    }
}
