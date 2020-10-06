package com.example.cal_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View v){
        int i = v.getId();
        switch(i){
            case R.id.start:
                startService(new Intent(MainActivity.this,Service_cal.class));
            case R.id.stop:
                stopService(new Intent(MainActivity.this,Service_cal.class));
        }
    }
}