package br.com.virgiliorximenes.oralhealth.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import br.com.virgiliorximenes.oralhealth.R;

public class OralHealthUtilities {


    public static  void closeApp(final Activity activity) {
        new AlertDialog.Builder(activity)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.game_name)
                .setMessage(R.string.exit_game)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .show();
    }

    public static void changeScreen(final Activity activity, Class clazz) {
        Intent intent = new Intent();
        intent.setClass(activity, clazz);

        activity.finish();
        activity.startActivity(intent);
    }

    public static boolean isValidCpf(String cpf) {
        return !cpf.isEmpty();
    }

    public static boolean isEmpty(String param) {
        return param == null || param.isEmpty();
    }
}
