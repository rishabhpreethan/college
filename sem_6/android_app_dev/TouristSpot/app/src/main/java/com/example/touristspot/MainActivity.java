package com.example.touristspot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity
{ ImageView ig1,ig2,ig3;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ig1=(ImageView)findViewById(R.id.ig1);
        ig2=(ImageView)findViewById(R.id.ig2);
        ig3=(ImageView)findViewById(R.id.ig3);

        ig1.setOnClickListener(new View.OnClickListener()
        {   @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Agra UP", Toast.LENGTH_SHORT).show();
            String url="https://en.wikipedia.org/agra";
            Intent i1=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i1);
        }
        });


        ig2.setOnClickListener(new View.OnClickListener()
        {   @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"Gateway of India", Toast.LENGTH_SHORT).show();
            String url="https://en.wikipedia.org/wiki/gateway of india";
            Intent i2=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i2);
        }
        });


        ig3.setOnClickListener(new View.OnClickListener()
        {   @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "charminar", Toast.LENGTH_SHORT).show();
            String url=" https://en.wikipedia.org/wiki/charminar";
            Intent i3=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i3);
        }
        });

    }
}
