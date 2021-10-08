package com.example.mucsicbound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class ServiceMyClass extends Service{
    MediaPlayer mp;
    private MyBinder myBinder =new MyBinder();
    public class MyBinder extends Binder{
        ServiceMyClass getServiceMyClass(){
            return ServiceMyClass.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Service","onbinder");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Service","unbinder");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
        Log.e("Service","create");

    }
    public void start(){
        if(mp==null){
            mp= MediaPlayer.create(getApplicationContext(),R.raw.buonvuongmauao_nguyenhung);
        }
        mp.start();
    }

/*
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Bắt đầu mở nhạc! ", Toast.LENGTH_SHORT).show();
        mp.start();
        return super.onStartCommand(intent, flags, startId);
        //return START_NOT_STICKY;
    }
*/
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service đã bị hủy!", Toast.LENGTH_SHORT).show();
        Log.e("Service","huy");
        if(mp!=null){
            mp.release();
            mp = null;
        }
    }
}
