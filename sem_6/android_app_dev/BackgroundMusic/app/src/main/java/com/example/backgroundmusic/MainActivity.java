package com.example.backgroundmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
//import com.example.musicplayer.MediaService;
//import com.example.musicplayer.R;

public class MainActivity extends AppCompatActivity {

    private Button bStart;
    private Button bStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStart = (Button) findViewById(R.id.btnStart);
        bStop = (Button) findViewById(R.id.btnStop);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MediaService.class));
            }
        });

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MediaService.class));
            }
        });
    }
}
