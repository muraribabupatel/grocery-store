package com.example.grocerymart.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grocerymart.Adapter.VegetableAdapter;
import com.example.grocerymart.Model.Vegetable;
import com.example.grocerymart.R;
import com.example.grocerymart.databinding.FragmentVegetablesBinding;

import java.util.ArrayList;
import java.util.List;


public class VegetablesFragment extends Fragment {
private FragmentVegetablesBinding binding;
private RecyclerView recyclerRV;
List<Vegetable> vegetableList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentVegetablesBinding.inflate(inflater,container,false);
        View root=binding.getRoot();

        recyclerRV=root.findViewById(R.id.recyclerView);
        vegetableList=new ArrayList<>();

        Vegetable veg=new Vegetable();
        veg.setImage(R.drawable.potato);
        veg.setName("Potato");
        veg.setPrice(50);
        vegetableList.add(veg);

        Vegetable veg1=new Vegetable();
        veg1.setImage(R.drawable.tomato);
        veg1.setName("Tomato");
        veg1.setPrice(80);
        vegetableList.add(veg1);

        Vegetable veg2=new Vegetable();
        veg2.setImage(R.drawable.garlic);
        veg2.setName("Garlic");
        veg2.setPrice(200);
        vegetableList.add(veg2);

        Vegetable veg3=new Vegetable();
        veg3.setImage(R.drawable.onion);
        veg3.setName("Onion");
        veg3.setPrice(80);
        vegetableList.add(veg3);

        Vegetable veg4=new Vegetable();
        veg4.setImage(R.drawable.greenchilli);
        veg4.setName("Green Chilli");
        veg4.setPrice(70);
        vegetableList.add(veg4);


        Vegetable veg5=new Vegetable();
        veg5.setImage(R.drawable.cabbage);
        veg5.setName("Cabbage");
        veg5.setPrice(50);
        vegetableList.add(veg5);

        Vegetable veg6=new Vegetable();
        veg6.setImage(R.drawable.cauliflower);
        veg6.setName("Cauliflower");
        veg6.setPrice(50);
        vegetableList.add(veg6);

        Vegetable veg7=new Vegetable();
        veg7.setImage(R.drawable.ladiesfinger);
        veg7.setName("Lady Finger");
        veg7.setPrice(40);
        vegetableList.add(veg7);

        Vegetable veg8=new Vegetable();
        veg8.setImage(R.drawable.beetroot);
        veg8.setName("Beet Root");
        veg8.setPrice(60);
        vegetableList.add(veg8);

        Vegetable veg9=new Vegetable();
        veg9.setImage(R.drawable.capsicum);
        veg9.setName("Capsicum");
        veg9.setPrice(180);
        vegetableList.add(veg9);

        Vegetable veg10=new Vegetable();
        veg10.setImage(R.drawable.brinjallong);
        veg10.setName("Brinjal Long");
        veg10.setPrice(70);
        vegetableList.add(veg10);

        Vegetable veg11=new Vegetable();
        veg11.setImage(R.drawable.cucumber);
        veg11.setName("Cucumber");
        veg11.setPrice(40);
        vegetableList.add(veg11);

        Vegetable veg12=new Vegetable();
        veg12.setImage(R.drawable.brocaly);
        veg12.setName("Brocaly");
        veg12.setPrice(80);
        vegetableList.add(veg12);

        Vegetable veg13=new Vegetable();
        veg13.setImage(R.drawable.carrot);
        veg13.setName("Carrot");
        veg13.setPrice(40);
        vegetableList.add(veg13);

        Vegetable veg14=new Vegetable();
        veg14.setImage(R.drawable.brinjalround);
        veg14.setName("Brinjal Round");
        veg14.setPrice(50);
        vegetableList.add(veg14);

        Vegetable veg15=new Vegetable();
        veg15.setImage(R.drawable.cucumber);
        veg15.setName("Cucumber");
        veg15.setPrice(60);
        vegetableList.add(veg15);

        Vegetable veg16=new Vegetable();
        veg16.setImage(R.drawable.coriander);
        veg16.setName("Coriander");
        veg16.setPrice(180);
        vegetableList.add(veg16);

        Vegetable veg17=new Vegetable();
        veg17.setImage(R.drawable.corn);
        veg17.setName("Corn");
        veg17.setPrice(50);
        vegetableList.add(veg17);

        Vegetable veg18=new Vegetable();
        veg18.setImage(R.drawable.spinach);
        veg18.setName("Spinach");
        veg18.setPrice(30);
        vegetableList.add(veg18);

        Vegetable veg19=new Vegetable();
        veg19.setImage(R.drawable.sweatpotato);
        veg19.setName("Sweet Potato");
        veg19.setPrice(100);
        vegetableList.add(veg19);

        Vegetable veg20=new Vegetable();
        veg20.setImage(R.drawable.mint);
        veg20.setName("Mint");
        veg20.setPrice(80);
        vegetableList.add(veg20);

        Vegetable veg21=new Vegetable();
        veg21.setImage(R.drawable.mushroom);
        veg21.setName("Mushroom");
        veg21.setPrice(240);
        vegetableList.add(veg21);


        Vegetable veg22=new Vegetable();
        veg22.setImage(R.drawable.zuchhini);
        veg22.setName("Zuchheni");
        veg22.setPrice(60);
        vegetableList.add(veg22);
        VegetableAdapter vegetableAdapter=new VegetableAdapter(getActivity(),vegetableList);
        recyclerRV.setHasFixedSize(true);
        recyclerRV.setLayoutManager(new GridLayoutManager(getContext(),2));

        recyclerRV.setAdapter(vegetableAdapter);


        return root;
    }
}