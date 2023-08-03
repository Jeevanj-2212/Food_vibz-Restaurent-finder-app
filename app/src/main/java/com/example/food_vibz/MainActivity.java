package com.example.food_vibz;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Thread thread=new Thread(){
            public void run()
            {
                try{
                    sleep(3000);

                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent = new Intent(MainActivity.this, signin.class);
                    startActivity(intent);

                }
            }

        };thread.start();

    }
}