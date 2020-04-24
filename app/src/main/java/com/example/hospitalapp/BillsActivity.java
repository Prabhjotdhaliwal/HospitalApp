package com.example.hospitalapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BillsActivity extends AppCompatActivity {

    TextView crntbill,namebill,emailbill,phonebill,txt2,txt3 ;
    EditText name,amnt1,amnt2;
    Button pay;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
pay=findViewById (R.id.pay);
namebill=findViewById (R.id.nametxtbill);
        emailbill=findViewById (R.id.emailbill);
        phonebill=findViewById (R.id.phonebill);
        sp=getSharedPreferences(MainActivity.MYPREFERENCES, Context.MODE_PRIVATE);

        namebill.setText(sp.getString("KeyUser",""));
        phonebill.setText(sp.getString("KeyPass",""));
        emailbill.setText(sp.getString("KeyEmail",""));
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "this will redirect to payment page", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
