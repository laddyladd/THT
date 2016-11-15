package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Adam on 10/15/2016.
 */
public class hikes extends AppCompatActivity implements View.OnClickListener {
    ArrayList<String> oString;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    Button b;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hikes);
        b = (Button)findViewById(R.id.bb);
        b.setOnClickListener(this);
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");

        oString = new ArrayList<String>();
        listView = (ListView)findViewById(R.id.listView);

        //Need to use database to grab the group members on users team and their stats and populate list
        //Check all hikes and members so 2 for loops needed probably
        for (int i = 0; i < 10/*Group Member size*/; i++) {
            oString.add("Hike Name + Group Members who have completed it");
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View view)
    {
        Intent j = new Intent(this, groups.class);
        j.putExtra("User Value", i);
        startActivity(j);
    }

}