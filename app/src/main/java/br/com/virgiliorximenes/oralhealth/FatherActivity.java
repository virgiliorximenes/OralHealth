package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

public class FatherActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureFatherMenu();
    }

    private void configureFatherMenu() {
        setContentView(R.layout.activity_father);
        findViewById(R.id.tutorial_menu).setOnClickListener(this);
        findViewById(R.id.know_more_menu).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tutorial_menu:
                Toast.makeText(this, getString(R.string.tutorial_menu), Toast.LENGTH_SHORT).show();
                break;
            case R.id.know_more_menu:
                Toast.makeText(this, getString(R.string.know_more_menu), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        OralHealthUtilities.changeScreen(this, MenuActivity.class);
    }
}
