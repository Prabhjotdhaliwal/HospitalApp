package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

public class MyAppointActivity extends AppCompatActivity {
Button b1;
Intent backmyapp;

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appoint2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
b1= findViewById(R.id.Backfrommyappoitment);

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        backmyapp = new Intent (MyAppointActivity.this, Main2Activity.class);
        startActivity(backmyapp);
    }
});
    }
}
