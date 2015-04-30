package com.example.user01.myapplication.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user01.myapplication.R;
import com.example.user01.myapplication.model.pojo.BusStop;

import java.util.List;

public class CustomBusStopAdapter extends ArrayAdapter<BusStop> {
    public CustomBusStopAdapter(Context context, List<BusStop> busStops) {
        super(context, 0, busStops);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BusStop busStop = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bus_detail_list, parent, false);
        }

        TextView busStopText = (TextView) convertView.findViewById(R.id.busStop);
        busStopText.setText(busStop.getName());

        return convertView;
    }
}
