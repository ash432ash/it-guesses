package com.ash432.itguesses;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class loading extends AppCompatActivity
{
    private RelativeLayout rel_loading;
    private Button l1, l2, l3,proc;
    private TextView quote1, quote2;
    private CountDownTimer t, ti,t1,t2,t3,t4;
    final  Animation sc = new TranslateAnimation(0.0f, 33.0f, 0.0f, 0.0f);
    final Animation sc2 = new TranslateAnimation(0.0f, 33.0f, 0.0f, 0.0f);
    final Animation sc3 = new TranslateAnimation(0.0f, -33.0f, 0.0f, 0.0f);
    final Animation sc4=new TranslateAnimation(0.0f,-33.0f,0.0f,0.0f);

    int c1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_game);
        rel_loading = (RelativeLayout) findViewById(R.id.rel_loading);
        l1 = (Button) findViewById(R.id.l1);
        l2 = (Button) findViewById(R.id.l2);
        l3 = (Button) findViewById(R.id.l3);
        proc=(Button) findViewById(R.id.proc);
        quote1 = (TextView) findViewById(R.id.quote);
        quote2 = (TextView) findViewById(R.id.quote_credits);
        quote1.setVisibility(View.INVISIBLE);
        quote2.setVisibility(View.INVISIBLE);
        l1.setVisibility(View.INVISIBLE);
        l2.setVisibility(View.INVISIBLE);
        l3.setVisibility(View.INVISIBLE);
        proc.setVisibility(View.INVISIBLE);
        proc.setClickable(false);
       final Animation blink=AnimationUtils.loadAnimation(this,R.anim.blink);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_background);
        fade.setDuration(5000);
        rel_loading.startAnimation(fade);

        t = new CountDownTimer(5000, 5000)
        {
            public void onTick(long millis)
            {

            }

            public void onFinish()
            {
final long we=System.currentTimeMillis();
                rel_loading.setBackgroundColor(Color.BLACK);
                quote1.setVisibility(View.VISIBLE);
                quote2.setVisibility(View.VISIBLE);
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.VISIBLE);
                final ObjectAnimator quote1_color=ObjectAnimator.ofInt(quote1,"textColor",Color.WHITE,Color.DKGRAY);
                final ObjectAnimator quote2_color=ObjectAnimator.ofInt(quote2,"textColor",Color.WHITE,Color.GRAY);
                setColor(quote1_color,2000);
                setColor(quote2_color,1000);


                sc.setDuration(500);
                sc2.setDuration(500);
                sc3.setDuration(500);
                sc4.setDuration(500);

                sc.setStartOffset(0);
                sc2.setStartOffset(500);
                sc3.setStartOffset(1000);

                sc.setAnimationListener(new Animation.AnimationListener()
                {
                    @Override
                    public void onAnimationStart(Animation animation)
                    {}

                    @Override
                    public void onAnimationEnd(Animation animation)
                    {
                        long r = 1500;
                        t1 = new CountDownTimer(r, r)
                        {
                            @Override
                            public void onTick(long l)
                            {}

                            @Override
                            public void onFinish()
                            {

                                l1.clearAnimation();
                                l1.startAnimation(sc);
                                l1.setAnimation(sc);
                            }
                        };
                        t1.start();

                    }
                    @Override
                    public void onAnimationRepeat(Animation animation)
                    {}
                });


                sc2.setAnimationListener(new Animation.AnimationListener()
                {
                    @Override
                    public void onAnimationStart(Animation animation)
                    {}

                    @Override
                    public void onAnimationEnd(Animation animation)
                    {

                            long r = 1000;
                            t2 = new CountDownTimer(r, r)
                            {
                                @Override
                                public void onTick(long l)
                                {
                                }

                                @Override
                                public void onFinish()
                                {
                                    l2.clearAnimation();
                                    l2.startAnimation(sc2);
                                    l2.setAnimation(sc2);

                                }
                            };
                            t2.start();
                        }

                    @Override
                    public void onAnimationRepeat(Animation animation)
                    {}
                });



               sc3.setAnimationListener(new Animation.AnimationListener()
                {
                    @Override
                    public void onAnimationStart(Animation animation)
                    {}

                    @Override
                    public void onAnimationEnd(Animation animation)
                    {
                        long r=500;
                        l2.startAnimation(sc4);
                        l2.setAnimation(sc4);
                           t3 = new CountDownTimer(r, r)
                           {
                               @Override
                               public void onTick(long l)
                               {

                               }

                               @Override
                               public void onFinish()
                               {
                                   l3.clearAnimation();
                                  l3.startAnimation(sc3);
                                  l3.setAnimation(sc3);

                               }
                           };
                           t3.start();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation)
                    {

                    }
                });

                l1.setAnimation(sc);
                l2.setAnimation(sc2);
                l3.setAnimation(sc3);

            }
        };
        t.start();

        ti = new CountDownTimer(10000, 10000)
        {
            public void onTick(long millis)
            {

            }

            public void onFinish()
            {
                proc.setVisibility(View.VISIBLE);

                proc.startAnimation(blink);
                blink.setAnimationListener(new Animation.AnimationListener()
                {
                    @Override
                    public void onAnimationStart(Animation animation)
                    {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation)
                    {
                        long r = 1000;
                        t4 = new CountDownTimer(r, r)
                        {
                            @Override
                            public void onTick(long l)
                            {
                            }

                            @Override
                            public void onFinish()
                            {
                                proc.clearAnimation();
                                proc.startAnimation(blink);
                                proc.setAnimation(blink);
                            }
                        };
                        t4.start();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation)
                    {

                    }
                });
                proc.setClickable(true);
            }
        };
        ti.start();
    }




    public void goTo_game_main(View view)
    {
        l1.clearAnimation();
        l2.clearAnimation();
        l3.clearAnimation();
        proc.setClickable(false);
        Intent intent = new Intent(this, options.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void setColor(ObjectAnimator obj,long sec)
    {
        obj.setDuration(sec);
        obj.setEvaluator(new ArgbEvaluator());
        obj.setRepeatCount(ValueAnimator.INFINITE);
        obj.setRepeatMode(ValueAnimator.REVERSE);
        obj.start();
    }

}
