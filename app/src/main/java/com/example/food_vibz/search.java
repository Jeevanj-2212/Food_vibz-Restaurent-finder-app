package com.example.food_vibz;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class search extends AppCompatActivity {
    TextView logouts;
    Button moodabidri,mang,kar,udp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();
        logouts=findViewById(R.id.logoutbtn);
        logouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),signin.class));
                finish();
            }
        });
        moodabidri=findViewById(R.id.mbtn);
        moodabidri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),moodabidri.class));
            }
        });
        mang=findViewById(R.id.mabtn);
        mang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),mangalore.class));
            }
        });
        kar=findViewById(R.id.kartn);
        kar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),karkala.class));
            }
        });
        udp=findViewById(R.id.udbtn);
        udp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),udupi.class));
            }
        });

    }
}