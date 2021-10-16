package com.example.maidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class regmempage extends AppCompatActivity {

    EditText regnamemem,regcitymem,regsocmem,regphonemem,regpassmem;
    Button regmembutton;

    FirebaseDatabase rootnode1;
    DatabaseReference reference1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regmempage);

        regmembutton=(Button) findViewById(R.id.memreg);
        regnamemem=findViewById(R.id.namemem);
        regcitymem=findViewById(R.id.citymem);
        regsocmem=findViewById(R.id.Socnamemem);
        regphonemem=findViewById(R.id.phonemem);
        regpassmem=findViewById(R.id.passwordmemr);

        regmembutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode1=FirebaseDatabase.getInstance();
                reference1=rootnode1.getReference("members");

                String namemem= regnamemem.getEditableText().toString();
                String citymem = regcitymem.getEditableText().toString();
                String socmem= regsocmem.getEditableText().toString();
                String phonemem= regphonemem.getEditableText().toString();
                String passmem= regpassmem.getEditableText().toString();

                memberhelper helperclass1 =new memberhelper(namemem,citymem,socmem,phonemem,passmem);

                reference1.child(phonemem).setValue(helperclass1);
                Toast.makeText(regmempage.this,"Registered Successfully,Go back to Login Page",Toast.LENGTH_SHORT).show();

            }
        });

    }
}