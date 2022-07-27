package com.example411.termworkfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView countvaluetv;
    Button startbtn;
    Button stopbtn;

    int counter = 0;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countvaluetv = findViewById(R.id.countValueTV);
        startbtn = findViewById(R.id.startBtn);
        startbtn.setOnClickListener(this);
        stopbtn = findViewById(R.id.stopBtn);
        stopbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(startbtn)){
            counter = 0;
            running = true;
            new MyCounter().start();
        }else if (v.equals(stopbtn)){
            running = false;
        }
    }
    class MyCounter extends Thread{
        public void run(){
            while(running){
                counter++;
                handler.sendEmptyMessage(counter);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    Handler handler = new Handler(message -> {
        countvaluetv.setText(String.valueOf(message.what));
        return false;
    });
}