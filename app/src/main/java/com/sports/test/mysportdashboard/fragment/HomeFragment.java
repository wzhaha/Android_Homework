package com.sports.test.mysportdashboard.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sports.test.mysportdashboard.R;
import com.sports.test.mysportdashboard.activity.TeacherActivity;
import com.sports.test.mysportdashboard.utils.GlideImageLoder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    private List mlist;//图片
    private List<String> titleList;//图片标题

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        //Banner图
        Banner banner=view.findViewById(R.id.main_banner);
        mlist=new ArrayList<>();
        mlist.add(R.mipmap.banner1);
        mlist.add(R.mipmap.banner2);
        mlist.add(R.mipmap.banner3);

        titleList=new ArrayList<>();
        titleList.add("banner1");
        titleList.add("banner2");
        titleList.add("banner3");

        banner.setImageLoader(new GlideImageLoder());
        banner.setImages(mlist);
        banner.setBannerTitles(titleList);
        banner.setDelayTime(3000);
        banner.setBannerAnimation(Transformer.Stack);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

        return view;
    }
}
