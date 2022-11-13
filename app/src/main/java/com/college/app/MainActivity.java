package com.college.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.college.app.polytechnic.Polytechnic;
import com.college.app.polytechnic.initials.Login;

public class MainActivity extends AppCompatActivity {
    private ImageView img1,img2;
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private LinearLayout lin_clg;
    private TextView polytechnic,technology;
    private static SharedPreferences Globlevar;

    public static SharedPreferences getGloblevar() {
        return Globlevar;
    }

    public void setGloblevar(SharedPreferences globlevar) {
        Globlevar = globlevar;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        fadeOutAndHideImage(img1,img2);

    }

    private void initUI() {
        polytechnic=findViewById(R.id.sp_btn_polytechnic);
        technology=findViewById(R.id.sp_btn_technology);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        lin_clg=findViewById(R.id.lin_clg);
    }


    private void fadeOutAndHideImage(final ImageView img,ImageView Img1)
    {
        // Fade Animation code
        Animation fadeOut = new AlphaAnimation(0,1);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000); // How long it takes for the animation to complete in milliseconds

        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            // Once the animation is done, set the visibility of the logo to GONE and navigate to the MainActivity after the set amount of time.
            public void onAnimationEnd(Animation animation)
            {
                new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                final SharedPreferences sharedPreferences=getSharedPreferences("agpi", Context.MODE_PRIVATE);
                setGloblevar(sharedPreferences);
                String type=sharedPreferences.getString("clg_choice","");
                if(type.isEmpty())
                {
                    lin_clg.setVisibility(View.VISIBLE);
                    polytechnic.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startPolytechnic();
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("clg_choice","polytechnic");
                            editor.commit();

                        }
                    });
                    technology.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startTechnology();
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("clg_choice","technology");
                            editor.commit();
                        }
                    });
                }
                else{
                    if(String.valueOf(type).equals("polytechnic")==true){
                        startPolytechnic();
                    }else{startTechnology();}
                }
            }
        }, 500);

            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {
                TranslateAnimation animate = new TranslateAnimation(
                        0,
                        0,
                        img.getHeight(),
                        0);
                animate.setDuration(1000);
                animate.setFillAfter(true);
                img.startAnimation(animate);

            }
        });

        img.startAnimation(fadeOut);
        Img1.startAnimation(fadeOut);

    }



    private void startPolytechnic(){

        Intent intent=new Intent(MainActivity.this, Login.class);
        startActivity(intent);
        finish();
    }

    private void startTechnology(){

        Intent intent=new Intent(MainActivity.this,Technology.class);
        startActivity(intent);
        finish();
    }


}