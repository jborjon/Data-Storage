package edu.byui.theawesomes.increment;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button advance;
    public Button save;
    public TextView counter;
    public int counterInt;
    //public static final settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences("MyPrefsFile", 0);
        counterInt = settings.getInt("Countation", 0);

        counter = (TextView) findViewById(R.id.counter);
        advance = (Button) findViewById(R.id.advance);
        save = (Button) findViewById(R.id.save);
        counter.setText("" + counterInt);

        advance.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                counterInt++;
                counter.setText("" + counterInt);
            }
        });

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences fieldValue = getSharedPreferences("MyPrefsFile", 0);
                SharedPreferences.Editor editor = fieldValue.edit();
                editor.putInt("Countation", counterInt);

                //commit the values
                editor.commit();
            }
        });
    }
}