package com.example.hospitalapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{

    public static final String MYPREFERENCES ="Jot";
    LinearLayout first;
    Button login;
    TextView forgotPass,registernow;
    EditText username,password;
    ImageView img;
    Intent i;
FirebaseAuth firebaseAuth;
    //retrofit
    private Retrofit retrofit;
    private  RetrofitInterface retrofitInterface;
    private  String Base_url="http://10.0.2.2:3000/";
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

        //instantiate retrofit

        retrofit =new Retrofit.Builder ().baseUrl (Base_url)
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        retrofitInterface= retrofit.create (RetrofitInterface.class);
        login=findViewById(R.id.Loginbutton);
        registernow=findViewById(R.id.registernow);
        firebaseAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //save user's Information
            LoginUser();
           // HandleLoginUser ();

            }

        });


        //Forgot password
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this,"Enter Your email",Toast.LENGTH_LONG).show();
//sdfghasdfghjk
            }

        });



        //SignUP
        registernow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });





    }

    public  void  HandleLoginUser()
    {
        final String usernameStr, passwordStr;

        usernameStr = username.getText().toString();
        passwordStr = password.getText().toString();

        if (TextUtils.isEmpty(usernameStr)) {
            username.setError("Email is Required ");

        }
        if (TextUtils.isEmpty(passwordStr)) {
            password.setError("Password is Required ");

        }
        if (passwordStr.length() < 8) {
            password.setError("Password must be >= 6 Characters");
        } else {

            HashMap<String,String > map=new HashMap<> ();
            map.put("email",username.getText().toString());
            map.put("password",password.getText().toString());
            Call<LoginResult> call=retrofitInterface.executeLogin (map);
            call.enqueue (new Callback<LoginResult> () {
                @Override
                public void onResponse(Call<LoginResult> call, Response<LoginResult> response)
                {
                    if(response.message ()=="OK")
                    {
                        LoginResult loginResult = new LoginResult (usernameStr, passwordStr);


                        LoginResult result=response.body ();
                        AlertDialog.Builder builder1=new AlertDialog.Builder (MainActivity.this);

                        builder1.setTitle (result.getEmail ());
                        builder1.setMessage (result.getPassword ());
                        builder1.show ();
                        Toast.makeText (MainActivity.this,"right credentials",Toast.LENGTH_LONG).show ();
                        Intent i=new Intent (MainActivity.this,Main2Activity.class);
                        startActivity (i);

                    }
                    else
                    {
                        Toast.makeText (MainActivity.this,"Wrong credentials",Toast.LENGTH_LONG).show ();
                        System.out.println ("jothii");
                        LoginResult result=response.body ();
                        System.out.println (result);

                        System.out.println (response.message ());
                    }
                }

                @Override
                public void onFailure(Call<LoginResult> call, Throwable t) {
                    Toast.makeText (MainActivity.this,t.getMessage (),Toast.LENGTH_SHORT).show ();
                }
            });
        }}


    //SignInUser //firebase
       public  void  LoginUser() {
           final String usernameStr, passwordStr;

           usernameStr = username.getText().toString();
           passwordStr = password.getText().toString();

           if (TextUtils.isEmpty(usernameStr)) {
               username.setError("Email is Required ");

           }
           if (TextUtils.isEmpty(passwordStr)) {
               password.setError("Password is Required ");

           }
           if (passwordStr.length() < 8) {
               password.setError("Password must be >= 6 Characters");
           } else {
               //Authenticate the user
               firebaseAuth.signInWithEmailAndPassword(usernameStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Toast.makeText(getApplicationContext(), "User has successfully logged in", Toast.LENGTH_SHORT).show();
                           Intent i=new Intent (MainActivity.this,Main2Activity.class);
                             i.putExtra("currentuserk", usernameStr);
                           startActivity (i);
                         //  startActivity(new Intent(MainActivity.this, Main2Activity.class));

                       } else {
                           Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                       }
                   }

               });

           }
       }

}
