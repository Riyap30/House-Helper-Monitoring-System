package com.example.maidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class memberloginpage extends AppCompatActivity {

    Button signupmem,memlog;
    EditText phonemem,passmem;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberloginpage);

        signupmem= (Button) findViewById(R.id.memup);
        memlog=(Button) findViewById(R.id.memlog) ;
        phonemem= findViewById(R.id.phonemem);
        passmem = findViewById(R.id.passwordmem);
        reference= FirebaseDatabase.getInstance().getReference().child("members");

        signupmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(memberloginpage.this,regmempage.class);
                startActivity(in);
            }
        });

        memlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin(v);
            }
        });

    }

    private void openLogin(View v) {
        final String pass;
        final String phonemem1 = phonemem.getText().toString();
        pass = passmem.getText().toString();
        if (reference.child(phonemem1) != null) {
            reference.child(phonemem1).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    memberhelper userHelp = dataSnapshot.getValue(memberhelper.class);
                    if (pass.equals(userHelp.getPassmem())) {
                        Toast.makeText(memberloginpage.this, "Login  Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(memberloginpage.this, memberdisplay.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(memberloginpage.this, "Wrong details", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        } else {
            Toast.makeText(memberloginpage.this, "User doesn't exist", Toast.LENGTH_SHORT).show();
        }
    }

    }