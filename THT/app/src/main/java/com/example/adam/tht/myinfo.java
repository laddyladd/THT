package com.example.adam.tht;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adam.tht.activities.ImgurMain;

import java.io.File;

/**
 * Created by Adam on 10/15/2016.
 */
public class myinfo extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    ImageView iv;
    int CAMERA_REQUEST = 1888;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinfo);
        t1 = (TextView)findViewById(R.id.tvH); //hikes
        t2 = (TextView)findViewById(R.id.tvM); //Miles
        t3 = (TextView)findViewById(R.id.tvG); //Group
        t4 = (TextView)findViewById(R.id.tvN); //DOB
        iv = (ImageView)findViewById(R.id.imageView); //picture
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");
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

}