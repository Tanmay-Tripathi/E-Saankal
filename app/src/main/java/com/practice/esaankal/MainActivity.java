package com.practice.esaankal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    MaterialButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edit_text_username);
        password = findViewById(R.id.edit_text_password);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //correctPassword and move to the next page

                    Toast.makeText(MainActivity.this, "Login Successful,Welcome :) ", Toast.LENGTH_SHORT).show();
                    Intent connectionsActivityIntent = new Intent(MainActivity.this, ConnectionScreen.class);
                    startActivity(connectionsActivityIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed,Try again :( ", Toast.LENGTH_LONG).show();
                    //incorrectPassword
                }

            }
        });

    }
}