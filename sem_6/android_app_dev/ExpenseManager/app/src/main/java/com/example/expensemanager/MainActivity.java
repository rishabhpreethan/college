package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
{
    String s1, s2;
    EditText et1, et2;
    TextView tv1;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et_cat);
        et2=(EditText)findViewById(R.id.et_price);
        tv1=(TextView)findViewById(R.id.tv_output);
    }

    public void save (View view)
    {   s1 = et1.getText().toString();
        s2 = s1+ " "+et2.getText().toString()+"\n";

        try
        { FileOutputStream fos = openFileOutput("file1.txt", MODE_APPEND);
            fos.write(s2.getBytes());
        }
        catch (FileNotFoundException e)
        { e.printStackTrace(); }

        catch (Exception e)
        { e.printStackTrace(); }
    }

    public void load (View v)
    {  try
    {    FileInputStream fis = openFileInput("file1.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String text;
        while ((text=br.readLine())!= null)
        {   sb.append(text);
            sb.append("\n");
        }

        tv1.setText (sb.toString());
    }
    catch (FileNotFoundException e)
    { e.printStackTrace(); }

    catch (Exception e)
    { e.printStackTrace(); }
    }
}
