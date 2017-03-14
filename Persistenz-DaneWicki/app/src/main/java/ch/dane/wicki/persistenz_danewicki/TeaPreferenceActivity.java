package ch.dane.wicki.persistenz_danewicki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TeaPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new TeaPreferenceInitializer()).commit();
    }
}
