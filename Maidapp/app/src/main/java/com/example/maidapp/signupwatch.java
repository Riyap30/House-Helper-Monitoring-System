package com.example.maidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupwatch extends AppCompatActivity {

FirebaseDatabase rootnode;
DatabaseReference reference;
Button buttonregw;

EditText regname,regusername,regcity,regsoc,regphone,regpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signupwatch);

// Save data in firebase after register button clicked
        buttonregw=(Button)findViewById(R.id.button4);
        regname=findViewById(R.id.namew);
        regusername=findViewById(R.id.usernamewr);
        regcity=findViewById(R.id.cityw);
        regsoc=findViewById(R.id.Socnamew);
        regphone=findViewById(R.id.phonew);
        regpass=findViewById(R.id.passwordwr);

        buttonregw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference("users");

                //get all the values
                String name=regname.getEditableText().toString();
                String username=regusername.getEditableText().toString();
                String city=regcity.getEditableText().toString();
                String soc=regsoc.getEditableText().toString();
                String phone=regphone.getEditableText().toString();
                String pass=regpass.getEditableText().toString();


                userHelperw helperclass =new userHelperw(name,username,city,soc,phone,pass);
                reference.child(soc).setValue(helperclass);

                Toast.makeText(signupwatch.this,"Registered Successfully,Go back to Login Page",Toast.LENGTH_SHORT).show();


            }
        });//register button method end

    }//on create method end
}