package com.example.hospitalapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MyAppointActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<String> DocNames1 = new ArrayList<>();
    ArrayList<String> DocfeeList1 = new ArrayList<>();
    ArrayList<String> dateapts1 = new ArrayList<>();
    ArrayList<String> timings1 = new ArrayList<>();

    String  Username1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appoint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
getbookedappointment ();
    }

    private void getbookedappointment()
    {

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Appointments").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot> () {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshot :task.getResult())
                    {
                        System.out.println(documentSnapshot.getData().get("docNameaptk"));
                        System.out.println("jots");
                        System.out.println( documentSnapshot.getData().get("docSpecaptk"));

                        System.out.println(documentSnapshot.getData().get("docfeeaptk"));
                        System.out.println("jots");
                        System.out.println( documentSnapshot.getData().get("doctimeaptk"));
                        System.out.println(documentSnapshot.getData().get("dateaptk"));
                        System.out.println("jots");
                        System.out.println( documentSnapshot.getData().get("timeapt"));
                        String docnameapt= (String) documentSnapshot.getData().get("docNameaptk");
                        String docfeeeapt= (String) documentSnapshot.getData().get("docfeeaptk");
                        String docdateapt= (String) documentSnapshot.getData().get("dateaptk");
                        String doctimeapt= (String) documentSnapshot.getData().get("timeapt");

                        DocNames1.add (docnameapt);
                        DocfeeList1.add (docfeeeapt);
                        dateapts1.add (docdateapt);
                        timings1.add (doctimeapt);

                         System.out.println (DocNames1);
                        System.out.println (DocfeeList1);
                        System.out.println (dateapts1);
                        System.out.println (timings1);





                        //add Doctornames to the recyclerView List

                      initRecyclerView1 (DocNames1,dateapts1,DocfeeList1,timings1);

                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener () {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(MyAppointActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });


    }



    private void  initRecyclerView1(ArrayList<String> allDoctors, ArrayList<String>allSpeciality, ArrayList<String>allDoctorsfees, ArrayList<String>allDoctimings)
    {
        Log.d(TAG,"initRecyclerView:init recyclerView.");
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter1= new RecyclerViewAdapter  (this,allDoctors,allSpeciality,allDoctorsfees,allDoctimings);
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
     //   adapter.setClickListener(onClickListener);

    }
}
