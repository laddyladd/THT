package com.example.adam.tht;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

/**
 * Created by adam on 11/4/16.
 */

public class TakePhoto extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    //Uri fileUri;


    public void startCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File output = new File(dir, "CameraContentDemo.jpeg");
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File output = new File(dir, "CameraContentDemo.jpeg");
            this.finish();
        }
    }

}
