package com.example.food_vibz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class mangalore extends AppCompatActivity {
    TextView pabbas,ocean,machili,logoutma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangalore);
        getSupportActionBar().hide();
        logoutma=findViewById(R.id.logoutma);
        logoutma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),signin.class));
                finish();
            }
        });
        pabbas=findViewById(R.id.pabbas);
        pabbas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ideal.class));
            }
        });
        ocean=findViewById(R.id.ocean);
        ocean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ocean.class));
            }
        });
        machili=findViewById(R.id.machli);
        machili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),machili.class));
            }
        });


    }
}
