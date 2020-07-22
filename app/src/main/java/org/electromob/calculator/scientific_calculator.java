package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class scientific_calculator extends AppCompatActivity {

    Button ten,square,switchh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        ten = findViewById(R.id.button9);
        ten.setText(Html.fromHtml("10<sup>x</sup>"));

        square = findViewById(R.id.button36);
        square.setText(Html.fromHtml("x<sup>2</sup>"));

        switchh = findViewById(R.id.button6);
        switchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scientific_calculator1.class));
            }
        });
    }
}
