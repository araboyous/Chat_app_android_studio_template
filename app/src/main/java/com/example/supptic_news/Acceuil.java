package com.example.supptic_news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Acceuil extends AppCompatActivity {
    RecyclerView recyclerview;
    String s1[], s2[];
    int images[] = {R.drawable.students, R.drawable.mark,
            R.drawable.students, R.drawable.logo, R.drawable.students,
            R.drawable.logo, R.drawable.students, R.drawable.logo};
    BottomNavigationView btnnav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        recyclerview = findViewById(R.id.fuwer);

        s1= getResources().getStringArray(R.array.produit);
        s2= getResources().getStringArray(R.array.description);

        Adapter myadapter = new Adapter(this, s1, s2,images);
        recyclerview.setAdapter(myadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));





        btnnav=findViewById(R.id.botnav);
        btnnav.setSelectedItemId(R.id.bot1);
        btnnav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.bot1:
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