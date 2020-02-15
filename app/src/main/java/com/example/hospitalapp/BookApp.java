package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BookApp extends AppCompatActivity {
    Button save;
    String myToast = "Details have been saved";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_app);

save= findViewById(R.id.savedetails);

save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(BookApp.this,myToast,Toast.LENGTH_LONG).show();

    }
});
    }
}
