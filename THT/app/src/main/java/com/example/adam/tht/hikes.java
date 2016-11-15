package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        String userURL = "http://ec2-35-160-141-23.us-west-2.compute.amazonaws.com/api/Teams/Hikes?id=" + i;
        String teamID = getInfo(userURL);
        List<String> elephantList = Arrays.asList(teamID.split(","));




        for (int i = 0; i < elephantList.size(); i++) {
            oString.add(elephantList.get(i));
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

    public String getInfo(String s) {
        try {
            URL url = new URL(s);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("PUT");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            if(s.indexOf("Users") != -1){
                JSONObject user = new JSONObject(stringBuilder.toString());
                return user.getString("TeamId");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            Toast.makeText(this, "Bad internet connection",
                    Toast.LENGTH_LONG).show();
        }
        return null;
    }

}