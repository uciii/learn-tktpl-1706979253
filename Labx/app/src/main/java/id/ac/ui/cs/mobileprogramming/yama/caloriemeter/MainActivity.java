package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = (TextView) findViewById(R.id.show_count);
    }

    public void countDown(View view) {
        counter--;
        showCount.setText(Integer.toString(counter));
    }

    public void countUp(View view) {
        counter++;
        showCount.setText(Integer.toString(counter));
    }

    public void countReset(View view) {
        counter = 0;
        showCount.setText(Integer.toString(counter));

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256));
        showCount.setBackgroundColor(color);
    }
}