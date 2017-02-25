package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class StoryActivity extends Activity implements View.OnClickListener {

    private int actualPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        findViewById(R.id.advance_story_button).setOnClickListener(this);

        actualPage = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.advance_story_button:
                nextPage();
                break;
        }
    }

    private void nextPage() {
        if (actualPage == 7) {
            Toast.makeText(this, "Mostrar boca", Toast.LENGTH_SHORT).show();
        } else {
            actualPage++;
        }
        showPage();
    }

    private void showPage() {
        int page = 0;
        switch (actualPage) {
            case 0:
                page = R.drawable.story_01;
                break;
            case 1:
                page = R.drawable.story_02;
                break;
            case 2:
                page = R.drawable.story_03;
                break;
            case 3:
                page = R.drawable.story_04;
                break;
            case 4:
                page = R.drawable.story_05;
                break;
            case 5:
                page = R.drawable.story_06;
                break;
            case 6:
                page = R.drawable.story_07;
                break;
            case 7:
                page = R.drawable.story_08;
                ((Button)findViewById(R.id.advance_story_button)).setText(R.string.start_game);
                break;
        }
        ((ImageView) findViewById(R.id.story_image)).setImageResource(page);
    }

}
