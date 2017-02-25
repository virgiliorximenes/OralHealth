package br.com.virgiliorximenes.oralhealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import br.com.virgiliorximenes.oralhealth.database.OralHealthDAO;
import br.com.virgiliorximenes.oralhealth.utils.OralHealthUtilities;

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
            ImageView imageView = (ImageView) findViewById(R.id.avatar_image);
            imageView.setImageResource(R.drawable.avatar_boy);
            imageView.setContentDescription(getString(R.string.gender_male));
        } else if (R.id.gender_female == view.getId()) {
            ImageView imageView = (ImageView) findViewById(R.id.avatar_image);
            imageView.setImageResource(R.drawable.avatar_girl);
            imageView.setContentDescription(getString(R.string.gender_female));
        } else if (R.id.choose_avatar == view.getId()) {

            EditText editText = (EditText) findViewById(R.id.char_name);
            String name = editText.getText().toString();

            RadioButton genderFemale = (RadioButton) findViewById(R.id.gender_female);
            RadioButton genderMale = (RadioButton) findViewById(R.id.gender_male);
            String gender = genderFemale.isSelected() ? getString(R.string.gender_female) : (genderMale.isSelected() ? getString(R.string.gender_male) : null);

            if (OralHealthUtilities.isEmpty(name)) {
                Toast.makeText(this, R.string.error_name, Toast.LENGTH_SHORT).show();
            } else if (OralHealthUtilities.isEmpty(gender)) {
                Toast.makeText(this, R.string.error_gender, Toast.LENGTH_SHORT).show();
            } else {
                OralHealthDAO.getInstance(this).insertChild(name, gender);

                OralHealthUtilities.changeScreen(this, StoryActivity.class);
            }

        }
    }

    @Override
    public void onBackPressed() {
        OralHealthUtilities.changeScreen(this, MenuActivity.class);
    }
}
