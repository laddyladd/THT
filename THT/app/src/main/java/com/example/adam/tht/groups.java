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
public class groups extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;
    Button b4;

    TextView t1;

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        b1 = (Button) findViewById(R.id.bm);
        b2 = (Button) findViewById(R.id.bh);
        b3 = (Button) findViewById(R.id.bs);
        b4 = (Button) findViewById(R.id.bp);

        t1 = (TextView)findViewById(R.id.tvGN); //group name

        //Use database to fill information. only need Group name
        //in this file but the buttons will all lead to more
        //database intensive stuff

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
            case R.id.camera:
                startActivity(new Intent(this, openCamera.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onClick(View view)
    {
        if (view.getId() == b1.getId())
        {
            Intent j = new Intent(this, members.class);
            startActivity(j);
        }
        else if (view.getId() == b2.getId())
        {
            Intent j = new Intent(this, hikes.class);
            startActivity(j);
        }
        else if (view.getId() == b3.getId())
        {
            Intent j = new Intent(this, stats.class);
            startActivity(j);
        }
        if (view.getId() == b4.getId())
        {
            Intent j = new Intent(this, Pictures.class);
            startActivity(j);
        }
    }
}