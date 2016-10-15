package com.example.adam.tht;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ScrollView;

/**
 * Created by scottshumway on 10/15/16.
 */

public class Pictures extends AppCompatActivity {

    ScrollView pics;
    ImageView picture;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        pics = (ScrollView) findViewById(R.id.pictures);

        //some form of loop here, add pictures from database into scrollView
        //see layoutInflator for dynamicaly adding views into parent view

        picture = new ImageView(this);
        pics.addView(picture);



    }
}
