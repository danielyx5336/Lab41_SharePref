package my.edu.tarc.lab41_sharepref;

import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {
    private static final String PREF_FILE = "my.edu.tarc.lab41_sharepref";
    private EditText editTextName;
    private RadioGroup radioGroupGeneder;
    private RadioButton radioButtonMale, radioButtonFemale;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        editTextName = findViewById(R.id.editTextName);
        radioGroupGeneder = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Read the Shared Preference File
        sharedPreferences = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
        // OR
        //sharedPreferences = getPreferences(MODE_PRIVATE);
        String name;
        int gender; // default = -1, male - 1, female = 0
        name = sharedPreferences.getString("username","Yong Xian");
        gender = sharedPreferences.getInt("gender",-1);
        editTextName.setText(name);

        if(gender == 1){
            radioButtonMale.setChecked(true);
        }else if(gender == 0){
            radioButtonFemale.setChecked(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Create a Shared Pref Editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name;
        int gender;

        name = editTextName.getText().toString();
        editor.putString("username",name);
        gender  = radioGroupGeneder.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            editor.putInt("gender", 1);
        }else if(gender == R.id.radioButtonFemale){
            editor.putInt("gender", 0);
        }else{
            editor.putInt("gender", -1);
        }
        //Apply all changes to the Shared Preferences
        editor.apply();
    }
}
