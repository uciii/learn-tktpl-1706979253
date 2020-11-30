package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    WifiReciever wifiReciever;
    ListAdapter listAdapter;
    ListView wifiListView;
    Button refresh, send;
    TextView response;
    List wifiList;

    @SuppressLint("WifiManagerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiListView = findViewById(R.id.list_item);
        refresh = findViewById(R.id.refresh);
        send = findViewById(R.id.send);
        response = findViewById(R.id.response);

        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiReciever = new WifiReciever();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWifi();
            }
        });
    }

    private void showWifi(){
        registerReceiver(wifiReciever,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        if(ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
        else{
            scanWifi();
        }
    }

    private void scanWifi() {
        wifiManager.startScan();
        wifiList = wifiManager.getScanResults();
//        Log.d("TAG", wifiList.toString());
        setAdapter();
    }

    private void setAdapter(){
        listAdapter = new ListAdapter(getApplicationContext(), wifiList);
        wifiListView.setAdapter(listAdapter);
    }

    class WifiReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}