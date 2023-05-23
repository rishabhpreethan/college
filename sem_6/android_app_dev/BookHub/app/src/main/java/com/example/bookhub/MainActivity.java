package com.example.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{   TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView)findViewById(R.id.t1);


        t1.setOnClickListener(new View.OnClickListener()
        {   @Override
        public void onClick(View v) {
            String url="https://www.bookhub.com";
            Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            startActivity(i);
        }
        });
    }
}
