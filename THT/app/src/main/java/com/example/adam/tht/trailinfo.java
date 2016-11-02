package com.example.adam.tht;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Adam on 10/15/2016.
 */
public class trailinfo extends AppCompatActivity implements View.OnClickListener {
    Button b;
    Button d;
    int i;
    int k;
    TextView t1;
    TextView t2;
    TextView t3;
    ImageView iv;
    HikeData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trailinfo);
        b = (Button) findViewById(R.id.back);
        b.setOnClickListener(this);

        d = (Button) findViewById(R.id.directions);
        b.setOnClickListener(this);

        Bundle intent = getIntent().getExtras();
        i = intent.getInt("Hike Value");
        k = intent.getInt("User Value");
        data = new HikeData();
        t1 = (TextView)findViewById(R.id.textView15);
        t2 = (TextView)findViewById(R.id.textView16);
        t3 = (TextView)findViewById(R.id.textView7);

        iv = (ImageView)findViewById(R.id.imageView);
        iv.setImageResource(data.getImage(i));
        t1.setText(t1.getText() + "\n" + data.getDistance(i));
        t2.setText(t2.getText() + "\n" + data.getDifficulty(i));
        t3.setText(data.getName(i));



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == b.getId()) {
            Intent j = new Intent(this, Trails.class);
            j.putExtra("User value", k);
            startActivity(j);
        } else if (view.getId() == d.getId()) {
            //BRING US TO DIRECTIONS ON GOOGLE
            String search = data.getName(i);
            search.replaceAll("\\s+","+");

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:37.2296, -80.4139?q="+search));
            startActivity(intent);
        }
    }
}