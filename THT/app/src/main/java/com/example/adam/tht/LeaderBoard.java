package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by scottshumway on 10/15/16.
 */

public class LeaderBoard extends AppCompatActivity {

    TableRow rowHeader, row1, row2, row3, row4, row5, row6, row7, row8, row9, row10;
    TextView team, miles, hikes;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board);

        table = (TableLayout)findViewById(R.id.table);

        team = new TextView(this);
        team.setText("Team Name");

        miles = new TextView(this);
        miles.setText("Miles");

        hikes = new TextView(this);
        hikes.setText("Hikes");

        rowHeader = new TableRow(this);
        rowHeader.addView(team);
        rowHeader.addView(miles);
        rowHeader.addView(hikes);

        table.addView(rowHeader);


    }
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());

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
            case R.id.Home:
                startActivity(new Intent(this, Home.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

