package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Adam on 10/15/2016.
 */
public class members extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> oString;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        b = (Button)findViewById(R.id.bb);
        oString = new ArrayList<String>();
        //Need to use database to grab the group members on users team and their stats and populate list
        for (int i = 0; i < 10/*Group Member size*/; i++) {
            oString.add("NAME + STATS");
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view)
    {
        Intent j = new Intent(this, groups.class);
        startActivity(j);
    }

}