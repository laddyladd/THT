package com.example.adam.tht;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import java.util.List;

/**
 * Created by Adam on 10/15/2016.
 */
public class checkIn
{
    LocationManager mLocationManager;
    Location myLocation;
    public Location check(Context c) {
        return getLastKnownLocation(c);
    }
    public Location getLastKnownLocation(Context c)
    {
        mLocationManager = (LocationManager)c.getSystemService(c.LOCATION_SERVICE);
        List<String> providers = mLocationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers)
        {
            if (ActivityCompat.checkSelfPermission(c, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(c, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return null;
            }
            Location l = mLocationManager.getLastKnownLocation(provider);
            if (l == null)
            {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy())
            {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }


}
