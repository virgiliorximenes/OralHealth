package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showMain();
    }

    private void showMain() {
        setContentView(R.layout.activity_main);

        findViewById(R.id.menuStart).setOnClickListener(this);
        findViewById(R.id.about_button).setOnClickListener(this);
        findViewById(R.id.music_button).setOnClickListener(this);
        findViewById(R.id.sfx_button).setOnClickListener(this);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);

        boolean musicEnabled;
        boolean sfxEnabled;
        if (sharedPreferences.getInt(getString(R.string.app_name), 0) == 1) {
            musicEnabled = sharedPreferences.getBoolean(getString(R.string.music), true);
            sfxEnabled = sharedPreferences.getBoolean(getString(R.string.sfx), true);

        } else {
            musicEnabled = true;
            sfxEnabled = true;

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(getString(R.string.music), musicEnabled);
            editor.putBoolean(getString(R.string.sfx), sfxEnabled);
            editor.putInt(getString(R.string.app_name), 1);
            editor.commit();

        }

        if (musicEnabled) {
            findViewById(R.id.music_button).setOnClickListener(this);
        } else {
            findViewById(R.id.music_button).setOnClickListener(this);
        }

        if (sfxEnabled) {
            findViewById(R.id.sfx_button).setOnClickListener(this);
        } else {
            findViewById(R.id.sfx_button).setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.menuStart) {
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
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }


}
