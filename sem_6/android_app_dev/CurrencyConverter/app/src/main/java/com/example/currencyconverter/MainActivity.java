package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{   EditText t1,res;
    Spinner s1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText)findViewById(R.id.t1);
        res=(EditText)findViewById(R.id.res);
        s1=(Spinner)findViewById(R.id.s1);
        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {   @Override
        public void onClick(View v)
        {  String v1=t1.getText().toString();
            int a=Integer.parseInt(v1);
            int x=s1.getSelectedItemPosition();
            double num1=0;
            if(x==1)
            {  num1=a/71.99;
                res.setText("Result ="+num1);
            }

            else if(x==2)
            {  num1=a*71.99;
                res.setText("Result ="+num1);
            }

            else if(x==3)
            { num1=a/0.68;
                res.setText("Result ="+num1);
            }

            else if(x==4)
            { num1=a*0.68;
                res.setText("Result ="+num1);
            }

            else
            { Toast.makeText(MainActivity.this, "Choose any", Toast.LENGTH_SHORT).show(); }

        }
        });
    }
}
