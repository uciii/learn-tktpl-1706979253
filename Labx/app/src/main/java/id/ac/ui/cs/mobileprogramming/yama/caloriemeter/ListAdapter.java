package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<ScanResult> wifiList;

    public ListAdapter(Context context, List<ScanResult> wifiList) {
        this.context = context;
        this.wifiList = wifiList;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return wifiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Holder holder;
       View v = convertView;

       if(v == null){
           v = inflater.inflate(R.layout.list_item, null);
           holder = new Holder();

           holder.textView = (TextView)v.findViewById(R.id.wifiList);
           v.setTag(holder);
       }

       else{
           holder = (Holder)v.getTag();
       }

       holder.textView.setText(wifiList.get(position).SSID);
       return v;
    }

    class Holder{
        TextView textView;

    }
}
