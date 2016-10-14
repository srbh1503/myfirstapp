package com.example.saurabh.mytag;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    EditText num_one,num_two;
    Button sum,sub,div,mul;
    String op="";
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // buttons initialization
        num_one=(EditText)findViewById(R.id.num1);
        num_two=(EditText)findViewById(R.id.num2);
        sum=(Button)findViewById(R.id.button1);
        sub=(Button)findViewById(R.id.button2);
        mul=(Button)findViewById(R.id.button3);
        div=(Button)findViewById(R.id.button4);
        display=(TextView)findViewById(R.id.display);
        sum.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        //buttons completed
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.button1:float sum,a,b;
                op="+";
                a=Float.parseFloat(num_one.getText().toString());
                b=Float.parseFloat(num_two.getText().toString());
                sum=a+b;
                display.setText(a+" "+op+" "+b+"="+sum);
                break;
            case R.id.button2:float sub,a1,b1;
                op="-";
                a1=Float.parseFloat(num_one.getText().toString());
                b1=Float.parseFloat(num_two.getText().toString());
                sub=a1-b1;
                display.setText(a1+" "+op+" "+b1+"="+sub);
                break;
            case R.id.button3:float mul,a2,b2;
                op="*";
                a2=Float.parseFloat(num_one.getText().toString());
                b2=Float.parseFloat(num_two.getText().toString());
                mul=a2*b2;
                display.setText(a2+" "+op+" "+b2+"="+mul);
                break;
            case R.id.button4: float di=0;
                float a3,b3;
                op="/";
                a3=Float.parseFloat(num_one.getText().toString());
                b3=Float.parseFloat(num_two.getText().toString());
                if(b3==0)
                {
                    Toast.makeText(MainActivity.this,"Incorrect entry",Toast.LENGTH_LONG).show();
                }
                else {
                    di= a3/b3;
                }
                display.setText(a3+" "+op+" "+b3+"="+di);
                break;
            default: break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
