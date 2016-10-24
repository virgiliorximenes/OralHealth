package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

public class FatherActivity extends Activity implements View.OnClickListener {

    private int currentTutorialPage;
    private boolean tutorialPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureFatherMenu();
    }

    private void configureFatherMenu() {
        setContentView(R.layout.activity_father);
        findViewById(R.id.tutorial_menu).setOnClickListener(this);
        findViewById(R.id.know_more_menu).setOnClickListener(this);
        findViewById(R.id.tips_menu).setOnClickListener(this);
        tutorialPage = false;
        currentTutorialPage = 0;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tutorial_menu:
                configureTutorial();
                break;
            case R.id.know_more_menu:
                Toast.makeText(this, getString(R.string.know_more_menu), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tips_menu:
                Toast.makeText(this, getString(R.string.tips_menu), Toast.LENGTH_SHORT).show();
                break;
            case R.id.tutorial_button:
                nextPage();
                break;
        }
    }

    private void nextPage() {
        if (currentTutorialPage == 7) {
            configureFatherMenu();
        } else {
            currentTutorialPage++;
            showPageTutorial();
        }
    }

    private void showPageTutorial() {
        int page = 0;
        switch (currentTutorialPage) {
            case 0:
                page = R.string.tutorial_partA;
                break;
            case 1:
                page = R.string.tutorial_partB;
                break;
            case 2:
                page = R.string.tutorial_partC;
                break;
            case 3:
                page = R.string.tutorial_partD;
                break;
            case 4:
                page = R.string.tutorial_partE;
                break;
            case 5:
                page = R.string.tutorial_partF;
                break;
            case 6:
                page = R.string.tutorial_partG;
                break;
            case 7:
                page = R.string.tutorial_partH;
                break;

        }
        TextView tutorialText = (TextView) findViewById(R.id.tutorial_text);
        tutorialText.setText(page);
    }

    private void configureTutorial() {
        setContentView(R.layout.tutorial);
        findViewById(R.id.tutorial_button).setOnClickListener(this);
        tutorialPage = true;
        currentTutorialPage = 0;

    }

    @Override
    public void onBackPressed() {
        if (tutorialPage) {
            previousPage();
        } else {
            OralHealthUtilities.changeScreen(this, MenuActivity.class);
        }
    }

    private void previousPage() {
        if (currentTutorialPage == 0) {
            configureFatherMenu();
        } else {
            currentTutorialPage--;
            showPageTutorial();
        }

    }
}
