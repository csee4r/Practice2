package com.example.yun.caalarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class IntroActivity extends AppCompatActivity {
    Intent intent;
    Animation anim;
    RelativeLayout introLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        introLayout = (RelativeLayout) findViewById(R.id.introLayout);
        anim = AnimationUtils.loadAnimation(IntroActivity.this, R.anim.anim);

        /****************/
        //프리퍼런스 값 읽어오기
        SharedPreferences pref = getSharedPreferences("PrefName",MODE_PRIVATE);
        String isToken = pref.getString("token","no");

        if (isToken.equals("no")){  // 저장된 토큰값이 없을때
            // 로그인or회원가입화면 즉 MainActivity
            intent =
                    new Intent(IntroActivity.this, LoginActivity.class);
        }else {            // 토큰값이 있을때
            // 이미 로그인 한 이력이 있을때(자동로그인 선택시)  HomeActivity
            intent = new Intent(IntroActivity.this, MainActivity.class);
        }
        /***************/


        handler.sendEmptyMessage(0);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        introLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeMessages(0);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeMessages(0);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            introLayout.startAnimation(anim);

        }
    };
}
