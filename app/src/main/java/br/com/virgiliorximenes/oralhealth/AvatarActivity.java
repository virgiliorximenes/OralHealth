package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AvatarActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        findViewById(R.id.gender_male).setOnClickListener(this);
        findViewById(R.id.gender_female).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (R.id.gender_male == view.getId()) {
            ((ImageView) findViewById(R.id.avatar_image))
                    .setImageResource(R.drawable.avatar_boy);
        } else if (R.id.gender_female == view.getId()) {
            ((ImageView) findViewById(R.id.avatar_image))
                    .setImageResource(R.drawable.avatar_girl);
        } else if (R.id.choose_avatar == view.getId()) {
            Toast.makeText(getApplicationContext(), "Not implement yet!", Toast.LENGTH_SHORT).show();
        }
    }
}
