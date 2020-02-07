package com.example.hospitalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    LinearLayout first;
    Button login,signup;
    TextView forgotPass;
    EditText username,password;
    ImageView img;
    Intent i;
    String UsernameStr,PasswordStr;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first=findViewById(R.id.firstLayout);
        forgotPass=findViewById(R.id.ForgotpasstextView);
        username=(EditText)findViewById(R.id.UsereditText);
        password=(EditText)findViewById(R.id.passwordeditText4);
        img=(ImageView)findViewById(R.id.LogoimageView2);


        login=findViewById(R.id.Loginbutton);
        signup=findViewById(R.id.SignUpbutton3);



        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //save user's Information
                UsernameStr=username.getText().toString();
                PasswordStr=password.getText().toString();
                if (UsernameStr.equals(null) || UsernameStr.isEmpty() || PasswordStr.equals(null) || PasswordStr.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter Your details!! UserName & Password", Toast.LENGTH_LONG).show();

                }
                else
                    {

                    i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("UserName",UsernameStr);
                        startActivity(i);
                   }
            }
        });


        //Forgot password
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this,"Enter Your email",Toast.LENGTH_LONG).show();

            }
        });



        //SignUP
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

    }

}
