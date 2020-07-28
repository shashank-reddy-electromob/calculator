package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_main extends AppCompatActivity {

    private ImageView menu;
    private CardView scancard;
    private CardView calcicard;
    private CardView currencycard;
    private CardView unitcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView menu=findViewById(R.id.menu);
        CardView scancard = findViewById(R.id.scancard);
        CardView calcicard = findViewById(R.id.calcicard);
        CardView currencycard = findViewById(R.id.currencycard);
        CardView unitcard = findViewById(R.id.unitcard);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),profileActivity.class));
            }
        });

        scancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scanActivity.class));
            }
        });

        calcicard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scientific_calculator.class));
            }
        });

        currencycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),currencyActivity.class));
            }
        });

        unitcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),unitActivity.class));
            }
        });
    }
}
