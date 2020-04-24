package com.example.hospitalapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ReportsActivity extends AppCompatActivity {
    LinearLayout LL1;
    TextView namep,agep,bloodurea,hemoglobin,proteinp,t3p,t4p,tshp,emailtxt,phonetxt;
    String Username1;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        namep=findViewById (R.id.nametxt);
        bloodurea=findViewById (R.id.blood);
        hemoglobin=findViewById (R.id.hemo);
        proteinp=findViewById (R.id.protein);
        t3p=findViewById (R.id.t3);
        t4p=findViewById (R.id.t4);
        tshp=findViewById (R.id.tsh);
emailtxt=findViewById (R.id.email11);
phonetxt=findViewById (R.id.phone11);
        sp=getSharedPreferences(MainActivity.MYPREFERENCES, Context.MODE_PRIVATE);

        reoprts();

    }

    private  void reoprts()

    {
        //to get data from the intent
        Username1 = getIntent().getExtras().getString("currentuserk");
        System.out.println(Username1);
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot> () {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshot :task.getResult())
                    {
                        String name= (String) documentSnapshot.getData().get("name");
                       // String age= (String) documentSnapshot.getData().get("age");
                        String bloodureastr= (String) documentSnapshot.getData().get("bloodurea");
                        String hemoglobinstr= (String) documentSnapshot.getData().get("Hemoglobin");
                        String Protein= (String) documentSnapshot.getData().get("Protein");
                        String t3= (String) documentSnapshot.getData().get("T3");
                        String t4= (String) documentSnapshot.getData().get("T4");
                        String tsh= (String) documentSnapshot.getData().get("TSH");

                       // System.out.println (name);
                      //  System.out.println (age);
                        System.out.println (bloodureastr);
                        System.out.println (hemoglobinstr);
                        System.out.println (Protein);
                        System.out.println (t3);
                        System.out.println (t4);
                        System.out.println (tsh);

                        //namep.setText (Username1);
                      //  agep.setText (age);
                        bloodurea.setText (bloodureastr);
                        hemoglobin.setText (hemoglobinstr);
                        proteinp.setText (Protein);
                        t3p.setText (t3);
                        t4p.setText (t4);
                        tshp.setText (tsh);
                        namep.setText(sp.getString("KeyUser",""));
                        phonetxt.setText(sp.getString("KeyPass",""));
                        emailtxt.setText(sp.getString("KeyEmail",""));



                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener () {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Toast.makeText(ReportsActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });


    }
}
