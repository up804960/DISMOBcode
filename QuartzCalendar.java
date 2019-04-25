package com.example.up804960dismob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class QuartzCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quartz_calendar);
    }

    public static DecimalFormat df2 = new DecimalFormat(".##");

    public void startCalendar(View view) {
        EditText cInput = findViewById(R.id.calenderInput);
        TextView days = findViewById(R.id.daySpace);
        TextView cash = findViewById(R.id.paySpace);
        TextView errorBig = findViewById(R.id.errorTooBig);
        int quartzTarget = 0;
        if (cInput.getText().toString().equals("")) {
        }
        else if (Long.parseLong(cInput.getText().toString()) > 99999) {
            errorBig.setText("Provided number is too big!\nplease enter something smaller");
        }
        else {
            quartzTarget = Integer.parseInt(cInput.getText().toString());
            errorBig.setText("");
        }
        int dayTarget = dayCounter(quartzTarget);
        double cashTarget = cashCounter(quartzTarget);
        days.setText(String.format("Number of Days to Target: %s", String.valueOf(dayTarget)));
        cash.setText(String.format("Equivalent Cost of Quartz: $%s", df2.format(cashTarget)));
    }

    public int dayCounter(int target) {
        int simQuartz = 0;
        int simDay = 1;
        int totalDays = 1;
        while (simQuartz < target) {
            if (simDay == 1) {
                simDay++;
                simQuartz = simQuartz + 2;
            }
            else if ((simDay % 2) != 0) {
                simDay++;
            }
            else if (simDay == 2 || simDay == 4) {
                simQuartz++;
                simDay++;
            }
            else if (simDay == 6) {
                simQuartz = simQuartz + 2;
                simDay++;
            }
            if ((totalDays % 50) == 0 ) {
                simQuartz = simQuartz + 20;
            }
            totalDays++;
            if (simDay == 8) {
                simDay = 1;
            }
        }
        return totalDays-1;
    }

    public double cashCounter(int target) {
        double simCost = 0.00;
        int simQuartz = target;
        while (simQuartz != 0) {
            if ((simQuartz - 167) >= 0) {
                simCost = simCost + 79.99;
                simQuartz = simQuartz - 167;
            } else if ((simQuartz - 76) >= 0) {
                simCost = simCost + 39.99;
                simQuartz = simQuartz - 76;
            } else if ((simQuartz - 41) >= 0) {
                simCost = simCost + 23.99;
                simQuartz = simQuartz - 41;
            } else if ((simQuartz - 18) >= 0) {
                simCost = simCost + 11.99;
                simQuartz = simQuartz - 18;
            } else if ((simQuartz - 5) >= 0) {
                simCost = simCost + 3.99;
                simQuartz = simQuartz - 5;
            } else if ((simQuartz - 1) >= 0) {
                simCost = simCost + 0.99;
                simQuartz = simQuartz - 1;
            }
        }
        return simCost;
    }
}
