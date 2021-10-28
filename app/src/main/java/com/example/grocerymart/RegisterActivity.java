package com.example.grocerymart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText name,email,password,cpassword,mobile;
    private TextView signInTxt,log;

    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private FirebaseAuth mAuth;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.nameEdt);
        email=findViewById(R.id.emailEdt);
        mobile=findViewById(R.id.mobileEdt);
        password=findViewById(R.id.passEdt);
        cpassword=findViewById(R.id.confirm_passEdt);
        log=findViewById(R.id.login);
        signInTxt=findViewById(R.id.signin);

        mAuth=FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("We're creating new account...");
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            }
        });

        signInTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName=name.getText().toString().trim();
                String fEmail=email.getText().toString().trim();
                String fMobile=mobile.getText().toString().trim();
                String fPassword=password.getText().toString().trim();
                String fCpasword=cpassword.getText().toString().trim();
                if (TextUtils.isEmpty(fName)) {
                    Toast.makeText(RegisterActivity.this, "Enter Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fEmail)){
                    Toast.makeText(RegisterActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fMobile)){
                    Toast.makeText(RegisterActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fPassword)){
                    Toast.makeText(RegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fCpasword)){
                    Toast.makeText(RegisterActivity.this, "Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                checkEmailAndPassword();
            }
        });


    }

    private void checkEmailAndPassword() {

        if (email.getText().toString().matches(emailPattern));{
            if (password.getText().toString().equals(cpassword.getText().toString())){
                dialog.show();
                mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Intent i=new Intent(getApplicationContext(), HomeActivity.class);
                            String fName=name.getText().toString().trim();
                            String fEmail=email.getText().toString().trim();
                            String fMobile=mobile.getText().toString().trim();
                            SharedPreferences sharedPref = getSharedPreferences("Grocery Mart", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("name", fName);
                            editor.putString("email",fEmail);
                            editor.putString("mobile",fMobile);
                            editor.apply();
                            startActivity(i);
                            finish();

                        }else {
                            String error=task.getException().getMessage();
                            Toast.makeText(getApplicationContext(),error, Toast.LENGTH_SHORT).show();
                            dialog.hide();
                        }
                    }

                });

            }else {
                cpassword.setError("Password doesn't matched!");
            }

        }

    }
}
