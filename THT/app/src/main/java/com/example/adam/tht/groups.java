package com.example.adam.tht;

import android.content.Intent;
import android.net.Uri;
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
    int i;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        b1 = (Button) findViewById(R.id.bm);
        b2 = (Button) findViewById(R.id.bh);
        b3 = (Button) findViewById(R.id.bs);
        b4 = (Button) findViewById(R.id.bp);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");
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
        if (view.getId() == b1.getId())
        {
            Intent j = new Intent(this, members.class);
            j.putExtra("User Value", i);
            startActivity(j);
        }
        else if (view.getId() == b2.getId())
        {
            Intent j = new Intent(this, hikes.class);
            j.putExtra("User Value", i);

            startActivity(j);
        }
        else if (view.getId() == b3.getId())
        {
            Intent j = new Intent(this, stats.class);
            j.putExtra("User Value", i);

            startActivity(j);
        }
        if (view.getId() == b4.getId())
        {
            // should be imgur our account
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.imgur.com"));
            startActivity(browserIntent);
        }
    }
}