package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

    }

    public void moveOn(View v){
        Intent i = new Intent(Menu.this, Level1.class);
        startActivity(i);
        finish();
    }

    public void quit(View v){
        finish();
    }
}