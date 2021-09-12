package com.cyruswere.joybeat_week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    //Using BIndView from ButterKnife.
    @BindView(R.id.goToLoginScreen)
    Button login;
    @BindView(R.id.goToSigInScreen) Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //BindViews
        ButterKnife.bind(this);

        //Implemented because of the onclick interface
        login.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Helps us navigate between the log in and the register button.
        if(v == login){
            Intent intent = new Intent(WelcomeActivity.this, LogInActivity.class);
            startActivity(intent);
        }else if(v == register){
            Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

    }
}