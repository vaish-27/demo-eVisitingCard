package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailId,password;
    Button submitButton;
    Pattern pattern;
    Matcher matcher;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailId=findViewById(R.id.email_id);
        password=findViewById(R.id.password);
        submitButton=findViewById(R.id.submit);
        progressBar=findViewById(R.id.progressbar);

        progressBar.setVisibility(View.GONE);
        submitButton.setVisibility(View.VISIBLE);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!emailId.getText().toString().trim().isEmpty()) {
                    if (!password.getText().toString().trim().isEmpty()) {
                        if (isValidEmail(emailId.getText().toString())) {
                            if (validatePassword(password.getText().toString())) {

                                progressBar.setVisibility(View.VISIBLE);
                                submitButton.setVisibility(View.GONE);


//                                ProgressDialog progress = new ProgressDialog(MainActivity.this);
//                                progress.setTitle("Loading");
//                                progress.setMessage("Wait while loading...");
//                                progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
//                                progress.show();
//// To dismiss the dialog
//                                progress.dismiss();



                                Intent i = new Intent(MainActivity.this, HomeScreenActivity.class);
                                startActivity(i);



                            } else{
                                Toast.makeText(getApplicationContext(), "Password must contain special characters and number", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            Toast.makeText(MainActivity.this, "Please enter valid email Id", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter your Password", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter your Email Address", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public  boolean validatePassword(String password){
        final String PASSWORD_PATTERN = "^(?=.*[0-9])" +
//                                        "(?=.*[A-Z])" +
                                        "(?=.*[@#$%^&+=!])" +
                                        "(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }

}