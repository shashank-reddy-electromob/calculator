package org.electromob.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class scientific_calculator extends AppCompatActivity {

    Button ten,square,switchh;
    Float val1,val2;
    Boolean add,sub,mul,div;
    TextView input , output;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,button_dot;
    Button button_add , button_sub , button_mul , button_div , button_open , button_close , button_plus , button_equal , button_per , button_del;
    Button square_root ;
    private String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        input = findViewById(R.id.textView13);
        output = findViewById(R.id.textView14);
        button0 = findViewById(R.id.button13);
        button1 = findViewById(R.id.button17);
        button2 = findViewById(R.id.button18);
        button3 = findViewById(R.id.button19);
        button4 = findViewById(R.id.button22);
        button5 = findViewById(R.id.button23);
        button6 = findViewById(R.id.button24);
        button7 = findViewById(R.id.button27);
        button8 = findViewById(R.id.button28);
        button9 = findViewById(R.id.button29);
        button_dot = findViewById(R.id.button12);
        button_add = findViewById(R.id.button20);
        button_sub = findViewById(R.id.button21);
        button_mul = findViewById(R.id.button25);
        button_div = findViewById(R.id.button26);
        button_open = findViewById(R.id.button30);
        button_close = findViewById(R.id.button31);
        button_plus = findViewById(R.id.button14);
        button_equal = findViewById(R.id.button16);
        button_per = findViewById(R.id.button15);
        button_del = findViewById(R.id.button7);
        square_root = findViewById(R.id.button37);

        ten = findViewById(R.id.button9);
        ten.setText(Html.fromHtml("10<sup>x</sup>"));

        square = findViewById(R.id.button36);
        square.setText(Html.fromHtml("x<sup>2</sup>"));

        Button switchh = findViewById(R.id.button6);
        switchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),scientific_calculator1.class));
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"9");
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+".");
            }
        });
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"(");
            }
        });
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+")");
            }
        });
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input==null){
                    input.setText("");
                }
                else {
                    val1 = Float.parseFloat(String.valueOf(input.getText()));
                    add = true;
                    input.setText(null);
                }
            }
        });
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input==null){
                    input.setText("");
                }
                else {
                    val1 = Float.parseFloat(String.valueOf(input.getText()));
                    sub = true;
                    input.setText(null);
                }
            }
        });
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input==null){
                    input.setText("");
                }
                else {
                    val1 = Float.parseFloat(String.valueOf(input.getText()));
                    mul = true;
                    input.setText(null);
                }
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input==null){
                    input.setText("");
                }
                else {
                    val1 = Float.parseFloat(String.valueOf(input.getText()));
                    div = true;
                    input.setText(null);
                }
            }
        });
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2 = Float.parseFloat(String.valueOf(input.getText()));
                input.setText(null);
                if(add){
                    output.setText(val1 + val2 + "" );
                    add = false;
                }
                else if(sub){
                    output.setText(val1 - val2 + "");
                    sub = false;
                }
                else if(mul){
                    output.setText(val1 * val2 + "");
                    mul = false;
                }
                else if(div){
                    output.setText(val1 / val2 + "");
                    div = false;
                }
            }
        });
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length()!=0){
                    String s=input.getText().toString();
                    char[] arr =s.toCharArray();
                    if(arr[0]=='-')
                        input.setText(s.substring(1,s.length()));
                    else
                        input.setText("-"+s);
                }
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length()!=0){
                    text = input.getText().toString();
                    input.setText("(" + text + ")^2");

                }
            }
        });

        square_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        
    }
}
