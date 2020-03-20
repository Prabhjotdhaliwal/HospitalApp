package com.example.hospitalapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;

import me.relex.circleindicator.CircleIndicator;


public class Main2Activity extends AppCompatActivity
{
    TextView bookAppoinrment;
    SearchView searchdoc;
    Button myapp,checkinbtn,repbtn,billsbtn,searchButton1;
    Intent i;
    String Username1;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ViewPagerClass myPager;
FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        //assign id's
        bookAppoinrment=findViewById(R.id.bookapt);
      //  searchdoc=findViewById(R.id.SearchView11);
        myapp =findViewById(R.id.appointButton);
        checkinbtn =findViewById(R.id.CheckinButton);
        repbtn =findViewById(R.id.reportButton);
        billsbtn =findViewById(R.id.billsButton);


        // to set a view pager
        myPager = new ViewPagerClass(this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(myPager);
        circleIndicator = findViewById(R.id.circle);
        circleIndicator.setViewPager(viewPager);


        firebaseAuth=FirebaseAuth.getInstance();

        //to get data from the intent
      //  Username1 = getIntent().getExtras().getString("UserName");
      //  System.out.println(Username1);
        //search doctor
        searchButton1=findViewById(R.id.SearchButton1);
        searchButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               i=new Intent(Main2Activity.this,DoctorsActivity.class);
                startActivity(i);
            }
        });

        //Book appointment
        myapp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(Main2Activity.this, MyAppointActivity.class);
                i.putExtra("UserName",Username1);
                startActivity(i);
            }
        });

        //checkin

        checkinbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(Main2Activity.this, CheckInActivity.class);
                i.putExtra("UserName",Username1);
                startActivity(i);
            }
        });

       //Reports

        repbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(Main2Activity.this, ReportsActivity.class);
                i.putExtra("UserName",Username1);
                startActivity(i);
            }
        });

        //bills
        billsbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(Main2Activity.this, BillsActivity.class);
                i.putExtra("UserName",Username1);
                startActivity(i);
            }
        });

    }


    //To create a menu in the tool bar
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // to inflate the menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.profile1:
                Toast.makeText(getApplicationContext(),"Update Profile Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Notifications:
                Toast.makeText(getApplicationContext(), "Notifications Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Settings:
                Toast.makeText(getApplicationContext(), "Settings Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Feedback:
                Toast.makeText(getApplicationContext(), "Feedback Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Terms:
                Toast.makeText(getApplicationContext(), "Terms Selected ", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Help:
                Toast.makeText(getApplicationContext(), "Help Selected", Toast.LENGTH_LONG).show();
                return true;
            case  R.id.LogOut:
                firebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                return true;

            default:
                return false;
        }
    }





}