package com.example.up804960dismob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GachaSimulator extends AppCompatActivity {
    Random r = new Random();
    int quartzCost = 0;
    int servant4 = 0;
    int servant4RU = 0;
    int servant5 = 0;
    int servant5RU = 0;
    int essence5 = 0;
    int essence5RU = 0;

    public ArrayList<TextView> tenPull = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacha_simulator);
        Spinner selector = findViewById(R.id.bannerSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.banners, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selector.setAdapter(adapter);
        TextView multi00 = findViewById(R.id.result00);
        TextView multi01 = findViewById(R.id.result01);
        TextView multi02 = findViewById(R.id.result02);
        TextView multi03 = findViewById(R.id.result03);
        TextView multi04 = findViewById(R.id.result04);
        TextView multi05 = findViewById(R.id.result05);
        TextView multi06 = findViewById(R.id.result06);
        TextView multi07 = findViewById(R.id.result07);
        TextView multi08 = findViewById(R.id.result08);
        TextView multi09 = findViewById(R.id.result09);
        tenPull.add(multi00);
        tenPull.add(multi01);
        tenPull.add(multi02);
        tenPull.add(multi03);
        tenPull.add(multi04);
        tenPull.add(multi05);
        tenPull.add(multi06);
        tenPull.add(multi07);
        tenPull.add(multi08);
        tenPull.add(multi09);
        cleanUp();
    }

    public void cleanUp() {
        for (int i = 0; i < tenPull.size(); i++) {
            tenPull.get(i).setText("");
        }
        TextView singleSlot = findViewById(R.id.result10);
        singleSlot.setText("");
    }

    public void totalCount() {
        TextView fourStar = findViewById(R.id.svt4Total);
        TextView fourStarRate = findViewById(R.id.svt4RUTotal);
        TextView fiveStar = findViewById(R.id.svt5Total);
        TextView fiveStarRate = findViewById(R.id.svt5RUTotal);
        TextView fiveCE = findViewById(R.id.ce5Total);
        TextView fiveCERate = findViewById(R.id.ce5RUTotal);
        fourStar.setText(String.format("4 Star Servants: %s", String.valueOf(servant4)));
        fourStarRate.setText(String.format("4 Star Rate Up Servants: %s", String.valueOf(servant4RU)));
        fiveStar.setText(String.format("5 Star Servants: %s", String.valueOf(servant5)));
        fiveStarRate.setText(String.format("5 Star Rate Up Servants: %s", String.valueOf(servant5RU)));
        fiveCE.setText(String.format("5 Star Craft Essences: %s", String.valueOf(essence5)));
        fiveCERate.setText(String.format("5 Star Rate Up Craft Essences: %s", String.valueOf(essence5RU)));

    }

    public void resetCounter(View view) {
        TextView costText = findViewById(R.id.costText);
        quartzCost = 0;
        servant4 = 0;
        servant4RU = 0;
        servant5 = 0;
        servant5RU = 0;
        essence5 = 0;
        essence5RU = 0;
        cleanUp();
        costText.setText("0 SQ");
        TextView fourStar = findViewById(R.id.svt4Total);
        TextView fourStarRate = findViewById(R.id.svt4RUTotal);
        TextView fiveStar = findViewById(R.id.svt5Total);
        TextView fiveStarRate = findViewById(R.id.svt5RUTotal);
        TextView fiveCE = findViewById(R.id.ce5Total);
        TextView fiveCERate = findViewById(R.id.ce5RUTotal);
        fourStar.setText("4 Star Servants: 0");
        fourStarRate.setText("4 Star Rate Up Servants: 0");
        fiveStar.setText("5 Star Servants: 0");
        fiveStarRate.setText("5 Star Rate Up Servants: 0");
        fiveCE.setText("5 Star Craft Essences: 0");
        fiveCERate.setText("5 Star Rate Up Craft Essences: 0");

    }

    public void rollSingle(View view) {
        cleanUp();
        TextView singleSlot = findViewById(R.id.result10);
        TextView costText = findViewById(R.id.costText);
        singleSlot.setText(lootbox());
        quartzCost = quartzCost + 3;
        costText.setText(String.format("%s SQ", String.valueOf(quartzCost)));
        totalCount();
    }

    public void rollMulti(View view) {
        cleanUp();
        TextView costText = findViewById(R.id.costText);
        int fourStarCheck = 0;
        for (int i = 0; i < tenPull.size(); i++) {
            tenPull.get(i).setText(lootbox());
        }
        quartzCost = quartzCost + 30;
        costText.setText(String.format("%s SQ", String.valueOf(quartzCost)));
        totalCount();
    }

    public String lootbox() {
        int roll = (r.nextInt(100) + 1);

        if (roll <= 40) {
            return selectCraftEssenceCommon();
        }
        else if (roll <= 80) {
            return selectServantCommon();
        }
        else if (roll <= 92) {
            return selectCraftEssenceRare();
        }
        else if (roll <= 95){
            return selectServantRare();
        }
        else if (roll <= 99) {
            return selectCraftEssenceSuperRare();
        }
        else {
            return selectServantSuperRare();
        }
    }

    public String selectCraftEssenceCommon() {
        int ce3 = r.nextInt(40) + 1;
        if (ce3 <= 30) {
            return "Normal 3 Star CE";
        } else {
            return "Rate up 3 Star CE";
        }
    }

    public String selectCraftEssenceRare(){
        int ce4 = r.nextInt(12) + 1;
        if (ce4 <= 8) {
            return "Normal 4 Star CE";
        } else {
            return "Rate up 4 Star CE";
        }
    }

    public String selectCraftEssenceSuperRare(){
        int ce5 = r.nextInt(40) + 1;
        if (ce5 <= 30) {
            essence5++;
            return "Normal 5 Star CE";
        } else {
            essence5RU++;
            return "Rate up 5 Star CE";
        }
    }

    public String selectServantCommon(){
        int svt3 = r.nextInt(40) + 1;
        if (svt3 <= 36) {
            return "Normal 3 Star Servant";
        } else {
            return "Rate up 3 Star Servant";
        }
    }

    public String selectServantRare(){
        int svt4 = r.nextInt(30) + 1;
        if (svt4 <= 6){
            servant4++;
            return "Normal 4 Star Servant";
        } else {
            servant4RU++;
            return "Rate up 4 Star Servant";
        }
    }

    public String selectServantSuperRare(){
        int svt5 = r.nextInt(10) + 1;
        if (svt5 <= 3) {
            servant5++;
            return "Normal 5 Star Servant";
        } else {
            servant5RU++;
            return "Rate up 5 Star Servant";
        }
    }
}
