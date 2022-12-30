package com.example.supptic_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Acceuil extends AppCompatActivity {
    RecyclerView recyclerview;
    String s1[], s2[];
    int images[] = {R.drawable.students, R.drawable.logo,
            R.drawable.students, R.drawable.logo, R.drawable.students,
            R.drawable.logo, R.drawable.students, R.drawable.logo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        recyclerview = findViewById(R.id.fuwer);

        s1= getResources().getStringArray(R.array.produit);
        s2= getResources().getStringArray(R.array.description);

        Adapter myadapter = new Adapter(this, s1, s2, images);
        recyclerview.setAdapter(myadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}