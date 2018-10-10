package com.sports.test.mysportdashboard.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;

import com.sports.test.mysportdashboard.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserInfoActivity extends Activity{
    TextView birthday;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.userinfo);
        //TextView gender=findViewById(R.id.gender);
        final Spinner spinner=findViewById(R.id.spinner);
        birthday=findViewById(R.id.birthday);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, getGenderData());
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private List<String> getGenderData() {
        // 数据源
        List<String> dataList = new ArrayList<String>();
        dataList.add("男");
        dataList.add("女");
        return dataList;
    }

    private void showDatePickerDialog() {
        Calendar c = Calendar.getInstance();
        new DatePickerDialog(this, DatePickerDialog.THEME_DEVICE_DEFAULT_LIGHT,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                birthday.setText(year+"/"+(monthOfYear+1)+"/"+dayOfMonth);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();

    }
}
