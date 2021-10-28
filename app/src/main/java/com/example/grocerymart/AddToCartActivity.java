package com.example.grocerymart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.grocerymart.Adapter.CartItemAdapter;

public class AddToCartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
private ImageButton imageButton,address;
private TextView cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        imageButton=findViewById(R.id.back_arrow);
        recyclerView=findViewById(R.id.recyclerRV);
        cart=findViewById(R.id.addToCart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
       address=findViewById(R.id.add_address);

       //adapter

       CartItemAdapter cartItemAdapter=new CartItemAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(cartItemAdapter);






       address.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(getApplicationContext(),AddressActivity.class));
           }
       });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}