package com.example.grocerymart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

public class Main2Activity extends AppCompatActivity {
    private TextView forgetBtn, signInBtn;
    private EditText email, password;
    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private FirebaseAuth mAuth;
    private TextView noAccount;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        signInBtn = findViewById(R.id.signin);
        email = findViewById(R.id.email_edt);
        password = findViewById(R.id.passEdt);
        forgetBtn = findViewById(R.id.forgotPassBtn);
        noAccount = findViewById(R.id.no_account);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
        mAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Logging please wait....");
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }

        //go to forget activity

        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
                finish();

            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkEmailAndPassword();
            }
        });

    }

    //check email and password
    private void checkEmailAndPassword() {
        if (email.getText().toString().matches(emailPattern)) {
            if (password.length() >= 8) {
                dialog.show();
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            SharedPreferences sharedPref = getSharedPreferences("Grocery Mart", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("email",email.getText().toString());
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            String error = task.getException().getMessage();
                            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                            dialog.hide();
                        }
                    }
                });
            }


        } else {
            Toast.makeText(Main2Activity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }
        //else {
        //Toast.makeText(LoginActivity.this, "Incorrect email or passowrd", Toast.LENGTH_SHORT).show();


    }
}
