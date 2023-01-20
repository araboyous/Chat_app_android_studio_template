package com.example.supptic_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notification extends AppCompatActivity {
    BottomNavigationView btnnav;
    RecyclerView recyclerview;
    String s1[], s2[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerview = findViewById(R.id.notrec);

        s1= getResources().getStringArray(R.array.Publication);
        s2= getResources().getStringArray(R.array.temps);
        Adapnotify myadap=new Adapnotify(this,s1,s2);
        recyclerview.setAdapter(myadap);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


        btnnav=findViewById(R.id.botnav);
        btnnav.setSelectedItemId(R.id.bot3);
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