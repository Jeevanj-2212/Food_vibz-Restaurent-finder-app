package com.example.food_vibz;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Menu extends AppCompatActivity {
    private TextView idliTextView, vegThaliTextView, teaTextView,masalaTextView,bunsTextView,gobiTextView,palavTextView,pooriTextView;
    private SimpleDateFormat timeFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        idliTextView = findViewById(R.id.idliTextView);
        vegThaliTextView = findViewById(R.id.vegThali1TextView);
        teaTextView = findViewById(R.id.teaTextView);
        masalaTextView =findViewById(R.id.masalaTextView);
        bunsTextView =findViewById(R.id.bunsTextView);
        gobiTextView =findViewById(R.id.gobiTextView);
        palavTextView =findViewById(R.id.palavTextView);
        pooriTextView =findViewById(R.id.pooriTextView);


        timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        updateColors();
    }

    private void updateColors() {
        Calendar calendar = Calendar.getInstance();
        String currentTime = timeFormat.format(calendar.getTime());

        String morningStartTime = "06:00";
        String morningEndTime = "12:00";
        String afternoonStartTime = "12:00";
        String afternoonEndTime = "15:30";
        String eveningStartTime = "15:30";
        String eveningEndTime = "19:00";
        String nightStartTime = "19:00";
        String nightEndTime = "21:30";

        if (currentTime.compareTo(morningStartTime) >= 0 && currentTime.compareTo(morningEndTime) < 0) {
            // Morning (6:00 to 11:59)
            idliTextView.setTextColor(Color.GREEN);
            vegThaliTextView.setTextColor(Color.RED);
            teaTextView.setTextColor(Color.GREEN);
            masalaTextView.setTextColor(Color.GREEN);
            bunsTextView.setTextColor(Color.GREEN);
            gobiTextView.setTextColor(Color.RED);
            palavTextView.setTextColor(Color.GREEN);
            pooriTextView.setTextColor(Color.GREEN);
        } else if (currentTime.compareTo(afternoonStartTime) >= 0 && currentTime.compareTo(afternoonEndTime) < 0) {
            // Afternoon (12:00 to 15:29)
            idliTextView.setTextColor(Color.RED);
            vegThaliTextView.setTextColor(Color.GREEN);
            teaTextView.setTextColor(Color.GREEN);
            masalaTextView.setTextColor(Color.RED);
            bunsTextView.setTextColor(Color.RED);
            gobiTextView.setTextColor(Color.GREEN);
            palavTextView.setTextColor(Color.RED);
            pooriTextView.setTextColor(Color.RED);
        } else if (currentTime.compareTo(eveningStartTime) >= 0 && currentTime.compareTo(eveningEndTime) < 0) {
            // Evening (15:30 to 18:59)
            idliTextView.setTextColor(Color.GREEN);
            vegThaliTextView.setTextColor(Color.RED);
            teaTextView.setTextColor(Color.GREEN);
            masalaTextView.setTextColor(Color.GREEN);
            bunsTextView.setTextColor(Color.GREEN);
            gobiTextView.setTextColor(Color.RED);
            palavTextView.setTextColor(Color.RED);
            pooriTextView.setTextColor(Color.GREEN);
        }
        else if(currentTime.compareTo(nightStartTime) >=0 && currentTime.compareTo(nightEndTime) <0){
            idliTextView.setTextColor(Color.RED);
            vegThaliTextView.setTextColor(Color.GREEN);
            teaTextView.setTextColor(Color.RED);
            masalaTextView.setTextColor(Color.RED);
            bunsTextView.setTextColor(Color.RED);
            gobiTextView.setTextColor(Color.GREEN);
            palavTextView.setTextColor(Color.RED);
            pooriTextView.setTextColor(Color.GREEN);
        }
    }
}
