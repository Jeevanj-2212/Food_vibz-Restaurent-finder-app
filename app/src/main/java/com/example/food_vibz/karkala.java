package com.example.food_vibz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class karkala extends AppCompatActivity {
    TextView logoutmo,
            kateel,sagar,balaji,prakash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karkala);
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
        kateel=findViewById(R.id.kateel);
        kateel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), kateel.class));
            }
        });
        sagar=findViewById(R.id.sgkar);
        sagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), hotel_sagar.class));
            }
        });
        balaji=findViewById(R.id.balaji);
        balaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), prakash.class));
            }
        });
        prakash=findViewById(R.id.prakash);
        prakash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), balaji_inn.class));
            }
        });
    }
}