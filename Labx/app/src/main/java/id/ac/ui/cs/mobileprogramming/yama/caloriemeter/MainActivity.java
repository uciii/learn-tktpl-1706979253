package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    protected Button exitBut;
    protected Button startBut;
    protected Button resetBut;
    protected TextView timer;
    protected boolean isStart = false;
    protected AnAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitBut = findViewById(R.id.exit);
        startBut = findViewById(R.id.start);
        resetBut = findViewById(R.id.reset);
        timer = findViewById(R.id.time);

        exitBut.setOnClickListener(exitEvent);
        startBut.setOnClickListener(timerEvent);
        resetBut.setOnClickListener(timerEvent);
    }

    protected View.OnClickListener exitEvent = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.exit){
                MainActivity.super.onBackPressed();
            }
        }
    };

    protected View.OnClickListener timerEvent = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.start){
                if (!isStart) {
                    task = new AnAsyncTask(timer);
                    isStart = true;
                    task.execute();
                }
            }
            else if(view.getId() == R.id.reset){
                if (isStart) {
                    isStart = false;
                    task.stopTask();
                }
            }
        }
    };
}

class AnAsyncTask extends AsyncTask<Void, Integer, Integer> {
    protected TextView timer;
    protected boolean isStop = false;

    public AnAsyncTask(TextView timer){
        this.timer = timer;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        Integer i = 0;
        while (!isStop) {
            publishProgress(i);
            sleepSecond();
            i++;
        }
        return 1;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        timer.setText(values[0].toString());
    }

    @Override
    protected void onPostExecute(Integer values) {
        timer.setText("0");
    }

    private void sleepSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignore) {}
    }

    public void stopTask(){
        isStop = true;
    }
}