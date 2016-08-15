package br.com.virgiliorximenes.oralhealth;

import android.app.*;
import android.os.*;

import java.util.*;

import android.content.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MenuActivity.class);

                startActivity(intent);
            }
        }, 1500);
    }
}
