package com.example.food_vibz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    TextView userup;
    Button login;
    FirebaseAuth fauth;
    EditText emailid,inpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();
        login=findViewById(R.id.signinbtn);
        fauth= FirebaseAuth.getInstance();
        emailid=findViewById(R.id.emailidin);
        inpass=findViewById(R.id.passwordin);
        userup=findViewById(R.id.userup);
        if(fauth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),search.class));
            finish();
        }
        userup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userupintent=new Intent(signin.this,signup.class);
                startActivity(userupintent);
            }

        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=emailid.getText().toString().trim();
                String Password=inpass.getText().toString().trim();
                if(TextUtils.isEmpty(Email))
                {
                    emailid.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    inpass.setError("Password is required");
                    return;
                }
                fauth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signin.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),search.class));
                        }
                        else
                        {
                            Toast.makeText(signin.this,"Error!!!"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
