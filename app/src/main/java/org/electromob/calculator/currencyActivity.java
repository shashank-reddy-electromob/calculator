package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class currencyActivity extends AppCompatActivity {
    private TextView fromCountry;
    private ImageView dropdown1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        TextView fromCountry=findViewById(R.id.fromcountry);
        ImageView dropdown1=findViewById(R.id.drop1);

        fromCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( currencyActivity.this , countryName.class);
                startActivity(intent);
            }
        });
        dropdown1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( currencyActivity.this , countryName.class);
                startActivity(intent);
            }
        });
    }
}