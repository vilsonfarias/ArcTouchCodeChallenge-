package com.example.user01.myapplication.model.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user01.myapplication.R;
import com.example.user01.myapplication.model.pojo.LineDeparture;

import java.util.List;

public class CustomLineDeparturesAdapter extends ArrayAdapter<LineDeparture> {
    public CustomLineDeparturesAdapter(Context context, List<LineDeparture> departures) {
        super(context, 0, departures);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LineDeparture lineDeparture = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bus_stop_list, parent, false);
        }

        TextView lineDepartureText = (TextView) convertView.findViewById(R.id.busStop);
        lineDepartureText.setText(lineDeparture.getTime() + " (" + lineDeparture.getCalendar().toLowerCase() + ")");

        return convertView;
    }
}
