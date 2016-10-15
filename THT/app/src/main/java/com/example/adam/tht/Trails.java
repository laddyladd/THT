package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Adam on 10/15/2016.
 */
public class Trails extends AppCompatActivity implements ListView.OnItemClickListener {
    ArrayList<String> oString;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    HikeData hike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trails);
        oString = new ArrayList<String>();
        hike = new HikeData();
        for (int i = 0; i < 10; i++) {
            oString.add(hike.getName(i) + "\t\t" + hike.getDistance(i));
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Top_10:
                startActivity(new Intent(this, LeaderBoard.class));
                return true;
            case R.id.Group:
                startActivity(new Intent(this, groups.class));
                return true;
            case R.id.Trails:
                startActivity(new Intent(this, Trails.class));
                return true;
            case R.id.info:
                startActivity(new Intent(this, myinfo.class));
                return true;
            case R.id.camera:
                startActivity(new Intent(this, openCamera.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l) {
        //we can hardcode this for simplicity.
        //Each hike will have a value based off how we put it in the list
        //and we can just grab from there.
        Intent j = new Intent(this, trailinfo.class);
        j.putExtra("Hike Value", i);
        startActivityForResult(j, 1);

    }
}