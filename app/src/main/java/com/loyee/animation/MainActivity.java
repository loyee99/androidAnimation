package com.loyee.animation;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imgPic;
    private Animation mAnimation;
    private String mAnimStr="";
    private BaseInterpolator mBaseInterpolator;
    private String mInterpolatorStr="";
    private TextView interpolator;
    private TextView anim;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //----for ViewAnimationUtils.createCircularReveal
        //设置允许通过ActivityOptions.makeSceneTransitionAnimation发送或者接收Bundle
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        //设置使用TransitionManager进行动画，不设置的话系统会使用一个默认的TransitionManager
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_main);
        imgPic = (ImageView) findViewById(R.id.imgPic);
        interpolator = (TextView)findViewById(R.id.interpolator);
        anim = (TextView)findViewById(R.id.anim);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAlpha:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.my_alpha);
                mAnimStr="alpha";
                break;
            case R.id.btnScale:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.my_scale);
                mAnimStr="scale";
                break;
            case R.id.btnTranslate:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.my_translate);
                mAnimStr="translate";
                break;

            case R.id.btnRotate:
                mAnimation = AnimationUtils
                        .loadAnimation(this, R.anim.my_rotate);
                mAnimation.setZAdjustment(2);
                mAnimation.setFillAfter(true);
                mAnimStr="rotate";
                break;
            case R.id.all:
                mAnimation = AnimationUtils
                        .loadAnimation(this, R.anim.my_translate_alpha_rotate);
                mAnimStr="mixed";
                break;
            case R.id.AccelerateDecelerateInterpolator:
                mBaseInterpolator = new AccelerateDecelerateInterpolator();
                mInterpolatorStr = "AccelerateDecelerateInterpolator";
                break;

            case R.id.AccelerateInterpolator:
                mBaseInterpolator = new AccelerateInterpolator();
                mInterpolatorStr = "AccelerateInterpolator";
                break;

            case R.id.AnticipateInterpolator:
                mBaseInterpolator = new AnticipateInterpolator();
                mInterpolatorStr = "AnticipateInterpolator";
                break;
            case R.id.AnticipateOvershootInterpolator:
                mBaseInterpolator = new AnticipateOvershootInterpolator();
                mInterpolatorStr = "AnticipateOvershootInterpolator";
                break;

            case R.id.BounceInterpolator:
                mBaseInterpolator = new BounceInterpolator();
                mInterpolatorStr = "BounceInterpolator";
                break;
            case R.id.CycleInterpolator:
                mBaseInterpolator = new CycleInterpolator(0.8f);
                mInterpolatorStr = "CycleInterpolator";
                break;
            case R.id.DecelerateInterpolator:
                mBaseInterpolator = new DecelerateInterpolator();
                mInterpolatorStr = "DecelerateInterpolator";
                break;
            case R.id.LinearInterpolator:
                mBaseInterpolator = new LinearInterpolator();
                mInterpolatorStr = "LinearInterpolator";
                break;
            case R.id.OvershootInterpolator:
                mBaseInterpolator = new OvershootInterpolator();
                mInterpolatorStr = "OvershootInterpolator";
                break;
            case R.id.CircularReveal:
                mInterpolatorStr = "CircularReveal";
                Animator animator = ViewAnimationUtils.createCircularReveal(
                        v, v.getWidth(), v.getHeight(), 0, 0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1000);
                animator.start();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                ActivityOptions option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, v, "share_image");
                startActivity(intent, option.toBundle());
                return;
            case R.id.imgPic:
                Toast.makeText(MainActivity.this, "hello,i am imgPic", Toast.LENGTH_LONG).show();
                break;
        }
        if(mAnimation==null) {
            Toast.makeText(MainActivity.this, "please select animation first", Toast.LENGTH_LONG).show();
            return;
        }
        anim.setText(mAnimStr);
        if(mBaseInterpolator==null) {
            Toast.makeText(MainActivity.this, "please select interpolator first", Toast.LENGTH_LONG).show();
            return;
        }
        interpolator.setText(mInterpolatorStr);
        mAnimation.setInterpolator(mBaseInterpolator);
        mAnimation.setFillAfter(true);
        imgPic.startAnimation(mAnimation);
    }
}
