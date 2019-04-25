package com.example.up804960dismob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoGachaSim (View view) {
        Intent intentGacha = new Intent(this, GachaSimulator.class);
        startActivity(intentGacha);
    }

    public void gotoCalendar (View view) {
        Intent intentQuartz = new Intent (this, QuartzCalendar.class);
        startActivity(intentQuartz);
    }
}
