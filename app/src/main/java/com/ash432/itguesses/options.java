package com.ash432.itguesses;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class options extends AppCompatActivity
{

    private Animation sc;
    Button play,hints,instruct,exit;
    MediaPlayer din;
    private TextView title,song_credits,song_name;
   RelativeLayout rel;
    CountDownTimer t = null;
int length;
    long stopper=0;
long res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(res==0)
        {
            overridePendingTransition(R.anim.fadeout,R.anim.fadein);
            res=1;
        }
        else
       overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_left);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_options);

        final AudioManager man = (AudioManager) getSystemService(AUDIO_SERVICE);
        final int originalVol = man.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        man.setStreamVolume(AudioManager.STREAM_MUSIC, man.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
        din = MediaPlayer.create(options.this, R.raw.ding);
        din.setLooping(true);
        din.start();
        stopper=0;

        play = (Button) findViewById(R.id.play);
        hints=(Button)findViewById(R.id.hints);
        instruct=(Button)findViewById(R.id.instruct);
        exit=(Button)findViewById(R.id.exit);
        title=(TextView)findViewById(R.id.title);
        song_credits=(TextView)findViewById(R.id.song_credits);
        song_name=(TextView)findViewById(R.id.song_name);
        rel=(RelativeLayout)findViewById(R.id.rel);
       // rel.setVisibility(View.VISIBLE);
         Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_options);
        fade.setDuration(1500);


        rel.startAnimation(fade);
        song_name.setMovementMethod(LinkMovementMethod.getInstance());
        String link="<a href='https://www.youtube.com/watch?v=3_-a9nVZYjk'>\"THE FATRAT-XENOGENISIS\"</a>";

        song_name.setText(Html.fromHtml(link));


        final ObjectAnimator title_color=ObjectAnimator.ofInt(title,"textColor",Color.WHITE,Color.DKGRAY);
      //  ObjectAnimator rel_color=ObjectAnimator.ofInt(rel,"backgroundColor",Color.GRAY,Color.BLACK);
       final ObjectAnimator song_credits_color=ObjectAnimator.ofInt(song_credits,"textColor",Color.WHITE,Color.DKGRAY);
        final ObjectAnimator play_color=ObjectAnimator.ofInt(play,"textColor", Color.BLACK,Color.LTGRAY);
       final ObjectAnimator instruct_color=ObjectAnimator.ofInt(instruct,"textColor",Color.BLACK,Color.LTGRAY);
       final ObjectAnimator hints_color=ObjectAnimator.ofInt(hints,"textColor", Color.BLACK,Color.LTGRAY);
        final ObjectAnimator exit_color=ObjectAnimator.ofInt(exit,"textColor", Color.BLACK,Color.LTGRAY);
        /*rel_color.setDuration(2000);
        rel_color.setEvaluator(new ArgbEvaluator());
        //obj.setRepeatCount(ValueAnimator.INFINITE);
        //obj.setRepeatMode(ValueAnimator.REVERSE);
        rel_color.start();*/

        sc=new ScaleAnimation(1.0f,1.03f,1.0f,1.03f);
        sc.setDuration(2000);
        sc.setRepeatCount(-1);
        sc.setRepeatMode(Animation.REVERSE);
        title.startAnimation(sc);
        //song_credits.startAnimation(sc);
       // song_name.startAnimation(sc);

        setColor(title_color,2000);
        setColor(play_color,1000);
        setColor(song_credits_color,700);
       setColor(instruct_color,1000);
        setColor(hints_color,1000);
        setColor(exit_color,1000);
        //setColor(song_name_color);

        final Animation translate_left = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        final Animation translate_right = AnimationUtils.loadAnimation(this, R.anim.translate_right);





        /*final Animation layout_tran = AnimationUtils.loadAnimation(this, R.anim.layout_tran);
        final Animation layout_tran_right = AnimationUtils.loadAnimation(this, R.anim.layout_tran_right);

        //layout_tran.setFillAfter(false);
        layout_tran.setRepeatMode(Animation.REVERSE);
        layout_tran.setRepeatCount(1);*/

       //translate_left.setRepeatMode(Animation.REVERSE);

     //   Animation fade_button = AnimationUtils.loadAnimation(this, R.anim.fade);
       // fade_button.setDuration(100);

        play.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(final View arg0)
            {
                stopper++;

                arg0.setClickable(false);
                hints.setClickable(false);
                instruct.setClickable(false);
                exit.setClickable(false);
             arg0.startAnimation(translate_left);
                hints.startAnimation(translate_left);
                instruct.startAnimation(translate_right);
                exit.startAnimation(translate_right);

                /*play.setVisibility(View.INVISIBLE);
                hints.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.INVISIBLE);
                instruct.setVisibility(View.INVISIBLE);*/

                //rel.startAnimation(layout_tran);
               //rel.setVisibility(View.INVISIBLE);
                //rel.startAnimation(layout_tran_right);
               t= new CountDownTimer(1000, 1000)
                {
                    public void onTick(long millis)
                    {

                    }
                    public void onFinish()
                    {
                        goTo_game_main(arg0);
                    }
                };
                t.start();
            }
        });

      hints.setOnClickListener(new Button.OnClickListener()
        {

            @Override
            public void onClick(final View arg0)
            {
                stopper++;

                arg0.setClickable(false);
                play.setClickable(false);
                instruct.setClickable(false);
                exit.setClickable(false);
                arg0.startAnimation(translate_left);
                play.startAnimation(translate_left);
                instruct.startAnimation(translate_right);
                exit.startAnimation(translate_right);

                //play.setVisibility(View.INVISIBLE);
                //hints.setVisibility(View.INVISIBLE);
                //exit.setVisibility(View.INVISIBLE);
                //instruct.setVisibility(View.INVISIBLE);
               // rel.startAnimation(layout_tran);
                //rel.setVisibility(View.INVISIBLE);
                t= new CountDownTimer(1000, 1000)
                {
                    public void onTick(long millis)
                    {

                    }
                    public void onFinish()
                    {
                        goTo_hints(arg0);
                    }
                };
                t.start();
            }
        });

        instruct.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                stopper++;

                arg0.setClickable(false);
                play.setClickable(false);
                hints.setClickable(false);
                exit.setClickable(false);
                arg0.startAnimation(translate_right);
                hints.startAnimation(translate_left);
                play.startAnimation(translate_left);
                exit.startAnimation(translate_right);

                /*play.setVisibility(View.INVISIBLE);
                hints.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.INVISIBLE);
                instruct.setVisibility(View.INVISIBLE);
                rel.startAnimation(layout_tran);
                rel.setVisibility(View.INVISIBLE);*/

            }
        });

        exit.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(final View arg0)
            {
                stopper++;

                arg0.setClickable(false);
                play.setClickable(false);
                instruct.setClickable(false);
                hints.setClickable(false);
                arg0.startAnimation(translate_right);
                hints.startAnimation(translate_left);
                instruct.startAnimation(translate_right);
                play.startAnimation(translate_left);

               /* play.setVisibility(View.INVISIBLE);
                hints.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.INVISIBLE);
                instruct.setVisibility(View.INVISIBLE);*/
                t= new CountDownTimer(800, 800)
                {
                    public void onTick(long millis)
                    {

                    }
                    public void onFinish()
                    {
                     finish();
                    }
                };
                t.start();

              //  rel.startAnimation(layout_tran);
            //    rel.setVisibility(View.INVISIBLE);
  //              while(getTimePassed()<2000)
//                finish();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_left);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        din.pause();
        length=din.getCurrentPosition();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        din.seekTo(length);
        din.start();
        stopper=0;
        final Animation reverse_translate_left = AnimationUtils.loadAnimation(this, R.anim.reverse_translate_left);
        final Animation reverse_translate_right = AnimationUtils.loadAnimation(this, R.anim.reverse_translate_right);
        play.startAnimation(reverse_translate_left);
        hints.startAnimation(reverse_translate_left);
        instruct.startAnimation(reverse_translate_right);
        exit.startAnimation(reverse_translate_right);
        t= new CountDownTimer(1500, 1500)
        {
            public void onTick(long millis)
            {

            }
            public void onFinish()
            {
                play.setClickable(true);
                hints.setClickable(true);
                exit.setClickable(true);
                instruct.setClickable(true);
            }
        };
        t.start();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
   // rel.setVisibility(View.VISIBLE);
    }
@Override
protected void onStop()
{
    super.onStop();
    play.setClickable(false);
    hints.setClickable(false);
    exit.setClickable(false);
    instruct.setClickable(false);
}
    public void setColor(ObjectAnimator obj,long sec)
    {
        obj.setDuration(sec);
        obj.setEvaluator(new ArgbEvaluator());
        obj.setRepeatCount(ValueAnimator.INFINITE);
        obj.setRepeatMode(ValueAnimator.REVERSE);
        obj.start();
    }

    public void goTo_game_main (View view)
{

    Intent intent = new Intent(this, game.class);
    startActivity(intent);
}

    public void goTo_hints (View view)
    {

        Intent intent = new Intent(this, hints.class);
        startActivity(intent);
    }
   /* public void setInvisible()
    {
        play.setVisibility(View.INVISIBLE);
        hints.setVisibility(View.INVISIBLE);
        exit.setVisibility(View.INVISIBLE);
        instruct.setVisibility(View.INVISIBLE);
    }*/
@Override
    public void onBackPressed()
{
    //ContextThemeWrapper ctw=new ContextThemeWrapper(this,R.style.Dialog_Theme);
    if (stopper == 0)
    {
        AlertDialog.Builder exit_message = new AlertDialog.Builder(this);
        exit_message.setTitle("Exit?");
        exit_message.setMessage("Are you sure want to exit?");
        exit_message.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        exit_message.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                finish();
            }
        });
        exit_message.show();
    }
}

}
