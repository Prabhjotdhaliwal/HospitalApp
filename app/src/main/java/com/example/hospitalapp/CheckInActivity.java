package com.example.hospitalapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckInActivity extends AppCompatActivity {
    TextView nametxt,emailtxt,phonetxt;
    String Username1;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        nametxt=findViewById (R.id.nametxtpro);
        emailtxt=findViewById (R.id.emailtxtpro);
        phonetxt=findViewById (R.id.phonetxtpro);
     //   Username1 = getIntent().getExtras().getString("currentuserk");
     //   System.out.println(Username1);
       // nametxt.setText (Username1);
        sp=getSharedPreferences(MainActivity.MYPREFERENCES, Context.MODE_PRIVATE);

        nametxt.setText(sp.getString("KeyUser",""));
        phonetxt.setText(sp.getString("KeyPass",""));
        emailtxt.setText(sp.getString("KeyEmail",""));
    }
}
