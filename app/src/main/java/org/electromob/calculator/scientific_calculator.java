package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;

public class scientific_calculator extends AppCompatActivity {

    Button ten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        ten = findViewById(R.id.button9);
        ten.setText(Html.fromHtml("10<sup>x</sup>"));
    }
}
