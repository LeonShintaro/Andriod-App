package com.zhaowei.shi.assignment.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhaowei.shi.assignment.R;

public class Fragment_02 extends Fragment {
    private String day_ene;
    private String week_ene;
    private String month_ene;

    private TextView tv_01;
    private TextView tv_02;
    private TextView tv_03;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_02,container,false);
        tv_01 = view.findViewById(R.id.tv_01);
        tv_02 = view.findViewById(R.id.tv_02);
        tv_03 = view.findViewById(R.id.tv_03);
        getdata_M();
        tv_01.setText(day_ene+"KJ");
        tv_02.setText(week_ene+"KJ");
        tv_03.setText(month_ene+"KJ");
        return view;
    }

    public void getdata_M(){
        Bundle bundle =this.getArguments();
        day_ene =bundle.getString("day","NONE");
        week_ene =bundle.getString("week","NONE");
        month_ene =bundle.getString("month","NONE");
    }
}
