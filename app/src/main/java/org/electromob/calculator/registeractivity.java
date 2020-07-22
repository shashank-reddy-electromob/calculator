package org.electromob.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registeractivity extends AppCompatActivity {

    private Button mregister;
    private EditText musername,memail,mpassword;
    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        fAuth = FirebaseAuth.getInstance();
        Button mregister= findViewById(R.id.button4);
        final EditText musername=findViewById(R.id.editText3);
        final EditText memail=findViewById(R.id.editText6);
        final EditText mpassword=findViewById(R.id.editText7);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),activity_main.class));
            finish();
        }

        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=memail.getText().toString().trim();
                String name=musername.getText().toString().trim();
                String pass=mpassword.getText().toString().trim();

                if(TextUtils.isEmpty(mail)){
                    memail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    musername.setError("username is required");
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
                fAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(registeractivity.this,"user created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),activity_main.class));
                        }else {
                            Toast.makeText(registeractivity.this,"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
