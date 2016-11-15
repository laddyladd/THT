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
 * Created by adam on 10/15/16.
 */

public class LeaderBoard extends AppCompatActivity {

    TableRow rowHeader, row1, row2, row3, row4, row5, row6, row7, row8, row9, row10;
    TextView team, miles, hikes;
    TableLayout table;

    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_board);

        table = (TableLayout)findViewById(R.id.table);
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");
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

        switch (item.getItemId()) {
            case R.id.Top_10:
                Intent j = new Intent(this, LeaderBoard.class);
                j.putExtra("User Value", i);
                startActivity(j);
                return true;
            case R.id.Group:
                Intent k = new Intent(this, groups.class);
                k.putExtra("User Value", i);
                startActivity(k);
                return true;
            case R.id.Trails:
                Intent l = new Intent(this, Trails.class);
                l.putExtra("User Value", i);
                startActivity(l);
                return true;
            case R.id.info:
                Intent m = new Intent(this, myinfo.class);
                m.putExtra("User Value", i);
                startActivity(m);
                return true;
            case R.id.Home:
                Intent n = new Intent(this, Home.class);
                n.putExtra("User Value", i);
                startActivity(n);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

