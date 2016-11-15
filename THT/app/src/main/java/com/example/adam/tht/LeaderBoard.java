package com.example.adam.tht;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adam.tht.activities.ImgurMain;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adam on 10/15/16.
 */

public class LeaderBoard extends AppCompatActivity {

    TableRow rowHeader, row1, row2, row3, row4, row5, row6, row7, row8, row9, row10;
    TextView team, miles, hikes;
    TableLayout table;
    private static final int CAMERA_REQUEST = 1888;
    ListView listView;
    ArrayList<String> oString;
    ArrayAdapter<String> arrayAdapter;

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

        oString = new ArrayList<String>();
        listView = (ListView)findViewById(R.id.lv);

        String userURL = "http://ec2-35-160-141-23.us-west-2.compute.amazonaws.com/api/Teams/TopTeams";
        String teamID = getInfo(userURL);
        List<String> elephantList = Arrays.asList(teamID.split(","));




        for (int i = 0; i < elephantList.size(); i++) {
            oString.add(elephantList.get(i));
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);


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
            case R.id.camera:
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                File output = new File(dir, "CameraContentDemo.jpeg");
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
                cameraIntent.putExtra("User Value", i);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
                return true;
            case R.id.upload:
                Intent imgur = new Intent(this, ImgurMain.class);
                imgur.putExtra("User Value", i);
                startActivity(imgur);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String getInfo(String s) {
        try {
            URL url = new URL(s);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
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

