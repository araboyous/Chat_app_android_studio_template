package com.example.supptic_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Monnavputall extends AppCompatActivity {

    BottomNavigationView btnnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monnavputall);
        btnnav=findViewById(R.id.botnav);
        btnnav.setSelectedItemId(R.id.bot1);
        btnnav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                       switch (item.getItemId()){
                           case R.id.bot1:
                               startActivity(new Intent(getApplicationContext(),Acceuil.class));
                               overridePendingTransition(0 ,0);
                               return true;

                           case R.id.bot2:
                               startActivity(new Intent(getApplicationContext(),Storage.class));
                               overridePendingTransition(0 ,0);
                               return true;


                           case R.id.bot3:
                               startActivity(new Intent(getApplicationContext(),Notification.class));
                               overridePendingTransition(0 ,0);
                               return true;
                           case R.id.bot4:
                               startActivity(new Intent(getApplicationContext(),Modifier_compte.class));
                               overridePendingTransition(0 ,0);
                               return true;

                       }
                       return false;
                    }
                }
        );


    }
}