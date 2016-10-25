package com.example.adam.tht;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Adam on 10/15/2016.
 */
public class Home extends AppCompatActivity implements View.OnClickListener
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

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
    @Override
    public void onClick(View view)
    {
        checkIn checkin;
        Location L;
        checkin = new checkIn();
        L = checkin.check(this);
        String s = "";
        if ((L.getLatitude() >= 22.80642 -.02 && L.getLatitude() <= 22.80642 + .02) && (L.getLongitude() >= -5.3778 -.02 && L.getLongitude() < -5.3778 + .02))
        {
            s = "McAfees Knob";
        }
        else if ((L.getLatitude() >= 22.72818 -.02 && L.getLatitude() <= 22.72818 + .02) && (L.getLongitude() >= 9.36697 -.02 && L.getLongitude() < 9.36697 + .02))
        {
            s = "Dragon's Tooth";
        }
        else if ((L.getLatitude() >= 21.23028 -.02 && L.getLatitude() <= 21.23028 + .02) && (L.getLongitude() >= 35.93917 -.02 && L.getLongitude() < 35.93917 + .02))
        {
            s = "Cascades";
        }
        else if ((L.getLatitude() >= 37.457589 -.02 && L.getLatitude() <= 37.457589 + .02) && (L.getLongitude() >=  -80.017241 -.02 && L.getLongitude() <  -80.017241 + .02))
        {
            s ="Tinker Cliff";
        }
        else if ((L.getLatitude() >= 19.75302 -.02 && L.getLatitude() <= 19.75302 + .02) && (L.getLongitude() >= 45.04795 -.02 && L.getLongitude() < 45.04795 + .02))
        {
            s ="Angel's Rest";
        }
        else if ((L.getLatitude() >= 37.3926 -.02 && L.getLatitude() <= 37.3926 + .02) && (L.getLongitude() >= -80.5078 -.02 && L.getLongitude() < -80.5078 + .02))
        {
            s = "War Spur";
        }
        else if ((L.getLatitude() >= 26.6064 -.02 && L.getLatitude() <= 26.6064 + .02) && (L.getLongitude() >= 36.5517 -.02 && L.getLongitude() < 36.5517 + .02))
        {
            s = "Flat Top";
        }
        else if ((L.getLatitude() >= 37.57119 -.02 && L.getLatitude() <= 37.57119 + .02) && (L.getLongitude() >= -79.491723 -.02 && L.getLongitude() < -79.491723 + .02))
        {
            s = "Devils's Marbleyard";
        }
        else if ((L.getLatitude() >= 37.37928 -.02 && L.getLatitude() <= 37.37928 + .02) && (L.getLongitude() >= -80.44643 -.02 && L.getLongitude() < -80.44643 + .02))
        {
            s = "Kelly's Knob";
        }
        else if ((L.getLatitude() >= 37.091781 -.02 && L.getLatitude() <= 37.091781 + .02) && (L.getLongitude() >= -79.593104 -.02 && L.getLongitude() < -79.593104 + .02))
        {
            s = "Smith Mountain Lake";
        }
        if ( s != "")
        {
            Toast.makeText(this, "You have successfully checked into : " + s,
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "You have failed to check into: " + s,
                    Toast.LENGTH_LONG).show();
        }    }
}
