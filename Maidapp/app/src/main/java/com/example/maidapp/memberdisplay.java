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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class memberdisplay extends AppCompatActivity {
Button button;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawyerlayout;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberdisplay);
        button= findViewById(R.id.view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(memberdisplay.this, viewmaiddeets.class);
                startActivity(intent);
            }
        });

        toolbar= (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawyerlayout =(DrawerLayout)findViewById(R.id.drawer);

        toggle= new ActionBarDrawerToggle(this,drawyerlayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawyerlayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.menu_med :
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019"));
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"opening",Toast.LENGTH_LONG).show();
                        drawyerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logout21 :
                        Intent intent1 = new Intent(memberdisplay.this,dashboard.class);
                        startActivity(intent1);
                        finish();
                        Toast.makeText(getApplicationContext(),"Logged Out Successfully",Toast.LENGTH_LONG).show();
                        drawyerlayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

    }
}