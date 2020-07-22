package org.electromob.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginactivity extends AppCompatActivity {

    private EditText memail,mpassword;
    private Button login;
    TextView forgot;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        final EditText memail = findViewById(R.id.editText);
        final EditText mpassword = findViewById(R.id.editText2);

        TextView forgot = findViewById(R.id.textView16);

        Button login = findViewById(R.id.loginButton);

        fAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail=memail.getText().toString().trim();
                String pass=mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mpassword.setError("password is required");
                    return;
                }
                if(pass.length()<6){
                    mpassword.setError("password must be 6 letters");
                    return;
                }
                fAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),activity_main.class));
                            Toast.makeText(loginactivity.this,"Login succesful",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(loginactivity.this,"Eror:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),otp.class));
            }
        });
    }
}
