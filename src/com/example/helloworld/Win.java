package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: Allen
 * Date: 12/11/13
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Win extends Activity {



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);
    }


    public void moveOn(View v){
        Intent i = new Intent(Win.this, Level1.class);
        startActivity(i);
        finish();
    }

    public void quit(View v){
        finish();
    }
}