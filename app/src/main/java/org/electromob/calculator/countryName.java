package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

public class countryName extends AppCompatActivity {
    private AutoCompleteTextView countryname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.activity_country_name);
        AutoCompleteTextView countryname=findViewById(R.id.countryname);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,countries);
        countryname.setAdapter(adapter);
    }
    private static final String[] countries = new String[]{"Afghanisthan","Bangladesh","China","Egypt",
            "Finland","France","Germany","India","japan","United states","United Kingdom"};
}