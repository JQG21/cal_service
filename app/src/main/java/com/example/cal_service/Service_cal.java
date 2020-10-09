package com.example.cal_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;

public class Service_cal extends Service {
    private static final String TAG = "MyServiceTag";

    private LocalBinder myBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        Service_cal getService(){
            return Service_cal.this;
        }
    }
    public Service_cal() {
    }

    public void onCreate(){
        Log.v(TAG,"onCreate()");
        super.onCreate();
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        Log.v(TAG,"onStartCommand()");
        return super.onStartCommand(intent,flags,startId);
    }

    public void onDestroy(){
        Log.v(TAG,"onDestroy()");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG,"onBind()");
        return myBinder;
    }

    public boolean onUnBind(Intent intent) {
        Log.v(TAG,"onUnBind()");
        return super.onUnbind(intent);
    }

    public int add(int x,int y){
        return x+y;
    }
    public int sub(int x,int y){
        return x-y;
    }
    public int mul(int x,int y){
        return x*y;
    }
    public float div(int x,int y){
        return (float) x/y;
    }
}
