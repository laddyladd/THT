package com.example.adam.tht;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        //Database stuff for logging users in
        Intent j = new Intent(this, Home.class);
        startActivity(j);
    }
}
