package com.example.yun.caalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText loginId;
    EditText loginPwd;
    Button loginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginId = (EditText) findViewById(R.id.loginId);
        loginPwd = (EditText) findViewById(R.id.loginPwd);
        loginBt = (Button) findViewById(R.id.loginBt);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = loginId.getText().toString().trim();
                String pwd = loginPwd.getText().toString().trim();

                //아이디, 패스워드 받아서 reference값으로 넣기

                finish();
                startActivity(new Intent(LoginActivity.this, com.example.yun.caalarm.MainActivity.class));
            }
        });

    }


}
