package com.example.food_vibz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class udupi extends AppCompatActivity {
    TextView logoutmo,shanti,anu,kidi,wood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udupi);
        getSupportActionBar().hide();
        logoutmo=findViewById(R.id.logoutmood);
        logoutmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), signin.class));
                finish();
            }
        });
        shanti=findViewById(R.id.shanti);
        shanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), shanti.class));
            }
        });
        anu=findViewById(R.id.anu);
        anu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), anu.class));
            }
        });
        kidi=findViewById(R.id.kidi);
        kidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), kidi.class));
            }
        });
        wood=findViewById(R.id.wood);
        wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), wood.class));
            }
        });
    }
}