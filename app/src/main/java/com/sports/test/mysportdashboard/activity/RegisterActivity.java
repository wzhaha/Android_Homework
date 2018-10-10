package com.sports.test.mysportdashboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sports.test.mysportdashboard.R;

public class RegisterActivity extends Activity{
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.register);
        TextView login=findViewById(R.id.login);
        Button register=findViewById(R.id.register);
        final EditText res_userid=findViewById(R.id.res_userid);
        final EditText password=findViewById(R.id.res_password);
        final EditText enurePassword=findViewById(R.id.password_ensure);
        //注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=res_userid.getText().toString();
                String pass=password.getText().toString();
                String ensurePass=enurePassword.getText().toString();
                if(id.length()==0)
                    Toast.makeText(RegisterActivity.this,"账号不能为空",Toast.LENGTH_LONG).show();
                else if(pass.length()==0||ensurePass.length()==0)
                    Toast.makeText(RegisterActivity.this,"密码不可为空",Toast.LENGTH_LONG).show();
                else if(!pass.equals(ensurePass))
                    Toast.makeText(RegisterActivity.this,"两次输入密码不一致",Toast.LENGTH_LONG).show();
                else if(pass.length()<6)
                    Toast.makeText(RegisterActivity.this,"密码长度应大于六位",Toast.LENGTH_LONG).show();
                //注册成功
                else{
                    /** 请求服务器完成注册
                     *
                     */
                    Intent it=new Intent(RegisterActivity.this,ButtomMenuActivity.class);
                    it.putExtra("userId",id);
                    startActivity(it);
                }
            }
        });

        ///点击已有账号
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}
