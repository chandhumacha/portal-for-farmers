package com.example.portalforfarmers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Main5Activity extends AppCompatActivity
{
    private Button but1;
    TextView tv;
    Calendar ct;
    int hrs,min;
    String format;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        but1=(Button)findViewById(R.id.bute);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Main6Activity.class);
                startActivity(intent);

            }
        });

        tv=(TextView) findViewById(R.id.textView1);
        ct=Calendar.getInstance();
        hrs=ct.get(Calendar.HOUR_OF_DAY);
        min=ct.get(Calendar.MINUTE);
        selectTimeFormat(hrs);
        tv.setText(hrs+" : " + min + " " + format);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd=new TimePickerDialog(Main5Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectTimeFormat(hourOfDay);
                        tv.setText(hourOfDay + " : " + min + " " + format);


                    }
                },hrs , min,true);
                tpd.show();
            }
        });

    }
    public void selectTimeFormat(int hrs)
    {
        if(hrs==0)
        {
            hrs+=12;
            format="AM";
        }
        else if(hrs==12)
        {
            format = "PM";
        }
        else if(hrs>12)
        {
            hrs -= 12;
            format = "PM";
        }
        else
        {
            format = "AM";
        }

    }
}
