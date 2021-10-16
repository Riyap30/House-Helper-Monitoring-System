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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tempoxygen extends AppCompatActivity {
    DatePicker picker;
    EditText Id, temperature, oxy;
    Button adddetails, viewdetails;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempoxygen);
        Intent i = getIntent();
        final String st = i.getStringExtra("soci");
       picker= findViewById(R.id.datepicker);
        temperature=findViewById(R.id.temp);
        oxy=findViewById(R.id.oxygen);
        Id=findViewById(R.id.idofmaid);

        adddetails=(Button)findViewById(R.id.addtempox);
        viewdetails=(Button)findViewById(R.id.viewdetails);

        adddetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get all the values
                int date = picker.getDayOfMonth();
                int year= picker.getYear();
                int month= picker.getMonth()+1;

                String idofmaid =Id.getEditableText().toString();
                String temp=temperature.getEditableText().toString();
                String oxygen=oxy.getEditableText().toString();
                String dateS= String.valueOf(date);
                String monthS= String.valueOf(month);
                String yearS= String.valueOf(year);
                String dym= dateS+'-'+monthS+'-'+yearS;




                rootnode= FirebaseDatabase.getInstance();
                reference=rootnode.getReference("maids").child(idofmaid).child(dym);


                tempoxhelper tempoxhelperclass =new tempoxhelper(st, temp,oxygen);
                reference.child(st).setValue(tempoxhelperclass);

                Toast.makeText(tempoxygen.this,"Successful",Toast.LENGTH_SHORT).show();



            }
        });


        viewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(tempoxygen.this,viewmaiddetails.class);
                startActivity(in);
            }
        });

            }

}