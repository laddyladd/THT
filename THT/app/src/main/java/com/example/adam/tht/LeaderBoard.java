package com.example.adam.tht;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
}
