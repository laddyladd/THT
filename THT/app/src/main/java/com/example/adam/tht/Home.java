package com.example.adam.tht;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Adam on 10/15/2016.
 */
public class Home extends AppCompatActivity implements View.OnClickListener
{
    int i = 0;

    Button checkin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkin = (Button)findViewById(R.id.but2);
        checkin.setOnClickListener(this);
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");
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
    @Override
    public void onClick(View view)
    {
        checkIn checkin;
        Location L;
        checkin = new checkIn();
        L = checkin.check(this);
        String s = "";
        int checkinVal = -1;
        if ((L.getLatitude() >= 22.80642 -.02 && L.getLatitude() <= 22.80642 + .02) && (L.getLongitude() >= -5.3778 -.02 && L.getLongitude() < -5.3778 + .02))
        {
            checkinVal = 1;
            s = "McAfees Knob";
        }
        else if ((L.getLatitude() >= 22.72818 -.02 && L.getLatitude() <= 22.72818 + .02) && (L.getLongitude() >= 9.36697 -.02 && L.getLongitude() < 9.36697 + .02))
        {
            checkinVal = 2;
            s = "Dragon's Tooth";
        }
        else if ((L.getLatitude() >= 21.23028 -.02 && L.getLatitude() <= 21.23028 + .02) && (L.getLongitude() >= 35.93917 -.02 && L.getLongitude() < 35.93917 + .02))
        {
            checkinVal = 3;
            s = "Cascades";
        }
        else if ((L.getLatitude() >= 37.457589 -.02 && L.getLatitude() <= 37.457589 + .02) && (L.getLongitude() >=  -80.017241 -.02 && L.getLongitude() <  -80.017241 + .02))
        {
            checkinVal = 4;
            s ="Tinker Cliff";
        }
        else if ((L.getLatitude() >= 19.75302 -.02 && L.getLatitude() <= 19.75302 + .02) && (L.getLongitude() >= 45.04795 -.02 && L.getLongitude() < 45.04795 + .02))
        {
            checkinVal = 5;
            s ="Angel's Rest";
        }
        else if ((L.getLatitude() >= 37.3926 -.02 && L.getLatitude() <= 37.3926 + .02) && (L.getLongitude() >= -80.5078 -.02 && L.getLongitude() < -80.5078 + .02))
        {
            checkinVal = 6;
            s = "War Spur";
        }
        else if ((L.getLatitude() >= 26.6064 -.02 && L.getLatitude() <= 26.6064 + .02) && (L.getLongitude() >= 36.5517 -.02 && L.getLongitude() < 36.5517 + .02))
        {
            s = "Flat Top";
        }
        else if ((L.getLatitude() >= 37.57119 -.02 && L.getLatitude() <= 37.57119 + .02) && (L.getLongitude() >= -79.491723 -.02 && L.getLongitude() < -79.491723 + .02))
        {
            checkinVal = 7;
            s = "Devils's Marbleyard";
        }
        else if ((L.getLatitude() >= 37.37928 -.02 && L.getLatitude() <= 37.37928 + .02) && (L.getLongitude() >= -80.44643 -.02 && L.getLongitude() < -80.44643 + .02))
        {
            checkinVal = 8;
            s = "Kelly's Knob";
        }
        else if ((L.getLatitude() >= 37.091781 -.02 && L.getLatitude() <= 37.091781 + .02) && (L.getLongitude() >= -79.593104 -.02 && L.getLongitude() < -79.593104 + .02))
        {
            checkinVal = 9;
            s = "Smith Mountain Lake";
        }
        if ( s != "")
        {
            Toast.makeText(this, "You have successfully checked into : " + s,
                    Toast.LENGTH_LONG).show();
            StringBuffer sb = new StringBuffer();

            try {
                URL url = new URL("http://" + "localhost:62171"
                        + "/api/Users/CheckIn?=" + i + "&hikeId=" + checkinVal);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                InputStream is = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inputLine = "";
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
            }
            catch (Exception e)
            {
                Toast.makeText(this, "Bad interent connection",
                        Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "You have failed to check into any valid hike.",
                    Toast.LENGTH_LONG).show();
        }

    }
}
