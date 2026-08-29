package com.ash432.itguesses;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class answer extends AppCompatActivity
{
    private TextView title_ans,ans;
    private MediaPlayer music_ans;
    private Animation anim_ans1,anim_ans2,anim_ans3,anim_ans4,anim_ans5,anim_ans6,anim_ans7,anim_ans8,sc;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer);
        music_ans = MediaPlayer.create(answer.this, R.raw.final1);
music_ans.start();
       ans=(TextView)findViewById(R.id.ans);
        title_ans=(TextView)findViewById(R.id.title_ans);
       String s=getIntent().getStringExtra("Answer");
        ans.setText(""+s);
        options obj=new options();
     /*   anim_ans1= AnimationUtils.loadAnimation(this,R.anim.anim_ans1);
        anim_ans2= AnimationUtils.loadAnimation(this,R.anim.anim_ans2);
        anim_ans3= AnimationUtils.loadAnimation(this,R.anim.anim_ans3);
        anim_ans4= AnimationUtils.loadAnimation(this,R.anim.anim_ans4);
        anim_ans5= AnimationUtils.loadAnimation(this,R.anim.anim_ans5);
        anim_ans6= AnimationUtils.loadAnimation(this,R.anim.anim_ans6);*/
        anim_ans1=new AlphaAnimation(0.0f,1.0f);
        anim_ans1.setDuration(800);
        anim_ans2=new TranslateAnimation(0.0f,20.0f,0.0f,0.0f);
        anim_ans2.setDuration(800);

        anim_ans3=new AlphaAnimation(1.0f,0.0f);
        anim_ans3.setDuration(300);

        anim_ans4=new AlphaAnimation(0.0f,1.0f);
        anim_ans4.setDuration(800);
        anim_ans5=new TranslateAnimation(20.0f,-20.0f,0.0f,0.0f);
        anim_ans5.setDuration(800);


        anim_ans6=new AlphaAnimation(1.0f,0.0f);
        anim_ans6.setDuration(300);

        anim_ans7=new AlphaAnimation(0.0f,1.0f);
        anim_ans7.setDuration(800);
        anim_ans8=new TranslateAnimation(-20.0f,0.0f,0.0f,0.0f);
        anim_ans8.setDuration(800);


        anim_ans1.setStartOffset(0);
        anim_ans2.setStartOffset(1000);

        anim_ans3.setStartOffset(2000);

        anim_ans4.setStartOffset(3000);
        anim_ans5.setStartOffset(4000);

        anim_ans6.setStartOffset(5000);

        anim_ans7.setStartOffset(6000);
        anim_ans8.setStartOffset(7000);

        sc=new ScaleAnimation(1.0f,1.2f,1.0f,1.2f);
        sc.setDuration(500);
        sc.setRepeatCount(-1);
        sc.setRepeatMode(Animation.REVERSE);
//sc.setStartOffset(8000);
      //  ans.startAnimation(sc);
       ans.startAnimation(anim_ans1);
        ans.startAnimation(anim_ans2);
       ans.startAnimation(anim_ans3);
        ans.startAnimation(anim_ans4);
        ans.startAnimation(anim_ans5);
        ans.startAnimation(anim_ans6);
        ans.startAnimation(anim_ans7);
        ans.startAnimation(anim_ans8);

        ans.startAnimation(sc);

        final ObjectAnimator ans_color=ObjectAnimator.ofInt(ans,"textColor", Color.WHITE,Color.DKGRAY);
        obj.setColor(ans_color,500);

    }
    @Override
    public void onBackPressed()
    {
        finish();
        music_ans.stop();
    }
}
