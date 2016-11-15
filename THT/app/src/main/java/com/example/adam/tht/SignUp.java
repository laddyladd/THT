package com.example.adam.tht;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Signup for app class.
 */
public class SignUp extends AppCompatActivity implements View.OnClickListener ,ListView.OnItemClickListener {

    Button signup;
    TextView login;
    EditText email;
    EditText password;
    EditText password2;
    Button button;
    Button button2;
    ListView listView;
    boolean clicked = false;
    Integer team = -1;
    ArrayList<String> oString;
    ArrayAdapter<String> arrayAdapter;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = (Button)findViewById(R.id.btn_signup);
        signup.setOnClickListener(this);
        login = (TextView) findViewById(R.id.link_login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button2.setVisibility(View.INVISIBLE);
        editText = (EditText)findViewById(R.id.editText2);
        editText.setVisibility(View.INVISIBLE);
        listView = (ListView)findViewById(R.id.listView2);
        oString = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
           //Get list of teams from DB for loop is not needed probably
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        Toast.makeText(this, "Please join a team from the list below or create a new one. ",
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.button)
        {
            editText.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            return;
        }
        else if(view.getId() == R.id.button2)
        {
            //push new team to db
            oString.add(editText.getText().toString());
            arrayAdapter.notifyDataSetChanged();
            editText.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            return;
        }
        else if (!clicked)
        {
            Toast.makeText(this, "Make sure to join a team first. If you created one,  click on the team you created please.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            if (view.getId() == signup.getId()) {

                if(password.getText().toString().equals(password2.getText().toString()))
                {

                    StringBuffer sb = new StringBuffer();
                    try {
                        URL url = new URL("http://ec2-35-160-141-23.us-west-2.compute.amazonaws.com/api/Users/SignUp?=" + email.getText().toString() +
                                "&password=" + password.getText().toString() + "&groupId=" + team);
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        urlConnection.setDoOutput(true);
                        urlConnection.setRequestMethod("PUT");
                        InputStream is = new BufferedInputStream(urlConnection.getInputStream());
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String inputLine = "";
                        while ((inputLine = br.readLine()) != null) {
                            sb.append(inputLine);
                        }
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(this, "Bad interent connection",
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    int i = 0;
                    if (i < 0)
                    {
                        Toast.makeText(this, "Email already in use",
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    else
                    {
                        Intent j = new Intent(this, Home.class);
                        j.putExtra("User Value", i);
                        startActivity(j);
                    }
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Passwords don't match";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }

        }
    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l) {
        clicked = true;
        team = i;
        Toast.makeText(this, "You have joined team: " +oString.get(i).toString(),
                Toast.LENGTH_LONG).show();
    }


}
