package com.sports.test.mysportdashboard.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sports.test.mysportdashboard.R;
import com.sports.test.mysportdashboard.fragment.course.AllCourseFragment;
import com.sports.test.mysportdashboard.fragment.course.FitCourseFragment;
import com.sports.test.mysportdashboard.fragment.course.HappyCourseFragment;
import com.sports.test.mysportdashboard.fragment.course.JianzhiCourseFragment;

public class CourseFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course, container, false);

        Button all_course=view.findViewById(R.id.all_course);
        all_course.setOnClickListener(this);

        Button fit_course=view.findViewById(R.id.fit_course);
        fit_course.setOnClickListener(this);

        Button jianzhi_course=view.findViewById(R.id.jianzhi_course);
        jianzhi_course.setOnClickListener(this);

        Button happy_course=view.findViewById(R.id.happy_course);
        happy_course.setOnClickListener(this);
        //fragment嵌套获取当前fragment中的fragment
        System.out.print(savedInstanceState);

        getChildFragmentManager().beginTransaction().replace(R.id.course_fragment,new AllCourseFragment()).commit();
        return view;
    }

    @Override
    public void onClick(View view){
        int buttonid=view.getId();
        switch (buttonid){
            case R.id.all_course:
                getChildFragmentManager().beginTransaction().replace(R.id.course_fragment,new AllCourseFragment()).commit();
                break;
            case R.id.fit_course:
                getChildFragmentManager().beginTransaction().replace(R.id.course_fragment,new FitCourseFragment()).commit();
                break;
            case R.id.jianzhi_course:
                getChildFragmentManager().beginTransaction().replace(R.id.course_fragment,new JianzhiCourseFragment()).commit();
                break;
            case R.id.happy_course:
                getChildFragmentManager().beginTransaction().replace(R.id.course_fragment,new HappyCourseFragment()).commit();
                break;
        }
    }
}
