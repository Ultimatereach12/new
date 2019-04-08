package com.student.admin.desire;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.student.admin.desire.common.test;
import com.student.admin.desire.datagetter.loginresponse;
import com.student.admin.desire.webservice.api;
import com.student.admin.desire.webservice.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {


    TextView login,register;
    LinearLayout loginl1,loginl2;

       EditText  username1,password1,username,password,phone;
      EditText email,birth,gender;
      ImageButton  loginbutton;
      test test12;
    Snackbar snackbar;
    LinearLayout coordinatorLayout;
    public login activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
          getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
          WindowManager.LayoutParams.FLAG_FULLSCREEN);
          setContentView(R.layout.login);

           coordinatorLayout = (LinearLayout) findViewById(R.id.test);
           Toolbar toolbar = findViewById(R.id.toolbar);
           setSupportActionBar(toolbar);
           test12=new test();
           login=findViewById(R.id.login);
           register=findViewById(R.id.register);
           loginl1=findViewById(R.id.loginl1);
           loginl2=findViewById(R.id.loginl2);
           loginbutton=findViewById(R.id.loginbutton);
            phone= findViewById(R.id.phone);

             username=findViewById(R.id.username);
             password=findViewById(R.id.password);


             username1=findViewById(R.id.username1);
             password1=findViewById(R.id.password1);
             email=findViewById(R.id.email);
             birth=findViewById(R.id.birth);
             gender=findViewById(R.id.gender);



          loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(password.getText().toString().length()>4){
                    gg();

                }else if(password1.getText().toString().length()>5){


                    g();
                }else {
                    Toast.makeText(getApplicationContext(), "Enter data", Toast.LENGTH_SHORT).show();
                }


            }
        });


           login .setOnClickListener(new View.OnClickListener() {
             @Override
           public void onClick(View v) {

                  loginl1.setVisibility(View.VISIBLE);
                  loginl2.setVisibility(View.GONE);
                  login.setTextColor(Color.BLUE);
                  register.setTextColor(Color.rgb(155,155,155));
                  login.setTextColor(Color.parseColor("#2D3192"));
             }
         });

        register.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
                loginl1.setVisibility(View.GONE);
                loginl2.setVisibility(View.VISIBLE);
                login.setTextColor(Color.rgb(155,155,155));
                register.setTextColor(Color.parseColor("#2D3192"));
            }
        });

    }

    private void gg() {

        final api mApiService =  network.getRetrofit().create(api.class);
        Call<loginresponse> call = mApiService.Login(username.getText().toString(),password.getText().toString());
        call.enqueue(new Callback<loginresponse>() {
            @Override
            public void onResponse(Call<loginresponse> call, Response<loginresponse> response) {
                password.setText("");
                System.out.println( call.request().url());
                Toast.makeText(login.this, response.body().getResponse().getResponse_message(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<loginresponse> call , Throwable t) {
                System.out.println(call.request().url());
                Log.d("Error", t.getMessage());
            }
        });

    }

    private void g() {

        String user=username1.getText().toString();
        String pass=password1.getText().toString();
        String birthday=birth.getText().toString();
        String email1=email.getText().toString();
        String gender1=gender.getText().toString();
        String phone1=phone.getText().toString();



        final api mApiService =  network.getRetrofit().create(api.class) ;
        Call<loginresponse> call = mApiService.register(user,email1,phone1,gender1,birthday,pass,"","","","");
        call.enqueue(new Callback<loginresponse>() {
            @Override
            public void onResponse(Call<loginresponse> call, Response<loginresponse> response) {
                password.setText("");
                System.out.println( call.request().url());
            }
            @Override
            public void onFailure(Call<loginresponse> call, Throwable t) {
                System.out.println( call.request().url());
                Log.d("Error", t.getMessage());
            }
        });
    }

    public void loginresponse12(loginresponse body, Context applicationContext) {
        Toast.makeText(applicationContext, body.getResponse().getResponse_message(), Toast.LENGTH_SHORT).show();

   }
}
