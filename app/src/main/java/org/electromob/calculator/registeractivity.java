package org.electromob.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registeractivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    private Button mregister;
    private EditText musername,memail,mpassword;
    private FirebaseAuth fAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase fStore;
    private DatabaseReference db;
    String mail,name;
    String uId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);

        fAuth = FirebaseAuth.getInstance();


        mregister= findViewById(R.id.button4);
        musername=findViewById(R.id.editText3);
        memail=findViewById(R.id.editText6);
        mpassword=findViewById(R.id.editText7);


        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),activity_main.class));
            finish();
        }

        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fStore = FirebaseDatabase.getInstance();
                db = fStore.getReference("users");
                mail=memail.getText().toString().trim();
                name=musername.getText().toString();
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
                        if(task.isSuccessful()) {
                            Toast.makeText(registeractivity.this, "user created", Toast.LENGTH_SHORT).show();
                            sendemail();
                        }else {
                            Toast.makeText(registeractivity.this,"Error:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private void sendemail() {
        firebaseUser = fAuth.getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        db = db.child(name);
                        Users userinfo;
                        userinfo = new Users(mail,name);
                        db.setValue(userinfo);
                        Toast.makeText(getApplicationContext(), "Successfully registered, verification mail has been sent", Toast.LENGTH_LONG).show();
                        fAuth.signOut();
                        finish();
                        startActivity(new Intent(getApplicationContext(), activity_welcome.class));
                        finish();
                    } else {
                        musername.setText(null);
                        memail.setText(null);
                        Toast.makeText(getApplicationContext(), "Verification mail failed to send, try after sometime", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}
