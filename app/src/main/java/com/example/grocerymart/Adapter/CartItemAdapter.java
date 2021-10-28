package com.example.grocerymart.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartViewHolder>{

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemAdapter.CartViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
