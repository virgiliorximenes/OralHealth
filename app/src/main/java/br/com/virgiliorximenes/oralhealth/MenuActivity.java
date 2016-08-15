package br.com.virgiliorximenes.oralhealth;

import android.app.*;
import android.os.*;
import android.view.View;
import android.view.View.*;
import android.content.*;

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
			// TODO: Implement this condition.
		}
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
	public void onBackPressed()
	{
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
