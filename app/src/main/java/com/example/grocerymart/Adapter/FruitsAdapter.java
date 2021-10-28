package com.example.grocerymart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.grocerymart.HomeActivity;
import com.example.grocerymart.Model.Fruits;
import com.example.grocerymart.Model.Vegetable;
import com.example.grocerymart.R;

import java.util.ArrayList;
import java.util.List;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.FruitsHolder> {
    private Context context;
    List<Fruits> fruitsList;
    private  List<Fruits> selectedFruitsList = new ArrayList<>();
    public FruitsAdapter(Context mContext,List<Fruits> fruitsList) {
        this.fruitsList=fruitsList;
        this.context=mContext;
    }

    @NonNull
    @Override
    public FruitsAdapter.FruitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_fruits,parent,false);
        return new FruitsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsHolder holder, int position) {
        Fruits fruits=fruitsList.get(position);
        holder.name.setText(fruits.getfName());
        holder.price.setText(String.valueOf(fruits.getfPrice()));
        holder.imageView.setImageResource(Integer.parseInt(String.valueOf(fruits.getImageUrl())));
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "added to cart", Toast.LENGTH_SHORT).show();
                //selectedVegetableList.add(vegetableList.get(holder.getAdapterPosition())));
                ((HomeActivity)context).updateQty(1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    public class FruitsHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView price,name,addBtn;
        public FruitsHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.wine_name);
            price=itemView.findViewById(R.id.wine_price);
            imageView=itemView.findViewById(R.id.image_wine);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}
