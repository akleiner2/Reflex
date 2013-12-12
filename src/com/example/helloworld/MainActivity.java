package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private Button welcome;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
        welcome = (Button)findViewById(R.id.welcome);
        Handler n = new Handler();
        n.postDelayed(new Runnable(){
            public void run(){
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
                finish();

            }
        }, 3000);

        }


    }
