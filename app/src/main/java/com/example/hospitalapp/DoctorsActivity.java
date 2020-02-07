package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class DoctorsActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> DocNames = new ArrayList<>();
    private ArrayList<String> DocSpecialityList = new ArrayList<>();

    ListView listDoc;
    SearchView searchDoc;

//ArrayList<String> DoctorList;

    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //assign ids

        //  listDoc=findViewById(R.id.listView);
        searchDoc = findViewById(R.id.SearchView11);
//call add doctor method to set the reclerview
        addDoctors();
        //Add items to your doc List

        // DoctorList  = new ArrayList<>();

       /* DoctorList.add("eee");
        DoctorList.add("ddd");
        DoctorList.add("sss");
        DoctorList.add("sss");
        DoctorList.add("ssss");
        DoctorList.add("sss");
        DoctorList.add("sss");
        DoctorList.add("sss");
        DoctorList.add("ss");
        DoctorList.add("sss");*/

        //set adapter to a list view
        //  myAdapter   = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List<String>) listDoc);listDoc.setAdapter(myAdapter);

/*
       searchDoc.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
*/

//add Doctornames to the recyclerView List
    }


    private void addDoctors()
    {
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



        //call recyclerView;
        initRecyclerView ();
    }



//Intialize Recyclerview
        private void  initRecyclerView()
        {
            Log.d(TAG,"initRecyclerView:init recyclerView.");
            RecyclerView recyclerView=findViewById(R.id.recycler_view);
            RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,DocNames,DocSpecialityList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }




}
