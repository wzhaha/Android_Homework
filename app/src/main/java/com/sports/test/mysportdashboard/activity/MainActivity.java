package com.sports.test.mysportdashboard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sports.test.mysportdashboard.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button login=findViewById(R.id.login);
        final EditText userid=findViewById(R.id.userid);
        final EditText password=findViewById(R.id.password);
        TextView signup=findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId=userid.getText().toString();
                String pass=password.getText().toString();
                /**
                 * 请求服务器验证账号密码是否正确
                 */
                if(userId.length()==0)
                    Toast.makeText(MainActivity.this,"请输入账号",Toast.LENGTH_LONG).show();
                else if(pass.length()==0)
                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_LONG).show();
                else if(userId.equals("haha@qq.com")&&pass.equals("haha12345")){
                    Intent it=new Intent(MainActivity.this,ButtomMenuActivity.class);
                    it.putExtra("userId",userId);
                    startActivity(it);
                }
                else{
                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(it);
            }
        });

    }
}
