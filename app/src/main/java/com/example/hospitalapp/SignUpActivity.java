package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity
{

    Intent i;
EditText NameEd,EmailEd,Password1,ConfirmPass;
Button signupButton1,loginButton1;
    String name,Email,pass,CPass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Assign Id's
        NameEd=(EditText)findViewById(R.id.NameeditText1);
        EmailEd=(EditText)findViewById(R.id.EmaileditText1);
        Password1=(EditText)findViewById(R.id.Setpasswordedit);
        ConfirmPass=(EditText)findViewById(R.id.Confirmpasswordedit);

        signupButton1=findViewById(R.id.SignUpbutton);
        loginButton1=findViewById(R.id.Loginbutton3);


        signupButton1.setOnClickListener(new View.OnClickListener()
        {


              //  ,Email,pass,CPass;
            @Override
            public void onClick(View v)
            {
                name=NameEd.getText().toString();
                Email=EmailEd.getText().toString();
                pass=Password1.getText().toString();
                CPass=ConfirmPass.getText().toString();
                if (name.equals(null) || name.isEmpty() || Email.equals(null) || Email.isEmpty()||pass.equals(null) || pass.isEmpty() || CPass.equals(null) || CPass.isEmpty())
                {
                    Toast.makeText(SignUpActivity.this, "Please Enter Your details!! UserName & Password", Toast.LENGTH_LONG).show();

                }


                else
                {

                    Toast.makeText(SignUpActivity.this,"You have successfully Signed Up",Toast.LENGTH_LONG).show();
                    i=new Intent(SignUpActivity.this,MainActivity.class) ;
                    startActivity(i);
                }

            }
        });

        loginButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i=new Intent(SignUpActivity.this,MainActivity.class) ;
                startActivity(i);
            }
        });
    }

}
