package com.practice.esaankal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.PrivateKey;

public class ConnectionScreen extends AppCompatActivity {

    ImageButton button;
    Socket s;
    DataOutputStream dos;
    PrintWriter pw;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_screen);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        button = findViewById(R.id.image_button);


        myThread = new MyThread();
        new Thread(myThread).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "data";
                myThread.sendMsgParam(msg);
                Toast.makeText(ConnectionScreen.this, "Connection has been Established!! Lock is open", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private class MyThread implements Runnable {
        private volatile String msg;

        @Override
        public void run() {
            try {
                s = new Socket("157.245.106.238", 65433);
                dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(msg);
                dos.close();
                dos.flush();
                s.close();
            } catch (Exception e) {
                System.out.print(e);
            }

        }

        public void sendMsgParam(String msg) {
            this.msg = msg;
            run();
        }

    }

}