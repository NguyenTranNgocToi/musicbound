package com.example.mucsicbound;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private  ServiceMyClass mServiceMyClass;
    private boolean isServiceConnected;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceMyClass.MyBinder myBinder = (ServiceMyClass.MyBinder) service;
            mServiceMyClass = myBinder.getServiceMyClass();
            mServiceMyClass.start();
            isServiceConnected =true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceConnected =false;
        }
    };
    ImageView play,play4, play6,play7, play8,play9,play10;
    Boolean i =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (ImageView) findViewById(R.id.image_start);

        play4 = (ImageView) findViewById(R.id.image_start4);
        play6= (ImageView) findViewById(R.id.image_start6);
        play7 = (ImageView) findViewById(R.id.image_start7);
        play8 = (ImageView) findViewById(R.id.image_start8);
        play9 = (ImageView) findViewById(R.id.image_start9);
        play10 = (ImageView) findViewById(R.id.image_start10);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });


        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });

        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });
        play7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });
        play8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });
        play9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });
        play10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Service đã được tạo!", Toast.LENGTH_SHORT).show();
                start();
                if(i=false)
                {
                    start();
                }else {
                    stop();
                }
            }
        });


    }



    public void start(){
        Intent intent = new Intent(this, ServiceMyClass.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        i=true;
    }
    public void stop(){
        if(isServiceConnected){
            unbindService(mServiceConnection);
            isServiceConnected =false;
        }


        i=false;
    }
}