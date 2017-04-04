package com.example.metro.newservices;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Metro on 03-01-2017.
 */
public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = (ProgressBar) findViewById(R.id.progressBar1);

    }

    public void startService(View view)
    {
        startService( new Intent( this,MyService.class ) );
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    final int value = i;
                    doFakeWork();
                    progress.post( new Runnable() {
                        @Override
                        public void run() {
                            
                            progress.setProgress(value);

                        }
                    });
                }

            }

           
        };
        new Thread(runnable).start();

    }

    private void doFakeWork() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public void stopService(View view)
    {
        stopService( new Intent( this,MyService.class ) );
    }

    private class DownloadWebPage extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            return null;
        }
    }
}
