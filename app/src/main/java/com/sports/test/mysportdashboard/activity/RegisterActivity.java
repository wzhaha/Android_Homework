package com.sports.test.mysportdashboard.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sports.test.mysportdashboard.R;

public class RegisterActivity extends Activity{
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.register);
        TextView login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}
