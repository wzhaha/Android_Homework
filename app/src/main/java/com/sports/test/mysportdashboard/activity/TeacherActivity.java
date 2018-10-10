package com.sports.test.mysportdashboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.sports.test.mysportdashboard.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherActivity extends Activity{
    private ListView listView;
    private List<Map<String,Object>> list_map = new ArrayList<>(); //定义一个适配器对象
    private String[] name = {"张雷","王洪","文章"};  //定义一个名字数组，用来为数据源提供姓名
    private int[] images = {R.mipmap.trainer1,R.mipmap.trainer2,R.mipmap.trainer3};//定义一个 整形数组，用来为数据源中的头像

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacherlist);
        listView=findViewById(R.id.teacherlist);
        for(int i=0;i<name.length;i++){
            Map<String,Object> items = new HashMap<>(); //创建一个键值对的Map集合，用来存放名字和头像
            items.put("pic", images[i]);  //放入头像， 根据下标获取数组
            items.put("name", name[i]);      //放入名字， 根据下标获取数组
            list_map.add(items);   //把这个存放好数据的Map集合放入到list中，这就完成类数据源的准备工作
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this.getBaseContext(),/*传入一个上下文作为参数*/
                list_map,         /*传入相对应的数据源，这个数据源不仅仅是数据而且还是和界面相耦合的混合体。*/
                R.layout.teacher_list_item, /*设置具体某个items的布局，需要是新的布局，而不是ListView控件的布局*/
                new String[]{"pic","name"}, /*传入上面定义的键值对的键名称,会自动根据传入的键找到对应的值*/
                new int[]{R.id.header,R.id.name});/*传入items布局文件中需要指定传入的控件，这里直接上id即可*/
        listView.setAdapter(simpleAdapter);

    }
}
