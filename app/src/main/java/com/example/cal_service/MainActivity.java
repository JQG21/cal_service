package com.example.cal_service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyServiceTag";  //

    Service_cal service_cal = null;
    Button start,stop,add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.v(TAG, "onServiceConnect()");
                service_cal = ((Service_cal.LocalBinder) iBinder).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.v(TAG, "onServiceDisconnected()");
            }
        };
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(new Intent(MainActivity.this,Service_cal.class),serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(service_cal!=null){
                    Log.v(TAG,"add service:"+service_cal.add(1,2));
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(service_cal!=null){
                    Log.v(TAG,"sub service:"+service_cal.sub(5,2));
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(service_cal!=null){
                    Log.v(TAG,"mul service:"+service_cal.mul(5,2));
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(service_cal!=null){
                    Log.v(TAG,"div service:"+service_cal.div(6,2));
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(serviceConnection);
            }
        });

    }
}