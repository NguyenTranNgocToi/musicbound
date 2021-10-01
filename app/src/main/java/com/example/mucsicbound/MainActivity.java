package com.example.mucsicbound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.Image;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView start;
    ImageView stop;

    private ServiceConnection serviceConnection;


    private boolean isConnected;
    private MyService myService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        connectService();

    }




    private void initView() {
        start =  findViewById(R.id.image_start);
        stop = findViewById(R.id.image_Stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(!isConnected){
//                    return;
//                }

                int result = myService.add(
                        Integer.parseInt("5"),
                        Integer.parseInt("6"));

                Toast.makeText(MainActivity.this, "Result:" + result, Toast.LENGTH_SHORT).show();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void connectService() {

        Intent intent = new Intent(this, MyService.class);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.MyBinder myBinder = (MyService.MyBinder) service;

                myService = myBinder.getService();
                isConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isConnected = false;
                myService = null;
            }
        };
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }
    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }
}