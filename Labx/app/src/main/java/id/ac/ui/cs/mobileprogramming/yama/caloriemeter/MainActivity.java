package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FoodListFragment foodListFragment = new FoodListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, foodListFragment)
                .addToBackStack("food_list")
                .commit();
    }
}