package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyAppointActivity extends AppCompatActivity {
Layout l1;
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
Button b1;
Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appoint2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        b1= findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyAppointActivity.this, BookApp.class);
                startActivity(i);
            }
        });

    }
}
