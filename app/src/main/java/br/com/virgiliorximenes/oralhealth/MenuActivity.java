package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import br.com.virgiliorximenes.oralhealth.database.OralHealthDAO;
import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

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
        OralHealthUtilities.changeScreen(this, AvatarActivity.class);
    }

    private void configureFather() {
        if (!OralHealthDAO.getInstance(this).hasParent()) {

            LayoutInflater inflater = LayoutInflater.from(this);
            View inflate = inflater.inflate(R.layout.register_father, null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(inflate);

            final TextView fatherCpf = (TextView) inflate.findViewById(R.id.father_cpf);

            builder.setCancelable(false)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            OralHealthDAO.getInstance(MenuActivity.this).insertParent(fatherCpf.getText().toString());
                        }

                    })
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }

                    })
                    .create()
                    .show();

        }

        OralHealthUtilities.changeScreen(this, FatherActivity.class);
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
            OralHealthUtilities.closeApp(this);

        }
    }

}
