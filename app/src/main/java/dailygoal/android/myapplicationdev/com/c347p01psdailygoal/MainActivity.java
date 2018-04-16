package dailygoal.android.myapplicationdev.com.c347p01psdailygoal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailygoal);

        Button btnok = (Button) findViewById(R.id.buttonOK);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //group read
                TextView tvread = (TextView) findViewById(R.id.textViewRead);
                RadioGroup rgread = (RadioGroup) findViewById(R.id.radiogroupread);
                int selectedbtnidread = rgread.getCheckedRadioButtonId();
                RadioButton rbread = (RadioButton) findViewById(selectedbtnidread);
                String[] read = {tvread.getText().toString(), rbread.getText().toString() };

                //group arrive
                TextView tvarrive = (TextView) findViewById(R.id.textViewArrive);
                RadioGroup rgarrive = (RadioGroup) findViewById(R.id.radiogrouparrive);
                int selectedbtnidarrive = rgarrive.getCheckedRadioButtonId();
                RadioButton rbarrive = (RadioButton) findViewById(selectedbtnidarrive);
                String[] arrive = {tvarrive.getText().toString(), rbarrive.getText().toString() };

                //group attempt
                TextView tvattempt = (TextView) findViewById(R.id.textViewAttempt);
                RadioGroup rgattempt = (RadioGroup) findViewById(R.id.radiogroupattempt);
                int selectedbtnidattempt = rgattempt.getCheckedRadioButtonId();
                RadioButton rbattempt = (RadioButton) findViewById(selectedbtnidattempt);
                String[] attempt = {tvattempt.getText().toString(), rbattempt.getText().toString() };

                //reflection
                TextView tvreflection = (TextView) findViewById(R.id.textViewReflection);
                EditText etreflection = (EditText) findViewById(R.id.editTextReflection);
                String[] reflection = {tvreflection.getText().toString(), etreflection.getText().toString() };


                //sharedpreferences
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();
                int selectionread = rgread.getCheckedRadioButtonId();
                prefEdit.putInt("reads",selectionread);

                int selectionarrive = rgarrive.getCheckedRadioButtonId();
                prefEdit.putInt("arrives",selectionarrive);

                int selectionattempt = rgattempt.getCheckedRadioButtonId();
                prefEdit.putInt("attempts",selectionattempt);

                String rf = etreflection.getText().toString();
                prefEdit.putString("reflections",rf);
                prefEdit.commit();


                Intent i = new Intent(MainActivity.this, Summary.class);
                i.putExtra("read", read);
                i.putExtra("arrive", arrive);
                i.putExtra("attempt", attempt);
                i.putExtra("reflection", reflection);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();

        //sharedpreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor prefEdit = prefs.edit();

        RadioGroup rgread = (RadioGroup) findViewById(R.id.radiogroupread);
        int selectionread = rgread.getCheckedRadioButtonId();
        prefEdit.putInt("reads",selectionread);

        RadioGroup rgarrive = (RadioGroup) findViewById(R.id.radiogrouparrive);
        int selectionarrive = rgarrive.getCheckedRadioButtonId();
        prefEdit.putInt("arrives",selectionarrive);

        RadioGroup rgattempt = (RadioGroup) findViewById(R.id.radiogroupattempt);
        int selectionattempt = rgattempt.getCheckedRadioButtonId();
        prefEdit.putInt("attempts",selectionattempt);

        EditText etreflection = (EditText) findViewById(R.id.editTextReflection);
        String rf = etreflection.getText().toString();
        prefEdit.putString("reflections",rf);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        int readid = prefs.getInt("reads",0);
        int arriveid = prefs.getInt("arrives",0);
        int attemptid = prefs.getInt("attempts",0);
        String rftext = prefs.getString("reflections","nil");

        RadioGroup rgread = (RadioGroup) findViewById(R.id.radiogroupread);
        rgread.check(readid);

        RadioGroup rgarrive = (RadioGroup) findViewById(R.id.radiogrouparrive);
        rgarrive.check(arriveid);

        RadioGroup rgattempt = (RadioGroup) findViewById(R.id.radiogroupattempt);
        rgattempt.check(attemptid);

        EditText etreflection = (EditText) findViewById(R.id.editTextReflection);
        etreflection.setText(rftext);
    }
}
