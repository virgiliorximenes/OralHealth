package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import br.com.virgiliorximenes.oralhealth.database.OralHealthDAO;
import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new Timer().schedule(new TimerTask(){

            /**
             * The task to run should be specified in the implementation of the {@code run()}
             * method.
             */
            @Override
            public void run() {
                OralHealthUtilities.changeScreen(MainActivity.this, MenuActivity.class);
            }
        }, 1500);
    }

    @Override
    protected void onDestroy() {
        OralHealthDAO.getInstance(this).close();
        super.onDestroy();
    }
}
