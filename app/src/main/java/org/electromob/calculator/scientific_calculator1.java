package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;

public class scientific_calculator1 extends AppCompatActivity {

    Button pow,pow_y,sin,cos,tan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator1);

        pow = findViewById(R.id.button9);
        pow.setText(Html.fromHtml("e<sup>x</sup>"));

        pow_y = findViewById(R.id.button36);
        pow_y.setText(Html.fromHtml("x<sup>y</sup>"));

        sin = findViewById(R.id.button32);
        sin.setText(Html.fromHtml("sin<sup>-1</sup>"));

        cos = findViewById(R.id.button34);
        cos.setText(Html.fromHtml("cos<sup>-1</sup>"));

        tan = findViewById(R.id.button35);
        tan.setText(Html.fromHtml("tan<sup>-1</sup>"));

    }
}
