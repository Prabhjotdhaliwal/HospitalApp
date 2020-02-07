package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckInActivity extends AppCompatActivity {
Button B2;
Intent I;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        B2= findViewById(R.id.backtomain2);

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I = new Intent(CheckInActivity.this, Main2Activity.class);
                startActivity(I);
            }
        });

    }
}
