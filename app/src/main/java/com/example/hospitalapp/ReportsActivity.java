package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReportsActivity extends AppCompatActivity {
    LinearLayout LL1;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);


        LL1=findViewById(R.id.LL1);
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t7=findViewById(R.id.textView7);
        t8=findViewById(R.id.textView8);
        t9=findViewById(R.id.textView9);
        t10=findViewById(R.id.textView10);
        t11=findViewById(R.id.textView11);

        t7.setText("John");
        t8.setText("66");
        t9.setText("male");
        t10.setText("A-");
        t11.setText("serious");

    }
}
