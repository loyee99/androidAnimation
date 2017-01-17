package com.loyee.animation;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置允许通过ActivityOptions.makeSceneTransitionAnimation发送或者接收Bundle
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        //设置使用TransitionManager进行动画，不设置的话系统会使用一个默认的TransitionManager
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_detail);
        final TextView oval = (TextView) findViewById(R.id.hello);

        final View bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        bt,
                        bt.getWidth(),
                        bt.getHeight(),0,0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1000);
                animator.start();
            }
        });


    }
}
