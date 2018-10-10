package com.sports.test.mysportdashboard.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import com.sports.test.mysportdashboard.fragment.CourseFragment;
import com.sports.test.mysportdashboard.fragment.HomeFragment;
import com.sports.test.mysportdashboard.fragment.PersonalCenterFragment;
import com.sports.test.mysportdashboard.R;

public class ButtomMenuActivity extends AppCompatActivity{
    private static boolean isExit=false;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            isExit=false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttom_menu_main);
        Toolbar toolbar=findViewById(R.id.toolbar_buttom);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView=findViewById(R.id.design_bottom_sheet);
        //首次进入是进入主页面
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_menu,new HomeFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_menu,new HomeFragment()).commit();
                        return true;
                    case R.id.courses:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_menu,new CourseFragment()).commit();
                        return true;
                    case R.id.my:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_menu,new PersonalCenterFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    private void exit(){
        if(!isExit){
            isExit=true;
            Toast.makeText(getApplicationContext(),"再按一退出程序",Toast.LENGTH_SHORT).show();
            //利用handler延迟发送更改状态信息
            handler.sendEmptyMessageDelayed(0,2000);
        }
        else{
            finish();
            System.exit(0);
        }
    }

}
