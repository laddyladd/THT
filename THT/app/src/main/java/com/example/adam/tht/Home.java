package com.example.adam.tht;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.adam.tht.activities.ImgurMain;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
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
    private static final int CAMERA_REQUEST = 1888;

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
            checkinVal = 7;
            s = "Flat Top";
        }
        else if ((L.getLatitude() >= 37.57119 -.02 && L.getLatitude() <= 37.57119 + .02) && (L.getLongitude() >= -79.491723 -.02 && L.getLongitude() < -79.491723 + .02))
        {
            checkinVal = 8;
            s = "Devils's Marbleyard";
        }
        else if ((L.getLatitude() >= 37.37928 -.02 && L.getLatitude() <= 37.37928 + .02) && (L.getLongitude() >= -80.44643 -.02 && L.getLongitude() < -80.44643 + .02))
        {
            checkinVal =9;
            s = "Kelly's Knob";
        }
        else if ((L.getLatitude() >= 37.091781 -.02 && L.getLatitude() <= 37.091781 + .02) && (L.getLongitude() >= -79.593104 -.02 && L.getLongitude() < -79.593104 + .02))
        {
            checkinVal = 10;
            s = "Smith Mountain Lake";
        }
        if ( s != "")
        {

            StringBuffer sb = new StringBuffer();

            try {
                URL url = new URL("http://ec2-35-160-141-23.us-west-2.compute.amazonaws.com/api/Users/CheckIn?userId=" + i + "&hikeId=" + checkinVal);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("PUT");
                InputStream is = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inputLine = "";
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                Toast.makeText(this, "You have successfully checked into : " + s,
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e)
            {
                Toast.makeText(this, "Bad interent connection",
                        Toast.LENGTH_LONG).show();
                return;
            }
        }
        else
        {
            Toast.makeText(this, "You have failed to check into any valid hike.",
                    Toast.LENGTH_LONG).show();
            return;
        }

    }



}
