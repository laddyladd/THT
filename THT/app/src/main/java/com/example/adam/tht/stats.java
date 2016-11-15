package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Adam on 10/15/2016.
 */
public class stats extends AppCompatActivity implements View.OnClickListener {

    TextView teamname;
    TextView points;
    TextView distance;
    TextView hikescompleted;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);


        teamname = (TextView) findViewById(R.id.teamname); //group name
        points = (TextView) findViewById(R.id.points);
        distance = (TextView) findViewById(R.id.distance);
        hikescompleted = (TextView) findViewById(R.id.hikescompleted);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        Bundle intent = getIntent().getExtras();
        int userID = intent.getInt("User Value");

        //need to determine final algorithms for teams values and shit...
        //distance, points, hikes completed.

        String pointsS = "";
        String distanceS = "";
        String hikescompletedS = "";

        //HttpClient client = new HttpClient();
        //read userInfo and get teamID
        //set teamID here
        String userURL = "http://ec2-35-160-141-23.us-west-2.compute.amazonaws.com/api/Users/" + userID;
        String teamID = getInfo(userURL);


        String baseURL = "http://ec2-35-160-141-23.us-west-2.compute.amazonaws.com/api/Teams/";
        String pointsURL = baseURL + "Score?id=" + teamID;
        String distanceURL = baseURL + "Distance?id=" + teamID;
        String hikesURL = baseURL + "Hikes?id=" + teamID;

        String[] urls = {pointsURL, distanceURL, hikesURL};


        for (int i = 0; i < urls.length; i++) {
            String info = getInfo(urls[i]);

            if (urls[i].equals(pointsURL)) {
                pointsS = info;
            } else if (urls[i].equals(distanceURL)) {
                distanceS = info;
            } else if (urls[i].equals(hikesURL)) {
                hikescompletedS = info;
            }
        }

        //do someting with results ehre

        points.setText(points.getText()+pointsS);
        distance.setText(distance.getText()+distanceS);
        hikescompleted.setText(hikescompleted.getText()+hikescompletedS);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == back.getId()) {
            Intent j = new Intent(this, groups.class);
            startActivity(j);
        }

    }

    public String getInfo(String s) {
        try {
            URL url = new URL(s);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("PUT");
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
