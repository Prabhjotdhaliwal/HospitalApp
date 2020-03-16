package com.example.hospitalapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorsActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> DocNames = new ArrayList<>();
    private ArrayList<String> DocSpecialityList = new ArrayList<>();
    ListView listDoc;
    SearchView searchDoc;
    FirebaseFirestore db;


    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        //assign ids

        //  listDoc=findViewById(R.id.listView);
        searchDoc = findViewById(R.id.SearchView11);
//call add doctor method to set the reclerview
      // addDoctors();
      //  initRecyclerView();
getDoctorsInfo();
//add Doctornames to the recyclerView List
    }

    private void getDoctorsInfo()
    {
        db=FirebaseFirestore.getInstance();
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Doctors").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshot :task.getResult())
                    {
                       System.out.println(documentSnapshot.getData().get("Doctornames"));
                        System.out.println("jots");
                        System.out.println( documentSnapshot.getData().get("DoctorSpeciality"));

                        ArrayList<String> DocNames1 = new ArrayList<>();
                        ArrayList<String> DocSpecialityList1 = new ArrayList<>();

                        for (int i=0;i<documentSnapshot.getData().size();i++)
                       {
                           DocNames1.add(documentSnapshot.getData().get("Doctornames").toString());
                           DocSpecialityList1.add(documentSnapshot.getData().get("DoctorSpeciality").toString());

                       }
                     //   ArrayList<String> Docdata = new ArrayList<>();
                     //   ArrayList<String> DocSpecialitydata = new ArrayList<>();
                     //   Docdata.add(documentSnapshot.getData().get("Doctors").toString());
                     //   DocSpecialitydata.add(documentSnapshot.getData().get("Speciality").toString());

                      //   for (int i=0;i<Docdata.size();i++)
                      //   {

                             //   DocSpecialityList1.add(DocSpecialitydata.get(i));
                      //   }
                       initRecyclerView(DocNames1,DocSpecialityList1);

                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(DoctorsActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
////

    }
    private void addDoctors() {


        DocNames.add("A.B.Prabhu");
        DocNames.add("Ajit Kumar Avasthi");
        DocNames.add("A S Bawa ");
        DocNames.add(" Abhishek Puri ");
        DocNames.add("Bhupinderjit Waraich");
        DocNames.add("Daljeet Kaur ");
        DocNames.add("Deepak Kumar Bhasin");
        DocNames.add("Diljot Singh Bedi");
        DocNames.add("Hardeep Singh ");
        DocNames.add("Harsimran Singh ");
        DocNames.add("Navreet Kaur Sandhu");
        DocNames.add("Parneet Sidhu ");
        DocNames.add("Preeti Jindal");
        DocSpecialityList.add("Plastic and Reconstructive Surgery");
        DocSpecialityList.add("Mental Health and Behavioural Sciences");
        DocSpecialityList.add("Urology");
        DocSpecialityList.add("Radiation Oncology");
        DocSpecialityList.add("Mental Health and Behavioural Sciences");
        DocSpecialityList.add("Dermatology");
        DocSpecialityList.add("Gastroenterology and Hepatology Sciences");
        DocSpecialityList.add("Neonatology");
        DocSpecialityList.add("Mental Health and Behavioural Sciences");
        DocSpecialityList.add("Bone and Joint");
        DocSpecialityList.add("Intensive Care and Critical Care");
        DocSpecialityList.add("Mental Health and Behavioural Sciences");
        DocSpecialityList.add("Obstetrics and Gynaecology");


        HashMap<String, ArrayList<String>> Doc = new HashMap<>();
        Doc.put("DoctorSpeciality",DocSpecialityList);
        Doc.put("Doctornames", DocNames);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Doctors").add(Doc).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(DoctorsActivity.this, "Doctors Added", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DoctorsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();


            }
        });


        //call recyclerView;
       //initRecyclerView();
    }

//

//Intialize Recyclerview
        private void  initRecyclerView(ArrayList<String>allDoctors,ArrayList<String>allSpeciality)
        {
            Log.d(TAG,"initRecyclerView:init recyclerView.");
            RecyclerView recyclerView=findViewById(R.id.recycler_view);
            RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,allDoctors,allSpeciality);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }




}
