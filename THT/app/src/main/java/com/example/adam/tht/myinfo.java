package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Adam on 10/15/2016.
 */
public class myinfo extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        t1 = (TextView)findViewById(R.id.tvH); //hikes
        t2 = (TextView)findViewById(R.id.tvM); //Miles
        t3 = (TextView)findViewById(R.id.tvG); //Group
        t4 = (TextView)findViewById(R.id.tvN); //DOB
        iv = (ImageView)findViewById(R.id.imageView); //picture

        //Use database to fill information

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

}