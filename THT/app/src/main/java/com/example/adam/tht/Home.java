package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.security.acl.Group;

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
            case R.id.camera:
                startActivity(new Intent(this, openCamera.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onClick(View view) {

            startActivity(new Intent(this, openCamera.class));

        }
}
