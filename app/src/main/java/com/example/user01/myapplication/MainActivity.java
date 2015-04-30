package com.example.user01.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user01.myapplication.model.service.BusLineServiceAdapter;
import com.example.user01.myapplication.model.pojo.BusLine;
import com.example.user01.myapplication.model.adapter.CustomBusLineAdapter;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public boolean onSearchButtonClick(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String streetName = editText.getText().toString();

        BusLineServiceAdapter service = new BusLineServiceAdapter();

        List<BusLine> busLines = service.getBusLine(streetName);
        loadBusLineListView(busLines);

        if (busLines.size() > 0)
            Toast.makeText(MainActivity.this, busLines.size() + " bus lines found", Toast.LENGTH_SHORT).show();

        return true;
    }

    private void loadBusLineListView(List<BusLine> lines) {
        final CustomBusLineAdapter adapter = new CustomBusLineAdapter(this, lines);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                BusLine busLine = (BusLine) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Searching " +	busLine.getLongName(), Toast.LENGTH_SHORT).show();
                showDetailActivity(busLine);
            }
        });
    }

    private void showDetailActivity(BusLine busLine) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.BUS_LINE_ID, busLine.getId());
        intent.putExtra(DetailActivity.BUS_LINE_SHORTNAME, busLine.getShortName());
        intent.putExtra(DetailActivity.BUS_LINE_LONGNAME, busLine.getLongName());
        startActivity(intent);
    }
}
