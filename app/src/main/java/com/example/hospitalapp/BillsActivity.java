package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BillsActivity extends AppCompatActivity {

    TextView crntbill,total,history,txt1,txt2,txt3 ;
    EditText name,amnt1,amnt2;
    Button pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        crntbill = findViewById(R.id.crntbill);
        total = findViewById(R.id.total);
        history = findViewById(R.id.history);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        name = findViewById(R.id.name);
        amnt1 = findViewById(R.id.amnt1);
        amnt2 = findViewById(R.id.amnt2);
        pay = findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "this will redirect to payment page", Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
    }
}
