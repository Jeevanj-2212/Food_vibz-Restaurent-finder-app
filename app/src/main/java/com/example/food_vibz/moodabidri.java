package com.example.food_vibz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class moodabidri extends AppCompatActivity {
    TextView logoutmo,padival,ballal,panch,sagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodabidri);
        getSupportActionBar().hide();
        logoutmo=findViewById(R.id.logoutmood);
        logoutmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),signin.class));
                finish();
            }
        });
        padival=findViewById(R.id.padi);
        padival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),padivals.class));
            }
        });
        ballal=findViewById(R.id.balall);
        ballal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ballal.class));
            }
        });
        panch=findViewById(R.id.pancha);
        panch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),pancha.class));
            }
        });
        sagar=findViewById(R.id.sagar);
        sagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),sagar.class));
            }
        });
    }
}