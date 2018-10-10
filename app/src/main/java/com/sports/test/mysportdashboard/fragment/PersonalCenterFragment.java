package com.sports.test.mysportdashboard.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sports.test.mysportdashboard.R;
import com.sports.test.mysportdashboard.activity.MyCourseActivity;
import com.sports.test.mysportdashboard.activity.TeacherActivity;
import com.sports.test.mysportdashboard.activity.UserInfoActivity;

public class PersonalCenterFragment extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_center, container, false);
        View userinfo=view.findViewById(R.id.userinfo);
        userinfo.setOnClickListener(this);
        View showtrainers=view.findViewById(R.id.showtrainers);
        showtrainers.setOnClickListener(this);
        View mysourse=view.findViewById(R.id.mysourse);
        mysourse.setOnClickListener(this);
        View myorder=view.findViewById(R.id.myorder);
        myorder.setOnClickListener(this);
        View set=view.findViewById(R.id.set);
        set.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view){
        int source=view.getId();
        switch (source){
            case R.id.userinfo:
                Intent userinfo=new Intent();
                userinfo.setClass(this.getActivity(),UserInfoActivity.class);
                startActivity(userinfo);
                break;
            case R.id.showtrainers:
                Intent intent1=new Intent();
                intent1.setClass(this.getActivity(),TeacherActivity.class);
                startActivity(intent1);
                break;
            case R.id.mysourse:
                Intent mycourse=new Intent();
                mycourse.setClass(this.getActivity(),MyCourseActivity.class);
                startActivity(mycourse);
                break;
            case R.id.myorder:
                Toast.makeText(this.getContext(),"我的订单",Toast.LENGTH_LONG);
                break;
            case R.id.set:
                Toast.makeText(this.getContext(),"设置",Toast.LENGTH_LONG);
                break;
        }
    }
}
