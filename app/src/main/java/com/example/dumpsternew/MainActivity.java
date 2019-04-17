package com.example.dumpsternew;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static int splashTime=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        new Handler ().postDelayed ( new Runnable () {
            @Override
            public void run() {
                Intent homeIntent = new Intent ( MainActivity.this, Splash.class );
                startActivity ( homeIntent );
            }
        }, splashTime );
    }
}
