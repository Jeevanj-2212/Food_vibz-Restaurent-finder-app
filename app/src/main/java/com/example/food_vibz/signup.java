package com.example.food_vibz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    Button signup;
    EditText name,email,password,passvali;
    FirebaseAuth fauth;
    TextView userin;
    ProgressBar progressBar;
    FirebaseFirestore fstore;
    String userid;
    String ex="^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();
        name=findViewById(R.id.fullname);
        email=findViewById(R.id.emailidup);
        password=findViewById(R.id.passwordup);
        progressBar=findViewById(R.id.progressBar);
        fauth=FirebaseAuth.getInstance();
        fstore=FirebaseFirestore.getInstance();


        if(fauth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),search.class));
            finish();
        }
        userin=findViewById(R.id.userin);
        userin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userinintent=new Intent(signup.this,signin.class);
                startActivity(userinintent);
            }
        });

        signup=findViewById(R.id.signupbtn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                String Name=name.getText().toString().trim();
                if(TextUtils.isEmpty(Name))
                {
                    name.setError("Name is required");
                    return;
                }
                if(TextUtils.isEmpty(Email))
                {
                    email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    password.setError("Password is required");
                    return;
                }

                if(validatepass(Password)==true)
                {
                    fauth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                                userid=fauth.getCurrentUser().getUid();
                                DocumentReference documentre=fstore.collection("Users").document(userid);
                                Map<String,Object>user=new HashMap<>();
                                user.put("Fname",Name);
                                user.put("Email",Email);
                                user.put("Password",Password);
                                documentre.set(user);
                                startActivity(new Intent(getApplicationContext(),search.class));
                                progressBar.setVisibility(View.VISIBLE);
                            }
                            else
                            {
                                Toast.makeText(signup.this,"Error!!!"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    return;
                }
                else
                {
                    Toast.makeText(signup.this,"Invalid Password Please Enter the password in proper Format",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean validatepass(String Password) {
        Pattern pattern=Pattern.compile(ex);
        Matcher matcher=pattern.matcher(Password);
        return matcher.matches();
    }


}