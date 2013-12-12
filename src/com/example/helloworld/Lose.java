package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Lose extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose);
        Handler n = new Handler();
        n.postDelayed(new Runnable(){
            public void run(){
                finish();
            }
        }, 5000);
    }
}