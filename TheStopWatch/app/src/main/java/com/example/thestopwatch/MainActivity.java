package com.example.thestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int seconds=0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* if there is any saved Instance */
        if(savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }
    @Override
    protected void onStop(){
        super.onStop();
        wasRunning = running;
        running = false;
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(wasRunning){
            running = true;
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }
    @Override
    protected  void onResume(){
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }


    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
    }
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }
    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        /* use handler */
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int h = seconds / 3600;
                int m = (seconds % 3600) / 60;
                int s = seconds % 60;
                // at start this runs and displays 0 because running = false and seconds = 0
                String time = String.format("%d:%02d:%02d",h,m,s);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });


    }


}
