package br.com.virgiliorximenes.oralhealth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends Activity implements View.OnClickListener {

    private boolean showAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenu();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.about_button) {
            initAbout();
        } else if (view.getId() == R.id.menu_start) {
            initGame();
        }
    }

    private void initGame() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(R.string.game_name)
                .setMessage(R.string.choose_area)
                .setPositiveButton(R.string.option_father, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        configureFather();
                    }
                })
                .setNeutralButton(R.string.option_son, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        configureSon();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void configureSon() {
        Intent intent = new Intent();
        intent.setClass(this, AvatarActivity.class);

        startActivity(intent);
    }

    private void configureFather() {
        String emailFather = null;
        Account[] accounts = AccountManager.get(getApplicationContext()).getAccounts();
        for (Account account : accounts) {
            if (Patterns.EMAIL_ADDRESS.matcher(account.name).matches()) {
                emailFather = account.name;
            }
        }
        Toast.makeText(getApplicationContext(),
                String.format(getResources().getString(R.string.welcome_father), emailFather),
                Toast.LENGTH_SHORT).show();
        // TODO: Implement this method
    }

    private void initMenu() {
        showAbout = false;
        setContentView(R.layout.menu);

        findViewById(R.id.menu_start).setOnClickListener(this);
        findViewById(R.id.about_button).setOnClickListener(this);
    }

    private void initAbout() {
        showAbout = true;
        setContentView(R.layout.about);
    }

    @Override
    public void onBackPressed() {
        if (showAbout) {
            initMenu();

        } else {
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

}
