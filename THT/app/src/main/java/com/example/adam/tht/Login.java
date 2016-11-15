package com.example.adam.tht;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener
{
    Button loginButton;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    TextView signup;
    EditText email;
    EditText password;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        signup = (TextView) findViewById(R.id.link_signup);
        signup.setOnClickListener(this);
    }




    @Override
    public void onClick(View view)
    {
        if (view.getId() == signup.getId()) {
            Intent j = new Intent(this, SignUp.class);
            startActivity(j);
        } else if (view.getId() == loginButton.getId()){
            login();
        }
    }

    public void login() {
        String result = "";
        String em = email.getText().toString();
        String pw = password.getText().toString();
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL("http://" + "localhost:62171"
                    + "/api/Users/Login?email=" + em + "&password=" + pw);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream is = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Bad interent connection",
            Toast.LENGTH_LONG).show();
            return;
        }
        int i = Integer.parseInt(result);//returnval from database
        if (i < 0)
        {
            Toast.makeText(this, "Incorrect username or password",
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

}
