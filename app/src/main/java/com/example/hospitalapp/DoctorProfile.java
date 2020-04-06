package com.example.hospitalapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class DoctorProfile extends AppCompatActivity {
TextView docnametxt,docspectxt,docfeetxt,doctimetxt,setdate,settime;
TimePicker timePicker;
Button bookAppointment,settimebtn;
CalendarView calendarView;
Intent i;
String currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_doctor_profile);
        docnametxt=findViewById (R.id.docnametxt);
        docspectxt=findViewById (R.id.docspectxt);
        docfeetxt=findViewById (R.id.docfeetxt);
        doctimetxt=findViewById (R.id.doctimetxt);
        setdate=findViewById (R.id.setdate);
        settime=findViewById (R.id.settime);
        calendarView=findViewById (R.id.calender);
        timePicker=(TimePicker)findViewById (R.id.timepicker);
        timePicker.setIs24HourView (true);
        bookAppointment=findViewById (R.id.bookapt);
        settimebtn=findViewById (R.id.settimebtn);
        getdocInfo ();
        setDate();
//        android:entries="@array/Genres"
        bookAppointment.setOnClickListener (new View.OnClickListener ()
        {
            @Override
            public void onClick(View v) {
                bookappointment ();
            }
        });

        settimebtn.setOnClickListener (new View.OnClickListener ()
       {
         @Override
       public void onClick(View v)
         {
        setTime ();
             System.out.println (settime.getText ());

         }
       });

    }

    public   void   getdocInfo()
    {
       // Bundle bundle = getIntent().getExtras();
        // String dnamee = bundle.getString("dname1");
        //  String dspecc = bundle.getString("dspec1");
        String dnamee=getIntent().getStringExtra ("dname1");
        String dspecc=getIntent().getStringExtra ("dspec1");
        String dfee=getIntent().getStringExtra ("dfee");
        String dtime=getIntent().getStringExtra ("dtime");

        // System.out.println ("Jot");
       //System.out.println (dfee);
        //System.out.println (dtime);
        docnametxt.setText (dnamee);
        docspectxt.setText (dspecc);
        docfeetxt.setText (dfee);
        doctimetxt.setText ("Timing "+dtime);
    }

    public   void   setDate() {
        calendarView.setOnDateChangeListener (new CalendarView.OnDateChangeListener () {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Long Date = calendarView.getDate ();
                Toast.makeText (getApplicationContext (), "" + dayOfMonth, Toast.LENGTH_SHORT).show ();
                String calDate = dayOfMonth + "/" +( month+1) + "/" + year;
                setdate.setText ("Date "+calDate);
            }
        });


    }


    public   void   setTime()
     {
       int hour , minute;
       String am_pm;

      if(Build.VERSION.SDK_INT>=23)
      {
         hour=timePicker.getHour ();
         minute=timePicker.getMinute ();
      }

      else
      {
          hour=timePicker.getCurrentHour ();
          minute=timePicker.getChildCount ();
      }

      if (hour>12)
       {
        am_pm="PM";
        hour=hour-12;

       }
      else
       {
           am_pm="AM";
       }

      settime.setText (hour+":"+minute+" "+am_pm);

    }

        public void bookappointment ()
        {
           String docNameapt=docnametxt.getText ().toString ();
            String docSpecapt=docspectxt.getText ().toString ();
            String docfeeapt=docfeetxt.getText ().toString ();
            String doctimeapt=doctimetxt.getText ().toString ();
            String dateapt=setdate.getText ().toString ();
            String timeapt=settime.getText ().toString ();


            HashMap<String,String> appointments=new HashMap<>();
            appointments.put("docNameaptk",docNameapt);
            appointments.put("docSpecaptk",docSpecapt);
            appointments.put("docfeeaptk",docfeeapt);
            appointments.put("doctimeaptk",doctimeapt);
            appointments.put("dateaptk",dateapt);
            appointments.put("timeapt",timeapt);



            FirebaseFirestore db=FirebaseFirestore.getInstance();
            db.collection("Appointments").add(appointments).addOnCompleteListener(new OnCompleteListener<DocumentReference> () {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task)
                {

                    Toast.makeText(DoctorProfile.this,"Your appointment has been successfully booked ",Toast.LENGTH_SHORT).show();
                    // Intent i=new Intent (DoctorProfile.this,MyAppointActivity.class);

                }
            }).addOnFailureListener(new OnFailureListener()

            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(DoctorProfile.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }
            });

        }
    }