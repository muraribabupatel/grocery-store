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
import com.example.grocerymart.Model.Vegetable;
import com.example.grocerymart.R;

import java.util.ArrayList;
import java.util.List;

public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.VegetableHolder> {
    List<Vegetable> vegetableList;
    private Context context;
    private  List<Vegetable> selectedVegetableList = new ArrayList<>();
    public VegetableAdapter(Context mContext,List<Vegetable> vegetableList) {
        this.vegetableList=vegetableList;
        this.context =mContext;
    }


    @NonNull
    @Override
    public VegetableAdapter.VegetableHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_vegetable,parent,false);
       return new VegetableHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableHolder holder, int position) {
        Vegetable vegetable=vegetableList.get(position);
        holder.name.setText(vegetable.getName());
        holder.price.setText(String.valueOf(vegetable.getPrice()));
        holder.imageView.setImageResource(Integer.parseInt(String.valueOf(vegetable.getImage())));
        holder.add.setOnClickListener(new View.OnClickListener() {
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
        return vegetableList.size();
    }

    public class VegetableHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView price,name,add;

        public VegetableHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.wine_name);
            price=itemView.findViewById(R.id.wine_price);
            imageView=itemView.findViewById(R.id.image_wine);
            add=itemView.findViewById(R.id.addBtn);
        }
    }
}
