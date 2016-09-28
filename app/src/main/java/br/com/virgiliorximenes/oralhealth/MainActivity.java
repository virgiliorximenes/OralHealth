package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new Timer().schedule(new ChangeScreen(), 1500);
    }

    private class ChangeScreen extends TimerTask {

        @Override
        public void run() {
            OralHealthUtilities.changeScreen(MainActivity.this, MenuActivity.class);
        }
    }
}
