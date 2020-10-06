package com.example.cal_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;

public class Service_cal extends Service {
    private static final String TAG = "MyServiceTag";

    public Service_cal() {
    }

    public void onCreate(){
        super.onCreate();
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        return super.onStartCommand(intent,flags,startId);
    }

    public void onDestroy(){
        Log.v(TAG,"onDestroy()");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
