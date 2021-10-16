package com.example.maidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class maidadd extends AppCompatActivity {
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    Button buttonadd;
    EditText maididd,firstname,lastname,phonem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maidadd);
        Intent i = getIntent();
        final String st = i.getStringExtra("soci");
        buttonadd=(Button)findViewById(R.id.buttonadd);


        maididd=findViewById(R.id.maidid);
        firstname=findViewById(R.id.fname);
        lastname=findViewById(R.id.lname);
        phonem=findViewById(R.id.phone);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get all the values
                String maidid = maididd.getEditableText().toString();
                String fname=firstname.getEditableText().toString();
                String lname=lastname.getEditableText().toString();
                String phone=phonem.getEditableText().toString();


                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference("maids");


                maidhelper helperclass =new maidhelper(fname,lname,phone);
                reference.child(maidid).setValue(helperclass);

                Toast.makeText(maidadd.this,"Successful",Toast.LENGTH_SHORT).show();


            }
        });

    }
}