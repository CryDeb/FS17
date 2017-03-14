package ch.dane.wicki.ui_demo_danewicki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int counter;
    private int statePositionOfSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        counter = 0;
        this.statePositionOfSpinner = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.spinnerWithToast);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (MainActivity.this.statePositionOfSpinner != position) {
                        Toast.makeText(parent.getContext(), "The value" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                        MainActivity.this.statePositionOfSpinner = position;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            }
        );
    }
    public void openNewLayoutActivity(View v){
        Intent i;
        if(v.getId() == R.id.relative){
            i= new Intent(this, RelativeLayoutDemoActivity.class);
        }else{
            i= new Intent(this, LinearLayoutDemoActivity.class);

        }
        startActivity(i);
    }
    public void openRatingBarActivity(View v){
        Intent i = new Intent(this, MyRatingBar.class);
        startActivity(i);
    }
    public void incrementCounterAndShowAsToast(View v){
        this.counter++;
        Toast.makeText(getApplicationContext(), "The Value is: "+this.counter, Toast.LENGTH_SHORT).show();

    }
}
