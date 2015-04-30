package com.example.user01.myapplication.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user01.myapplication.R;
import com.example.user01.myapplication.model.pojo.BusLine;

import java.util.ArrayList;
import java.util.List;

public class CustomBusLineAdapter extends ArrayAdapter<BusLine> {
    public CustomBusLineAdapter(Context context, List<BusLine> busLines) {
        super(context, 0, busLines);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BusLine busLine = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bus_line_list, parent, false);
        }

        TextView shortNameField = (TextView) convertView.findViewById(R.id.shortName);
        shortNameField.setText(busLine.getLongName());

        TextView longNameField = (TextView) convertView.findViewById(R.id.longName);
        longNameField.setText("Bus line " + busLine.getShortName());

        return convertView;
    }
}