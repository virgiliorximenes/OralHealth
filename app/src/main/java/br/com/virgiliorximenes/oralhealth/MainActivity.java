package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.menuStart).setOnClickListener(this);
        findViewById(R.id.menuConfig).setOnClickListener(this);
        findViewById(R.id.menuAbout).setOnClickListener(this);
        findViewById(R.id.menuExit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.menuStart) {
        } else if (view.getId() == R.id.menuConfig) {
        } else if (view.getId() == R.id.menuAbout) {
        } else if (view.getId() == R.id.menuExit) {
            confirmAndExit();
        }

    }

    @Override
    public void onBackPressed() {
        confirmAndExit();
    }

    private void confirmAndExit() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.game_name)
                .setMessage(R.string.exit_game)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(R.string.no, null)
                .show();
    }


}
