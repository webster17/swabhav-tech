package com.swabhav.santosh.loginapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView userName;
    private Button backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        userName = (TextView) findViewById(R.id.userName);
        backToLogin = (Button) findViewById(R.id.backToLogin);

        userName.setText(getIntent().getStringExtra("userName"));

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(2);
                finish();
            }
        });
    }
}