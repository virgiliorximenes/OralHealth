package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.virgiliorximenes.oralhealth.database.OralHealthDAO;
import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

public class FatherActivity extends Activity implements View.OnClickListener {

    private static final int MENU = 100;
    private static final int TUTORIAL = 200;
    private static final int KNOW_MORE = 300;
    private static final int TIPS = 400;

    private int actualPhase;
    private int currentPage;
    private int activityScreen;
    private OralHealthDAO oralHealthDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureFatherMenu();

        oralHealthDAO = OralHealthDAO.getInstance(this);
    }

    private void configureFatherMenu() {
        setContentView(R.layout.activity_father);
        findViewById(R.id.tutorial_menu).setOnClickListener(this);
        findViewById(R.id.know_more_menu).setOnClickListener(this);
        findViewById(R.id.tips_menu).setOnClickListener(this);
        activityScreen = MENU;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tutorial_menu:
                configureTutorial();
                break;
            case R.id.know_more_menu:
                configureKnowMore();
                break;
            case R.id.tips_menu:
                configureTips();
                break;
            case R.id.tutorial_button:
                nextPage();
                break;
        }
    }

    private void configureTips() {
        if (oralHealthDAO.hasChild()) {
            actualPhase = oralHealthDAO.getActualPhase();

            if (actualPhase == 0 || actualPhase == 1) {
                Toast.makeText(this, getString(R.string.not_enough_phase), Toast.LENGTH_SHORT).show();
            } else {
                setContentView(R.layout.tutorial);
                findViewById(R.id.tutorial_button).setOnClickListener(this);
                activityScreen = TIPS;
                currentPage = 0;

                ((TextView) findViewById(R.id.tutorial_text)).setText(R.string.tip_phase_2);
            }
        } else {
            Toast.makeText(this, getString(R.string.father_permission_denied), Toast.LENGTH_SHORT).show();
        }
    }

    private void configureKnowMore() {
        if (oralHealthDAO.hasChild()) {
            actualPhase = oralHealthDAO.getActualPhase();

            setContentView(R.layout.tutorial);
            findViewById(R.id.tutorial_button).setOnClickListener(this);
            activityScreen = KNOW_MORE;
            currentPage = 0;

            ((TextView) findViewById(R.id.tutorial_text)).setText(R.string.know_more_content_A);
        } else {
            Toast.makeText(this, getString(R.string.father_permission_denied), Toast.LENGTH_SHORT).show();
        }
    }

    private void nextPage() {
        if (activityScreen == TUTORIAL) {
            if (currentPage == 7) {
                configureFatherMenu();
            } else {
                currentPage++;
                nextPageTutorial();
            }
        } else if (activityScreen == KNOW_MORE) {
            if (currentPage == 3) {
                configureFatherMenu();
            } else {
                if (currentPage >= actualPhase) {
                    Toast.makeText(this, getString(R.string.not_enough_phase), Toast.LENGTH_SHORT).show();
                } else {
                    currentPage++;
                    nextPageKnowMore();
                }
            }
        } else if (activityScreen == TIPS) {
            if (currentPage == 2) {
                configureFatherMenu();
            } else {
                if (currentPage + 2 >= actualPhase) {
                    Toast.makeText(this, getString(R.string.not_enough_phase), Toast.LENGTH_SHORT).show();
                } else {
                    currentPage++;
                    nextPageTips();
                }
            }
        }
    }

    private void nextPageTips() {
        int page = 0;
        switch (currentPage) {
            case 0:
                page = R.string.tip_phase_2;
                break;
            case 1:
                page = R.string.tip_phase_3;
                break;
            case 2:
                page = R.string.tip_phase_4;
                break;
        }

        ((TextView) findViewById(R.id.tutorial_text)).setText(page);
    }

    private void nextPageKnowMore() {
        int page = 0;
        switch (currentPage) {
            case 0:
                page = R.string.know_more_content_A;
                break;
            case 1:
                page = R.string.know_more_content_B;
                break;
            case 2:
                page = R.string.know_more_content_C;
                break;
            case 3:
                page = R.string.know_more_content_D;
                break;
        }

        ((TextView) findViewById(R.id.tutorial_text)).setText(page);
    }

    private void nextPageTutorial() {
        int page = 0;
        switch (currentPage) {
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
        activityScreen = TUTORIAL;
        currentPage = 0;

        ((TextView) findViewById(R.id.tutorial_text)).setText(R.string.tutorial_partA);
    }

    @Override
    public void onBackPressed() {
        if (activityScreen == TUTORIAL || activityScreen == KNOW_MORE || activityScreen == TIPS) {
            previousPage();
        } else {
            OralHealthUtilities.changeScreen(this, MenuActivity.class);
        }
    }

    private void previousPage() {
        if (currentPage == 0) {
            configureFatherMenu();
        } else {
            currentPage--;
            if (activityScreen == TUTORIAL) {
                nextPageTutorial();
            } else if (activityScreen == TIPS) {
                nextPageTips();
            } else if (activityScreen == KNOW_MORE) {
                nextPageKnowMore();
            }
        }

    }
}
