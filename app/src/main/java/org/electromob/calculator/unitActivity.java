package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class unitActivity extends AppCompatActivity {
    private Spinner fromunit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        Spinner fromunit = findViewById(R.id.fromunit);
        String[] mtrarray= new String[]{"centimeter","meter","decimeter","nanometer","millimeter"};

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,mtrarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromunit.setAdapter(adapter);
    }
}