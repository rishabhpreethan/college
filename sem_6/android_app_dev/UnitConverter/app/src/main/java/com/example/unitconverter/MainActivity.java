package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{   EditText t1,res;
    RadioButton r1,r2,r3,r4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(EditText)findViewById(R.id.t1);
        res=(EditText)findViewById(R.id.res);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
        r4=(RadioButton)findViewById(R.id.r4);
        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {   @Override
        public void onClick(View v)
        {   String a=t1.getText().toString();
            float aa=Float.parseFloat(a);
            float c;
            if(r1.isChecked())
            {   c=aa/100;
                res.setText("Result ="+c);
            }
            else if(r2.isChecked())
            {   c=aa*100;
                res.setText("Result ="+c);
            }
            else if(r3.isChecked())
            {   c=aa*12;
                res.setText("Result ="+c);
            }
            else if(r4.isChecked())
            {   c=aa/12;
                res.setText("Result ="+c);
            }
            else {
                Toast.makeText(MainActivity.this, "Choose any one radio button", Toast.LENGTH_SHORT).show();
            }
        }
        });
    }
}
