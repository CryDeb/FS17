package ch.dane.wicki.persistenz_danewicki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String RESUME_COUNTER_KEY = "ResumeCounterKey";
    private final String FAVORITE_TEA_WITH_SUGAR = "teaWithSugar";
    private final String FAVORITE_TEA_SUGAR = "teaSweetener";
    private final String FAVORITE_TEA_PREFFERED = "teaPreffered";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.incSavedPreferences();
        this.reloadSavedPreferences();
    }
    private void reloadSavedPreferences(){
        TextView myFavoriteTeaText = (TextView) findViewById(R.id.favoriteTee);
        final SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String teaSugarType = myPreferences.getString(this.FAVORITE_TEA_SUGAR, "ohne Zucker");
        final String teaPreffered = myPreferences.getString(this.FAVORITE_TEA_PREFFERED, "?");
        myFavoriteTeaText.setText(String.format("mein Lieblingstee ist %s, mit %s", teaPreffered, teaSugarType));
    }

    private void incSavedPreferences(){
        final SharedPreferences myPreferences = getPreferences(MODE_PRIVATE);
        final int resumeCount = myPreferences.getInt(this.RESUME_COUNTER_KEY, 0);
        final SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt(this.RESUME_COUNTER_KEY, resumeCount);
        myEditor.apply();
        this.setOnResumeCountString(resumeCount);
    }

    private void setOnResumeCountString(final int onResumeCounter){
        TextView countOnResumeText = (TextView) findViewById(R.id.numbersOfOnResume);
        String prefixStringOfText = getResources().getString(R.string.mainActivityOnResume);
        countOnResumeText.setText(String.format(prefixStringOfText, onResumeCounter));
    }

    protected void startPreferenceActivity(View v){
        Intent i = new Intent(this, TeaPreferenceActivity.class);
        startActivity(i);
    }

    protected void setTeaDefaultValues(View v){
        final SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putBoolean(this.FAVORITE_TEA_PREFFERED, false);
        myEditor.putString(this.FAVORITE_TEA_PREFFERED, "Lipton/Pfefferminze");
        myEditor.apply();
        this.reloadSavedPreferences();
    }
}
