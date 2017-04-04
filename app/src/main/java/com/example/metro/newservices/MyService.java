package com.example.metro.newservices;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.security.Provider;

public class MyService extends Service {
    boolean isthat=false;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service was Created", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread( new Runnable() {

            @Override
            public void run() {

                for(int i=0;i<5;i++)
                {

                    Log.d("services of service","service is running....");
                    try {
                        Thread.sleep( 1000 );
                    }catch (Exception e)
                    {

                    }

                }
                stopSelf();;
            }
        } ).start();
       // Toast.makeText(this, "Service was Started", Toast.LENGTH_LONG).show();

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service was Stop", Toast.LENGTH_LONG).show();
    }

}
