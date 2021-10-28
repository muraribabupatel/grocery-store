package com.example.grocerymart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
private ImageView imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView textA = findViewById(R.id.textA);
        TextView textB = findViewById(R.id.textB);
        TextView textC = findViewById(R.id.textC);
        TextView textD = findViewById(R.id.textD);
        TextView textE = findViewById(R.id.textE);
        ImageView backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textA.setText(Html.fromHtml("<b>GM –</b> \"Grocery Mart\" is a application based your own traditional sabji wala who brings to your door step high-quality fresh fruits and\n" +
                    " vegetables in wholesale rate. Now you can order your daily essential vegetables & fruits at convince of your house. ", Html.FROM_HTML_MODE_COMPACT));
        } else {
            textA.setText(Html.fromHtml("<b>GM –</b> \"Grocery Mart\" is a application based your own traditional sabji wala who brings to your door step high-quality fresh fruits and\n" +
                    " vegetables in wholesale rate. Now you can order your daily essential vegetables & fruits at convince of your house. "));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textE.setText(Html.fromHtml("<b>Awiskar Tech Team </b>", Html.FROM_HTML_MODE_COMPACT));
        } else {
            textE.setText(Html.fromHtml("<b>Awiskar Tech Team</b>"));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textB.setText(Html.fromHtml("<b>Mohit Vishal - </b> A thought leader & an innovator. He is a highly experienced professional and strategist from Vishakhapatnam who dare to leave his high paying job in Agriculture Tractor Finance Market & start his own dream venture. He is presently the Partner of NSB – Grocery Mart. ", Html.FROM_HTML_MODE_COMPACT));
        } else {
            textB.setText(Html.fromHtml("<b>Rohit Vishal - </b> A thought leader & an innovator. He is a highly experienced professional and strategist from Vishakhapatnam who dare to leave his high paying job in Agriculture Tractor Finance Market & start his own dream venture. He is presently the Partner of NSB – Grocery Mart. "));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textC.setText(Html.fromHtml("<b>A-  </b> An age old Vegetable Vender, who is providing vegetables supply services in 3 Star & 5 star hotels of Vishakhapatnam. He wants to extend the service to common household & bridge the gap of price differentiation. He is presently the Partner of NSB – Grocery Mart.", Html.FROM_HTML_MODE_COMPACT));
        } else {
            textC.setText(Html.fromHtml("<b>B- </b> An age old Vegetable Vender, who is providing vegetables supply services in 3 Star & 5 star hotels of Vishakhapatnam. He wants to extend the service to common household & bridge the gap of price differentiation. He is presently the Partner of NSB – Grocery Mart."));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textD.setText(Html.fromHtml("<b>C-</b> A big Wholesale Vegetable Vender in Mandor Mandi. He has a lecacy of supplying fresh vegetables with zero tolerance to bad quality. He is presently the Partner of Awiskar tech– Grocery Mart.", Html.FROM_HTML_MODE_COMPACT));
        } else {
            textD.setText(Html.fromHtml("<b>D-</b> A big Wholesale Vegetable Vender in Mandor Mandi. He has a lecacy of supplying fresh vegetables with zero tolerance to bad quality. He is presently the Partner of Awiskar tech – Grocery Mart."));
        }

        imageButton=findViewById(R.id.backBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}