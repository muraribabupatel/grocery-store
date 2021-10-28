package com.example.grocerymart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    private EditText emailTxt;
    private TextView resetBtn,back;
    private ProgressDialog dialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        emailTxt=findViewById(R.id.email_forget);
        resetBtn=findViewById(R.id.reset);
        back=findViewById(R.id.back);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait...");
        mAuth=FirebaseAuth.getInstance();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });


        //reset password with email

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                mAuth.sendPasswordResetEmail(emailTxt.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull  Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(ForgetPassword.this, "Sent successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                            finish();
                        }
                        else {
                            String error=task.getException().getMessage();
                            Toast.makeText(ForgetPassword.this,error, Toast.LENGTH_SHORT).show();
                            dialog.hide();
                        }
                    }
                });
            }
        });

    }
}