package com.example.adam.tht.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adam.tht.HikeData;
import com.example.adam.tht.Home;
import com.example.adam.tht.LeaderBoard;
import com.example.adam.tht.R;
import com.example.adam.tht.Trails;
import com.example.adam.tht.groups;
import com.example.adam.tht.helpers.DocumentHelper;
import com.example.adam.tht.helpers.IntentHelper;
import com.example.adam.tht.imgurmodel.ImageResponse;
import com.example.adam.tht.imgurmodel.Upload;
import com.example.adam.tht.myinfo;
import com.example.adam.tht.services.UploadService;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

//import android.support.design.widget.Snackbar;

public class ImgurMain extends AppCompatActivity implements ListView.OnItemClickListener{
//    public final static String TAG = ImgurMain.class.getSimpleName();
    /*
      These annotations are for ButterKnife by Jake Wharton
      https://github.com/JakeWharton/butterknife
     */
    @Bind(R.id.image)
    ImageView uploadImage;
    @Bind(R.id.editText_upload_title)
    EditText uploadTitle;
//    @Bind(R.id.editText_upload_desc)
//    EditText uploadDesc;

    ListView listView;
    ArrayList<String> oString;
    HikeData hike;
    int i;
    int user = -1;

    ArrayAdapter<String> arrayAdapter;

    private Upload upload; // Upload object containging image and meta data
    private File chosenFile; //chosen file from intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgur);
        ButterKnife.bind(this);

        listView = (ListView)findViewById(R.id.trails);
        oString = new ArrayList<String>();
        hike = new HikeData();
        Bundle intent = getIntent().getExtras();
        i = intent.getInt("User Value");
        for (int j = 0; j < 10; j++) {
            oString.add(hike.getOtherName(j));
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri returnUri;

        if (requestCode != IntentHelper.FILE_PICK) {
            return;
        }

        if (resultCode != RESULT_OK) {
            return;
        }

        returnUri = data.getData();
        String filePath = DocumentHelper.getPath(this, returnUri);
        //Safety check to prevent null pointer exception
        if (filePath == null || filePath.isEmpty()) return;
        chosenFile = new File(filePath);

                /*
                    Picasso is a wonderful image loading tool from square inc.
                    https://github.com/square/picasso
                 */
        Picasso.with(getBaseContext())
                .load(chosenFile)
                .placeholder(R.drawable.ic_photo_library_black)
                .fit()
                .into(uploadImage);
    }


    @OnClick(R.id.image)
    public void onChooseImage() {
//        uploadDesc.clearFocus();
        uploadTitle.clearFocus();
        IntentHelper.chooseFileIntent(this);
    }

    private void clearInput() {
        uploadTitle.setText("");
//        uploadDesc.clearFocus();
//        uploadDesc.setText("");
        uploadTitle.clearFocus();
        uploadImage.setImageResource(R.drawable.ic_photo_library_black);
    }

    @OnClick(R.id.upload_image)
    public void uploadImage() {
    /*
      Create the @Upload object
     */
         if(user != -1) {
             if (chosenFile == null) return;
             createUpload(chosenFile);

        /*
          Start upload
         */
             new UploadService(this).Execute(upload, new UiCallback());
         }
        else {
             Toast.makeText(this, "Select a hike",
                     Toast.LENGTH_LONG).show();
         }

    }

    private void createUpload(File image) {
        upload = new Upload();

        upload.image = image;
        upload.title = uploadTitle.getText().toString();
//        upload.description = uploadDesc.getText().toString();
    }

    private class UiCallback implements Callback<ImageResponse> {

        @Override
        public void success(ImageResponse imageResponse, Response response) {
            clearInput();
            //add the url from imageResponse to the db here.
        }

        @Override
        public void failure(RetrofitError error) {
            //Assume we have no connection, since error is null
            if (error == null) {
                //Snackbar.make(findViewById(R.id.rootView), "No internet connection", Snackbar.LENGTH_SHORT).show();
            }
        }
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
    public void onItemClick(AdapterView<?> av, View v, int k, long l) {
        //we can hardcode this for simplicity.
        //Each hike will have a value based off how we put it in the list
        //and we can just grab from there.

        user = k;
    }
}
