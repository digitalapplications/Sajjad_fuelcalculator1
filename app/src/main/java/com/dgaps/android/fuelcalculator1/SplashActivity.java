package com.dgaps.android.fuelcalculator1;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends Activity {

    ProgressBar pbar;

    NotificationManager mNotificationManager;

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        hideStatusBar();
        iv = (ImageView) findViewById(R.id.car);


       ObjectAnimator anim1=ObjectAnimator.ofInt(pbar,"progressbar",0,100);
         anim1.setDuration(4000);
         anim1.setInterpolator(new DecelerateInterpolator());
         anim1.start();

        Animation anim2= AnimationUtils.loadAnimation(this,R.animator.anim);

       iv.setAnimation(anim2);



        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();

            }
        },3000);
    }

    public void hideStatusBar() {
        // Hide status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }




}
