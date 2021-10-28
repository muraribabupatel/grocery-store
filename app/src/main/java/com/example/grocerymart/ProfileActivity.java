package com.example.grocerymart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
private ImageView imageView;
private TextView name_edt,email_edt,mobile_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView=findViewById(R.id.backArrow);
        name_edt=findViewById(R.id.user_name);
        email_edt=findViewById(R.id.user_email);
        mobile_edt=findViewById(R.id.user_phone);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        SharedPreferences sharedPreferences = getSharedPreferences("Grocery Mart", MODE_PRIVATE);
        String fName = sharedPreferences.getString("name","");
        String fEmail = sharedPreferences.getString("email","");
        String fMobile = sharedPreferences.getString("mobile","");

        name_edt.setText(fName);
        email_edt.setText(fEmail);
        mobile_edt.setText(fMobile);

    }
}