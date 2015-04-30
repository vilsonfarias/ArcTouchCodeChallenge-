package com.example.user01.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user01.myapplication.model.adapter.CustomBusStopAdapter;
import com.example.user01.myapplication.model.adapter.CustomLineDeparturesAdapter;
import com.example.user01.myapplication.model.pojo.BusStop;
import com.example.user01.myapplication.model.pojo.LineDeparture;
import com.example.user01.myapplication.model.service.BusLineServiceFacade;

import java.util.List;


public class DetailActivity extends ActionBarActivity {
    public static final String BUS_LINE_ID = "com.example.user01.myapplication.BUS_LINE_ID";
    public static final String BUS_LINE_SHORTNAME = "com.example.user01.myapplication.BUS_LINE_SHORTNAME";
    public static final String BUS_LINE_LONGNAME = "com.example.user01.myapplication.BUS_LINE_LONGNAME";

    private Integer busLineId;
    private String shortName;
    private String longName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        loadIntentParameters();
        setCaptions();
        loadRemoteData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadIntentParameters() {
        Intent intent = getIntent();
        busLineId = intent.getIntExtra(BUS_LINE_ID, 0);
        shortName = intent.getStringExtra(BUS_LINE_SHORTNAME);
        longName = intent.getStringExtra(BUS_LINE_LONGNAME);
    }

    private void loadRemoteData() {
        BusLineServiceFacade service = new BusLineServiceFacade();

        List<BusStop> busStops = service.getBusStops(busLineId);
        loadBusStopsListView(busStops);

        List<LineDeparture> departures = service.getLineDepartures(busLineId);
        loadLineDeparturesListView(departures);
    }

    private void setCaptions() {
        TextView shortNameField = (TextView) findViewById(R.id.shortName);
        shortNameField.setText(longName);

        TextView longNameField = (TextView) findViewById(R.id.longName);
        longNameField.setText("Bus line " + shortName);
    }

    private void loadBusStopsListView(List<BusStop> busStops) {
        final CustomBusStopAdapter adapter = new CustomBusStopAdapter(this, busStops);
        ListView listView = (ListView) findViewById(R.id.listViewBusStop);
        listView.setAdapter(adapter);
    }

    private void loadLineDeparturesListView(List<LineDeparture> departures) {
        final CustomLineDeparturesAdapter adapter = new CustomLineDeparturesAdapter(this, departures);
        ListView listView = (ListView) findViewById(R.id.listViewLineDepartures);
        listView.setAdapter(adapter);
    }
}
