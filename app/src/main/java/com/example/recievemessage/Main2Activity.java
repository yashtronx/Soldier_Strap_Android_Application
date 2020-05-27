package com.example.recievemessage;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import gr.net.maroulis.library.EasySplashScreen;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(Main2Activity.this)
                .withFullScreen()
                .withTargetActivity(Mainpage.class)
                .withSplashTimeOut(2500)
                .withBackgroundColor(Color.parseColor("#00574B"))
                .withHeaderText("")
                .withFooterText("")
                .withBeforeLogoText("")
                .withAfterLogoText("Soldier Strap")
                .withLogo(R.mipmap.ic_launcher);

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}

