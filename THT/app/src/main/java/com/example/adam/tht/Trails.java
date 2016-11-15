package com.example.adam.tht;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adam.tht.activities.ImgurMain;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Adam on 10/15/2016.
 */
public class Trails extends AppCompatActivity implements ListView.OnItemClickListener {
    ArrayList<String> oString;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    HikeData hike;
    int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trails);
        listView = (ListView)findViewById(R.id.left_drawer);
        oString = new ArrayList<String>();
        hike = new HikeData();
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");
        for (int j = 0; j < 10; j++) {
            oString.add(hike.getName(j) + "\t\t" + hike.getDistance(j));
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

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
                startActivityForResult(cameraIntent, 1888);
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
    public void onItemClick(AdapterView<?> av, View v, int k, long l) {
        //we can hardcode this for simplicity.
        //Each hike will have a value based off how we put it in the list
        //and we can just grab from there.
        Intent j = new Intent(this, trailinfo.class);
        j.putExtra("Hike Value", k);
        j.putExtra("User value", i);
        startActivityForResult(j, 1);

    }
}