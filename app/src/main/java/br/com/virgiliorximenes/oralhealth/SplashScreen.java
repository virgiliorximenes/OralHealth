package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(SplashScreen.this, MainActivity.class);

                startActivity(intent);
            }
        }, SPLASH_TIME_OUT);
    }
}
