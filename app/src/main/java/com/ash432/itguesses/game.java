package com.ash432.itguesses;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class game extends AppCompatActivity
{
    private int stopper=0;
    private MediaPlayer q1, q2, q3, q4, q5;
    private int length1, length2, length3, length4;
    private RelativeLayout rel;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, yes, no;
    private int ans = 0;
    private int choice = 0;
    private int a[][] = {{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 0},
            {2, 3, 6, 7, 10, 11, 14, 15, 18, 19,22, 23, 26, 27, 30,0},
            {4, 5, 6, 7, 12, 13, 14, 15, 20, 21, 22, 23, 28, 29, 30, 0},
            {8, 9, 10, 11, 12, 13, 14, 15, 24, 25, 26, 27, 28, 29, 30, 0},
            {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 0}};

    private int a2[][] = new int[5][16];
    private int sum1[] = new int[5];

    private int b[][] = {{1, 4, 6, 9, 11, 12, 14, 16, 17, 19, 22, 24, 25, 27, 30, 0},
            {2, 6, 7, 10, 11, 14, 15, 16, 18, 19, 20, 23, 24, 26, 28, 0, 0},
            {3, 4, 6, 9, 10, 12, 14, 17, 18, 19, 22, 23, 25, 26, 29, 30},
            {5, 7, 9, 10, 15, 18, 19, 20, 22, 23, 27, 28, 29, 30, 0, 0},
            {8, 11, 12, 14, 15, 18, 19, 21, 24, 25, 26, 27, 28, 29, 30, 0, 0},
            {13, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 0, 0}};

    private int a3[][] = new int[6][16];
    private int sum2[] = new int[6];
    long s1;
    private int button_arr[] = {R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9,
            R.id.b10, R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16};
    String tag = "ayush";
    private TextView title_ans, question_left;
    Animation anim_row,anim_reverse,fade_zero,fade_not_zero,anim_reverse_not_row;
    private int d1 = -1, d2 = -1;
    CountDownTimer t = null;
    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private ProgressBar pb;
    List<Animator> animlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_left);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.game);
        rel = (RelativeLayout) findViewById(R.id.rel);

        q1 = MediaPlayer.create(game.this, R.raw.second);
        q1.setLooping(true);
pb=(ProgressBar)findViewById(R.id.pb);
        pb.getProgressDrawable().setColorFilter(
                Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        //Drawable customDrawable= this.getDrawable(R.drawable.progress_bar);
//pb.setProgressDrawable(customDrawable);
        pb.setMax(q1.getDuration());
        pb.setProgress(0);

        q1.start();

        service.scheduleWithFixedDelay(new Runnable()
        {
            @Override
            public void run()
            {
                pb.setProgress(q1.getCurrentPosition());
                Log.e("progress bar",""+q1.getCurrentPosition());
            }
        }, 1, 1, TimeUnit.MICROSECONDS);


        q2 = MediaPlayer.create(game.this, R.raw.q2);
        q2.setLooping(true);

        q3 = MediaPlayer.create(game.this, R.raw.q3);
        q3.setLooping(true);

        q4 = MediaPlayer.create(game.this, R.raw.q4);
        q4.setLooping(true);

        q5 = MediaPlayer.create(game.this, R.raw.q4);
        q5.setLooping(true);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b13 = (Button) findViewById(R.id.b13);
        b14 = (Button) findViewById(R.id.b14);
        b15 = (Button) findViewById(R.id.b15);
        b16 = (Button) findViewById(R.id.b16);

        b4.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        b8.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        b12.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        b16.setLayerType(View.LAYER_TYPE_HARDWARE,null);

       b4.setVisibility(View.INVISIBLE);
        b8.setVisibility(View.INVISIBLE);
        b12.setVisibility(View.INVISIBLE);
        b16.setVisibility(View.INVISIBLE);


        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        title_ans = (TextView) findViewById(R.id.title_ans);
        question_left = (TextView) findViewById(R.id.question_left);

         question_left.setVisibility(View.INVISIBLE);
        //invisible();

        yes.setClickable(false);
        no.setClickable(false);
        /*Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_game);
        fade.setDuration(1500);*/


        Animation sc = new ScaleAnimation(1.0f, 1.03f, 1.0f, 1.03f);
        sc.setDuration(2000);
        sc.setRepeatCount(-1);
        sc.setRepeatMode(Animation.REVERSE);
        title_ans.startAnimation(sc);

        final ObjectAnimator title_color = ObjectAnimator.ofInt(title_ans, "textColor", Color.WHITE, Color.DKGRAY);
        final ObjectAnimator question_left_color = ObjectAnimator.ofInt(question_left, "textColor", Color.WHITE, Color.LTGRAY);
        setColor(title_color, 1000);
        setColor(question_left_color, 1000);

        choice = (int) (Math.random() * 2);
        create(choice);


        if (choice == 0)
        {
            //Log.e(tag,"Five");
           // for(int i=0;i<5;i++)
             // Log.e("ayush",""+sum1[i]);
  //         Log.e("ayush",""+sum1[0]+" "+sum1[1]+" "+sum1[2]+" "+sum1[3]+" "+sum1[4]+" ");
            five();
        }

        else
        {
           // Log.e(tag,"Six");

//               Log.e("ayush",""+sum2[0]+" "+sum2[1]+" "+sum2[2]+" "+sum2[3]+" "+sum2[4]+" "+sum2[5]);
            six();
        }

    }


    private void anim_fade_row(int id, long duration, int value)
    {

        Button b = (Button) findViewById(id);
    //    RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) b.getLayoutParams();
    anim_row = AnimationUtils.loadAnimation(this, R.anim.fade_row);
       anim_row.setStartOffset(duration);
        b.startAnimation(anim_row);

     /*  Animator animator= AnimatorInflater.loadAnimator(this,R.animator.fade);
        animator.setTarget(b);
        animator.setDuration(duration);
        animator.start();
        animlist.add(animator);*/

        b.setText("" + value);
        b.setVisibility(View.VISIBLE);
    }


    private void anim_fade_not_row(int id, long duration, int value)
    {

        Button b = (Button) findViewById(id);
        fade_not_zero= AnimationUtils.loadAnimation(this, R.anim.fade_not_row);
        fade_not_zero.setStartOffset(duration);
        b.startAnimation(fade_not_zero);
        b.setText("" + value);
        b.setVisibility(View.VISIBLE);
    }

    public void reverse_anim()
    {
        int i;
        int row[] = rowAlignment();

        for (i = 0; i < 16; i++)
        {

            Button b = (Button) findViewById(button_arr[i]);
            if (i <= 3 && row[0] == 1 || i >= 4 && i <= 7 && row[1] == 1 || i >= 8 && i <= 11 && row[2] == 1 || i >= 12 && i <= 15 && row[3] == 1)
            {
                anim_reverse = AnimationUtils.loadAnimation(this, R.anim.anim_reverse);
                b.startAnimation(anim_reverse);
            }
            else
                anim_reverse_not_row = AnimationUtils.loadAnimation(this, R.anim.anim_reverse_not_row);
        }
    }
    
    
    public void anim_fade_zero(int id)
    {
           final Button b = (Button) findViewById(id);
            fade_zero = AnimationUtils.loadAnimation(this, R.anim.fade_zero_anim);
        b.startAnimation(fade_zero);
       fade_zero.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                b.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });
    }

    public void five()
    {
        d1++;
        question_left.setText("Questions Left : " + (5 - d1));
        int i = 0;
        int off=0;
        int initial=500;
        if(d1==4)
            initial=200;

      int row[]= rowAlignment();
if(row[0]==1)
    anim_fade_zero(button_arr[3]);
        if(row[1]==1)
            anim_fade_zero(button_arr[7]);
        if(row[2]==1)
            anim_fade_zero(button_arr[11]);
        if(row[3]==1)
            anim_fade_zero(button_arr[15]);

        //int pos=0;
        int c[]=new int [16];
        for(i=0;i<16;i++)
            c[i]=0;
        int d=0;
            while(d!=16)
            {
                i = (int) (Math.random() * 16);
                if (c[i] == 0)
                {
                    if (i <= 3 && row[0] == 1 || i >= 4 && i <= 7 && row[1] == 1 || i >= 8 && i <= 11 && row[2] == 1 || i >= 12 && i <= 15 && row[3] == 1)
                    {
                        if (a2[d1][i] != 0)
                        {
                            anim_fade_row(button_arr[i], initial + initial * off, a2[d1][i]);
                            off++;
                        }
                        // else
                        //   anim_fade_zero(button_arr[i]);
                    }
                    else
                    {
                        anim_fade_not_row(button_arr[i], initial + initial * off, a2[d1][i]);
                        off++;
                    }
                    c[i] = 1;
                    d++;
                }
            }

            t = new CountDownTimer(off * initial+500, off * initial+500)
            {
                public void onTick(long millis)
                {
                    s1 = millis;
                }

                public void onFinish()
                {

                    yes.setClickable(true);
                    no.setClickable(true);
                }
            };
            t.start();

       // Log.e("ayush","five");
    }

    public void six()
    {

        d2++;
        question_left.setText("Questions Left : " + (6 - d2));
        int i ;
        int off = 0;
        int initial=500;
     int row[]=rowAlignment();
        if(d2==5)
            initial=200;

        if(row[0]==1)
            anim_fade_zero(button_arr[3]);
        if(row[1]==1)
            anim_fade_zero(button_arr[7]);
        if(row[2]==1)
            anim_fade_zero(button_arr[11]);
        if(row[3]==1)
            anim_fade_zero(button_arr[15]);

        int c[]=new int [16];
        for(i=0;i<16;i++)
            c[i]=0;
        int d=0;
            while (d != 16)
            {
                i = (int) (Math.random() * 16);
                if (c[i] == 0)
                {
                    if (i <= 3 && row[0] == 1 || i >= 4 && i <= 7 && row[1] == 1 || i >= 8 && i <= 11 && row[2] == 1 || i >= 12 && i <= 15 && row[3] == 1)
                    {
                        if (a3[d2][i] != 0)
                        {
                            anim_fade_row(button_arr[i], initial + initial * off, a3[d2][i]);
                            off++;
                        }
                        // else
                        //   anim_fade_zero(button_arr[i]);
                    } else
                    {
                        anim_fade_not_row(button_arr[i], initial + initial * off, a3[d2][i]);
                        off++;
                    }
                    c[i] = 1;
                    d++;
                }
            }
        t = new CountDownTimer(off * initial+500, off * initial+500)
        {
            public void onTick(long millis)
            {
                s1 = millis;
            }

            public void onFinish()
            {

                yes.setClickable(true);
                no.setClickable(true);
            }
        };
        t.start();

       // Log.e("ayush","six");
    }


public int[] rowAlignment()
{
    int row[]={0,0,0,0};
    if(choice==0)
    {
        if (a2[d1][3] == 0)
            row[0] = 1;
        if (a2[d1][7] == 0)
            row[1] = 1;
        if (a2[d1][11] == 0)
            row[2] = 1;
        if (a2[d1][15] == 0)
            row[3] = 1;
    }
    else
    {
        if (a3[d2][3] == 0)
            row[0] = 1;
        if (a3[d2][7] == 0)
            row[1] = 1;
        if (a3[d2][11] == 0)
            row[2] = 1;
        if (a3[d2][15] == 0)
            row[3] = 1;
    }
   // Log.e("ayush","error");
    return row;
}







    public void onYesClick(View view)
    {



        yes.setClickable(false);
        no.setClickable(false);
        if(choice==0&&d1<4||choice==1&&d2<5)
         reverse_anim();
        else
         invisible();


        play_music();
        if (choice == 0)
        {

            if (d1 == 4)
            {
               // invisible();
                ans+=sum1[d1];
                go_to_answer();
            }
            else
            {
                ans += sum1[d1];
                // Log.e("ayush", "Yes"+d1);
                five();


            }
        }
        else
        {

            if (d2 == 5)
            {
               // invisible();
                ans+=sum2[d2];
                go_to_answer();
            }
            else
            {
                ans += sum2[d2];
                six();
                // Log.e("ayush", "Yes" + d2);
            }
        }
        //Log.e("ayush",""+ans);
        Log.e("ayush",""+d1+" "+d2);
    }

    public void onNoClick(View view)
    {
        //reverse_anim();
        yes.setClickable(false);
        no.setClickable(false);
        //invisible();
        if(choice==0&&d1<4||choice==1&&d2<5)
            reverse_anim();
        else
            invisible();
        //Log.e("ayush",""+ans);

        play_music();

        if (choice == 0)
        {

            if (d1 == 4)
            {
                invisible();
                go_to_answer();
            }
            else
                five();
            //Log.e("ayush","No"+d1);
        }
        else
        {
            if (d2 == 5)
            {
                invisible();
                go_to_answer();
            }
            else
                six();
            // Log.e("ayush","No"+d2);
        }
        //Log.e("ayush",""+ans);
        Log.e("ayush",""+d1+" "+d2);
    }































    @Override
    protected void onPause()
    {
        super.onPause();
        // t.cancel();

       // for(Animator animator:animlist)
            //animator.resume();
        Log.e("ayush","pause "+d1+" "+d2);
        if (d1==0||d2==0||d1==1||d2==1)
        {
            q1.pause();
            length1 = q1.getCurrentPosition();
        }
        else if (d1 == 2 || d2==2||d2==3)
        {
            q2.pause();
            length2 = q2.getCurrentPosition();
        }
        else if (d1 == 3 || d2 == 4)
        {
            q3.pause();
            length3 = q3.getCurrentPosition();
        }
        else if(d1==4||d2==5)
        {
            q4.pause();
            length4 = q4.getCurrentPosition();
        }

    }

    @Override
    protected void onResume()
    {
        super.onResume();
stopper=0;
        //for(Animator animator:animlist)
          //  animator.resume();
        Log.e("ayush","resume"+d1+" "+d2);
        if (d1==0||d2==0||d1==1||d2==1)
        {
            q1.seekTo(length1);
            q1.start();
        }
        else if (d1 == 2 || d2==2||d2==3)
        {
            q2.seekTo(length2);
            q2.start();
        }
        else if (d1 == 3 || d2 == 4)
        {
            q3.seekTo(length3);
            q3.start();
        }
        else if(d1==4||d2==5)
        {
            q4.seekTo(length4);
            q4.start();
        }

    }

    public void setColor(ObjectAnimator obj, long sec)
{
    obj.setDuration(sec);
    obj.setEvaluator(new ArgbEvaluator());
    obj.setRepeatCount(ValueAnimator.INFINITE);
    obj.setRepeatMode(ValueAnimator.REVERSE);
    obj.start();
}



    public void play_music()
    {
        if(d1==0||d2==0)
        {
         q1.seekTo(0);
            q1.start();
        }
        else if (d1 == 1 || d2 == 1||d2==2)
        {
            q1.setLooping(false);
            q1.stop();

            service.shutdown();



            if(d2==2)
            {
            q2.seekTo(0);
            }

            q2.start();

            pb.setMax(q2.getDuration());
            pb.setProgress(0);

            service=Executors.newScheduledThreadPool(1);
            service.scheduleWithFixedDelay(new Runnable()
            {
                @Override
                public void run()
                {
                    pb.setProgress(q2.getCurrentPosition());
                }
            }, 0, 1, TimeUnit.MICROSECONDS);

        }
        else if (d1 == 2 || d2==3)
        {
            q1.setLooping(false);
            q2.setLooping(false);
            q2.stop();

            service.shutdown();
            pb.setMax(q3.getDuration());
            pb.setProgress(0);
            service=Executors.newScheduledThreadPool(1);
            service.scheduleWithFixedDelay(new Runnable()
            {
                @Override
                public void run()
                {
                    pb.setProgress(q3.getCurrentPosition());
                }
            }, 0, 1, TimeUnit.MICROSECONDS);

            q3.start();
        }
        else if (d1 == 3 || d2 == 4)
        {
            q3.setLooping(false);
            q3.stop();

           service.shutdown();
            pb.setMax(q4.getDuration());
            pb.setProgress(0);
service=Executors.newScheduledThreadPool(1);
            service.scheduleWithFixedDelay(new Runnable()
            {
                @Override
                public void run()
                {
                    pb.setProgress(q4.getCurrentPosition());
                }
            }, 0, 1, TimeUnit.MICROSECONDS);

            q4.start();
        }
        else if(d1==4||d2==5)
        {
            service.shutdown();
            q4.setLooping(false);
            q4.stop();
        }
    }

    public void go_to_answer()
    {
        Intent i = new Intent(game.this, answer.class);
        invisible();
       i.putExtra("Answer",""+ans);
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder exit_message = new AlertDialog.Builder(this);
        exit_message.setTitle("Stop Playing?");
        exit_message.setMessage("Are you sure want to stop playing?");
        exit_message.setPositiveButton("NO", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {

            }
        });

        exit_message.setNegativeButton("YES", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                q1.stop();
                q2.stop();
                q3.stop();
                q4.stop();
                q5.stop();
                finish();
                onLeaveThisActivity();
                //finish();

            }
        });
        exit_message.show();

    }

    public void invisible()
    {
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);
        b6.setVisibility(View.INVISIBLE);
        b7.setVisibility(View.INVISIBLE);
        b8.setVisibility(View.INVISIBLE);
        b9.setVisibility(View.INVISIBLE);
        b10.setVisibility(View.INVISIBLE);
        b11.setVisibility(View.INVISIBLE);
        b12.setVisibility(View.INVISIBLE);
        b13.setVisibility(View.INVISIBLE);
        b14.setVisibility(View.INVISIBLE);
        b15.setVisibility(View.INVISIBLE);
        b16.setVisibility(View.INVISIBLE);
    }

    protected void onLeaveThisActivity()
    {
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }

    public void create(int r)
    {
        int i, j;
        for (i = 0; i < 5; i++)
        {
            sum1[i] = 0;
            for (j = 0; j < 16; j++)
                a2[i][j] = 0;
        }

        for (i = 0; i < 6; i++)
        {
            sum2[i] = 0;
            for (j = 0; j < 16; j++)
                a3[i][j] = 0;
        }

        int d = 0, e;

        if(r==0)
        {
            int c[]={0,0,0,0,0};
            while(d!=5)
            {
                int r1=(int)(Math.random()*5);
                if(c[r1]==0)
                {
                    c[r1]=1;
                    sum1[d]=a[r1][0];
                    d++;
                    int c1[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                    e=0;
                    while(e!=16)
                    {
                        int r2 = (int) (Math.random() * 16);
                        if (c1[r2] == 0)
                        {
                            c1[r2] = 1;
                            e++;
                            a2[d-1][e-1]=a[r1][r2];
                        }
                    }
                    for(j=0;j<16;j++)
                    {
                        if(a2[d-1][j]==0&&(j+1)%4!=0)
                        {
                            int arr[]={4,8,12,16};
                            int f2=0;
                            while(f2==0)
                            {
                                int r3=(int) (Math.random() * 4);
                                int j1=arr[r3]-1;
                                if(a2[d-1][j1]!=0)
                                {
                                    int temp=a2[d-1][j1];
                                    a2[d-1][j1]=a2[d-1][j];
                                    a2[d-1][j]=temp;
                                    f2=1;
                                }
                            }
                        }
                    }
                }
            }
        }

        else
        {

            int c[] = {0, 0, 0, 0, 0, 0};
            while (d != 6)
            {
                int r1 = (int) (Math.random() * 6);
                if (c[r1] == 0)
                {
                    c[r1] = 1;
                    sum2[d] = b[r1][0];
                    d++;
                    int c1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    e = 0;
                    while (e != 16)
                    {
                        int r2 = (int) (Math.random() * 16);
                        if (c1[r2] == 0)
                        {
                            c1[r2] = 1;
                            e++;
                            a3[d - 1][e - 1] = b[r1][r2];
                        }
                    }
                    for (j = 0; j < 16; j++)
                    {
                        if (a3[d - 1][j] == 0 && (j + 1) % 4 != 0)
                        {
                            int arr[] = {4, 8, 12, 16};
                            int f2 = 0;
                            while (f2 == 0) {
                                int r3 = (int) (Math.random() * 4);
                                int j1 = arr[r3] - 1;
                                if (a3[d - 1][j1] != 0) {
                                    int temp = a3[d - 1][j1];
                                    a3[d - 1][j1] = a3[d - 1][j];
                                    a3[d - 1][j] = temp;
                                    f2 = 1;
                                }
                            }
                        }
                    }

                }
            }
        }

    }
}
