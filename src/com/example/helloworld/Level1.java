package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class Level1 extends Activity {
    /**
     * Called when the activity is first created.
     */
    TextView scoreText;
    int score = 0;
    boolean isHighlighted = false;
    private Button highlightedButton; //çompare which button was highlighted
    private Button[] buttons = new Button[4];
    private int numHits = 0;

    private TextView timerView;

    private Animation animation;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        scoreText = (TextView)findViewById(R.id.score);
        timerView = (TextView)findViewById(R.id.timer);

        //Put all of the buttons in an array so that we can access them in play()
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);

        new CountDownTimer(60000, 1000){
            public void onTick(long millisUntilFinished){
                timerView.setText("Time Remaining: " +  millisUntilFinished / 1000);
            }

            public void onFinish(){
                 Intent i = new Intent(Level1.this, Lose.class);
                 startActivity(i);
                 finish();
            }
        }.start();

        scoreText.setText(""+ score);

        //Code for the animation
        animation = new AlphaAnimation(1, 0);
        animation.setDuration(500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        highlightedButton= buttons[3];
        highlightedButton.startAnimation(animation);

    }


    public void updateScore(View v){

        if(score >= 200){
            Intent i = new Intent(Level1.this, Level2.class);
            startActivity(i);
            finish();
        }

        if(v == highlightedButton){


            highlightedButton.clearAnimation();
            int randomIndex = (int)(Math.random() * (buttons.length));

            highlightedButton = buttons[randomIndex];
            highlightedButton.startAnimation(animation);
            numHits = 0;

        score+=10;
        numHits++;
        scoreText.setText(""+score);
    }
    else{
            if(score <= 0){

                Intent i = new Intent(Level1.this, Lose.class);
                startActivity(i);
                finish();
            }
            else{
                score-=20;
                numHits++;
                scoreText.setText("" + score);
            }
        }
    }




    public void play(){
        //This is how we're going to handle playing things until score is 200.


        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        highlightedButton.startAnimation(animation);


    }

}
