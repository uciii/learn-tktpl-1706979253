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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    WifiReciever wifiReciever;
    ListAdapter listAdapter;
    ListView wifiListView;
    Button refresh, send;
    TextView responseV;
    List wifiList;

    @SuppressLint("WifiManagerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiListView = findViewById(R.id.list_item);
        refresh = findViewById(R.id.refresh);
        send = findViewById(R.id.send);
        responseV = findViewById(R.id.response);

        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiReciever = new WifiReciever();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWifi();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    private void sendRequest() {
        if(ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 0);
        }


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://570952b4df932d54fdbeb7879af2acf5.m.pipedream.net";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        responseV.setText("Response is: "+ response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        responseV.setText("That didn't work!");
                    }
                }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("wifi_list",wifiList.toString());
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("Content-Type","application/x-www-form-urlencoded");
                    return params;
                }
        };

        queue.add(stringRequest);

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