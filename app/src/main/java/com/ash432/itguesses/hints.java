package com.ash432.itguesses;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class hints extends AppCompatActivity
{
    private int button_arr[] = {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9,
            R.id.b10, R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16};
    Animation anim;
    int length;
    List<Animator> animlist = new ArrayList<>();
    Timer mtimer=new Timer();
    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
 ProgressBar pb;
    private MediaPlayer din;
    AnimatorSet list;
    int l;
    CountDownTimer t,t1;
    long s1;

    long starttime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hints);
        int i;
        pb = (ProgressBar) findViewById(R.id.progressBar2);
        din = MediaPlayer.create(hints.this, R.raw.answer);
        l=din.getDuration();
        din.setLooping(true);
      //Log.e("ayush",""+l);
       //final  int update=l/100;
      pb.setMax(l);
        pb.setProgress(0);
        Log.e("ayush",""+l+"current ");
din.start();
pb.setLayerType(View.LAYER_TYPE_HARDWARE,null);

        service.scheduleWithFixedDelay(new Runnable()
        {
            @Override
            public void run()
            {
                pb.setProgress(din.getCurrentPosition());
            }
        }, 0, 1, TimeUnit.MICROSECONDS);

        /*t=new CountDownTimer(l,50)
        {
            @Override
            public void onTick(long l)
            {
                s1=l;
                pb.setProgress(pb.getProgress()+50);
                Log.e("ayush",""+pb.getProgress());
            }

            @Override
            public void onFinish()
            {
t.start();
                pb.setProgress(0);
            }
        };
        t.start();*/


    /*  mtimer.schedule(new TimerTask()
        {
          @Override
                  public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if(!(update*pb.getProgress()>=l))
                        {
                            int p=pb.getProgress();
                            p=p+1;
                            pb.setProgress(p);
                            Log.e("ayush",""+p);
                        }
                    }
                });
            }
        },update);*/

      /*  din.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener()
        {
            @Override
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i)
            {
                if(pb.getProgress()-i>100)
                pb.setProgress(i);
                Log.e("ayush",""+i);
            }
        });*/

      /*  new <Void,Integer,Void>()
        {
           @Override
            protected Void doInBackground(Void ... params)
           {
               while(din.isPlaying())
               {
                   publishProgress(din.getCurrentPosition());
               }
               return null;
           }
            protected void onProgressUpdate(Integer ... progress)
            {
                pb.setProgress(progress[0]);
            }
            @Override
            protected void onPostExecute(Void result)
            {
                super.onPostExecute(result);
                din.stop();
                din.release();
            }
        }.execute();*/


       // din.start();
        for (i = 0; i < 16; i++)
            invisible(button_arr[i]);

       for(i=0;i<16;i++)
                anim_button(button_arr[i], 500 * (i + 1));

        }


    private void invisible(int id)
    {
        Button b = (Button) findViewById(id);
        b.setVisibility(View.INVISIBLE);
       // int a=5;
        //String s2=atoString();
        //b.setText(s2);
    }

    private void anim_button(int id, long duration)
    {

        Button b = (Button) findViewById(id);
        Animator animator=AnimatorInflater.loadAnimator(this,R.animator.fade);
       /* animator.setTarget(b);
        animator.setDuration(duration);
        animator.start();
        animlist.add(animator);*/
       anim = AnimationUtils.loadAnimation(this, R.anim.fade_row);
        anim.setStartOffset(duration);
        b.startAnimation(anim);
        b.setVisibility(View.VISIBLE);
     /*   anim.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });*/


        /* ObjectAnimator obj=ObjectAnimator.ofInt(b,"", Color.BLACK,Color.LTGRAY);
        obj.setStartDelay(duration);
        obj.setDuration(500);
       obj.setEvaluator(new ArgbEvaluator());
        obj.start();
        obj.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation)
            {
                animation.removeListener(this);
                animation.setDuration(0);
               ((ObjectAnimator)animation).reverse();
            }
        });*/
        b.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume()
    {
super.onResume();

        /*t1=new CountDownTimer(l-s1,50)
        {
            @Override
            public void onTick(long l)
            {

                pb.setProgress(pb.getProgress()+50);
                Log.e("ayush",""+pb.getProgress());
            }

            @Override
            public void onFinish()
            {
                t1.start();
                pb.setProgress(0);
            }
        };
        t1.start();*/

        din.seekTo(length);
        din.start();
        for(Animator animator:animlist)
            animator.pause();
    }

    @Override
    protected void onPause()
    {

        super.onPause();
        //t.cancel();
        din.pause();
service.shutdown();
        length=din.getCurrentPosition();
        for(Animator animator:animlist)
            animator.pause();
    }


}