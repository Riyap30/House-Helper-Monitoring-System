package com.example.maidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class dashboard extends AppCompatActivity {

    Button buttonwatchlogin,buttonmemberlogin;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawyerlayout;
     androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        buttonwatchlogin = (Button) findViewById(R.id.button2);
        buttonmemberlogin = (Button) findViewById(R.id.button1);

        //Login Button activity
      buttonwatchlogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent in =new Intent(dashboard.this,loginpagewatch.class);
              startActivity(in);
          }
      });

        buttonmemberlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(dashboard.this,memberloginpage.class);
                startActivity(in);
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

                }
                return true;
            }
        });



    }
}