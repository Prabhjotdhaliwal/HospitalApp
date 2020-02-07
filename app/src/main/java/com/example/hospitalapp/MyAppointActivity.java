package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyAppointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appoint2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }
}
