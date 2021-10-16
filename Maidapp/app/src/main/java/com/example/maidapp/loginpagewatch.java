package com.example.maidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginpagewatch extends AppCompatActivity {
    //Variables
    Button buttonsignup, buttonlogin;
    EditText societyname, password;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loginpagewatch);

        //hooks
        societyname= findViewById(R.id.socinamew);
        password= findViewById(R.id.passwordw);
        buttonsignup = (Button) findViewById(R.id.button3);
        buttonlogin = (Button) findViewById(R.id.button2);
        reference= FirebaseDatabase.getInstance().getReference().child("users");
        buttonlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openLogin(v);
            }

        });
        //go to registration activity
        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpagewatch.this, signupwatch.class);
                startActivity(intent);
            }
        });



    }
    String pass;
    public void openLogin(View v){
        final String sociname = societyname.getText().toString();
        pass = password.getText().toString();
        if (reference.child(sociname) != null) {
            reference.child(sociname).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    userHelperw userHelp = dataSnapshot.getValue(userHelperw.class);
                    if (pass.equals(userHelp.getPass())) {
                        Toast.makeText(loginpagewatch.this, "Login  Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(loginpagewatch.this, profileandeditw.class);
                        intent.putExtra("sociname",sociname);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(loginpagewatch.this, "Wrong details", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } else {
            Toast.makeText(loginpagewatch.this, "User doesn't exist", Toast.LENGTH_SHORT).show();
        }
    }

}


















