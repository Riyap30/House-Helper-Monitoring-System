package com.example.maidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewmaiddeets extends AppCompatActivity {
    Button viewdeets;
    EditText iddmaid;
    ListView listView;
    DatePicker picker;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmaiddeets);
        picker = findViewById(R.id.datepicker);
        listView = findViewById(R.id.listview);
        iddmaid=findViewById(R.id.maididdetails);
        viewdeets=findViewById(R.id.viewmaiddetails);
        text= findViewById(R.id.textt);
        final ArrayList<String> list= new ArrayList<>();
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.list_item, list);
        listView.setAdapter(adapter);
        viewdeets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int date = picker.getDayOfMonth();
                int year= picker.getYear();
                int month= picker.getMonth()+1;

                String dateS= String.valueOf(date);
                String monthS= String.valueOf(month);
                String yearS= String.valueOf(year);
                String dym= dateS+'-'+monthS+'-'+yearS;

                String idmaid=iddmaid.getEditableText().toString();
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("maids").child(idmaid).child(dym);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list.clear();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                            tempoxhelper tempox= snapshot.getValue(tempoxhelper.class);
                            String txt= "Society : " + tempox.getsoci() + System.getProperty("line.separator") + "Temperature : " + tempox.gettemperature() +System.getProperty("line.separator")+ "Oxygen : " + tempox.getoxyg();
                            list.add(txt);
                            Integer temp = Integer.valueOf(tempox.gettemperature());
                            Integer oxy = Integer.valueOf(tempox.getoxyg());
                            String warning="WARNING!!!";
                            if(temp>37 || oxy<92 || temp<36.5 ){
                                text.setText(warning);
                                text.setTextColor(Color.parseColor("#ff0000"));
                            }


                        }

                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }
}