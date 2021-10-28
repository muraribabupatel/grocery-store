package com.example.grocerymart.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grocerymart.Adapter.FruitsAdapter;
import com.example.grocerymart.Model.Fruits;
import com.example.grocerymart.R;
import com.example.grocerymart.databinding.FragmentFruitsBinding;

import java.util.ArrayList;
import java.util.List;


public class FruitsFragment extends Fragment {

private FragmentFruitsBinding binding;
private RecyclerView recyclerView;
List<Fruits> fruitsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this
        binding=FragmentFruitsBinding.inflate(inflater,container,false);
        View root=binding.getRoot();

        recyclerView=root.findViewById(R.id.recyclerViewRV);
        fruitsList=new ArrayList<>();
        Fruits f=new Fruits();
        f.setfName("apple");
        f.setfPrice(199);
        f.setImageUrl(R.drawable.apple);
        fruitsList.add(f);

        Fruits f1=new Fruits();
        f1.setfName("grapes");
        f1.setfPrice(259);
        f1.setImageUrl(R.drawable.grapes);
        fruitsList.add(f1);

        Fruits f2=new Fruits();
        f2.setfName("Banana");
        f2.setfPrice(99);
        f2.setImageUrl(R.drawable.banana);
        fruitsList.add(f2);

        Fruits f3=new Fruits();
        f3.setfName("Orange");
        f3.setfPrice(59);
        f3.setImageUrl(R.drawable.lime);
        fruitsList.add(f3);

        Fruits f4=new Fruits();
        f4.setfName("Papaya");
        f4.setfPrice(80);
        f4.setImageUrl(R.drawable.papaya);
        fruitsList.add(f4);

        Fruits f5=new Fruits();
        f5.setfName("Mango");
        f5.setfPrice(100);
        f5.setImageUrl(R.drawable.mango);
        fruitsList.add(f5);

        Fruits f6=new Fruits();
        f6.setfName("Green Apple");
        f6.setfPrice(200);
        f6.setImageUrl(R.drawable.greenapple);
        fruitsList.add(f6);

        Fruits f7=new Fruits();
        f7.setfName("Green Grapes");
        f7.setfPrice(80);
        f7.setImageUrl(R.drawable.greengrapes);
        fruitsList.add(f7);

        Fruits f8=new Fruits();
        f8.setfName("BlackBerry");
        f8.setfPrice(150);
        f8.setImageUrl(R.drawable.blackberry);
        fruitsList.add(f8);

        Fruits f9=new Fruits();
        f9.setfName("Guava");
        f9.setfPrice(90);
        f9.setImageUrl(R.drawable.guava);
        fruitsList.add(f9);

        Fruits f10=new Fruits();
        f10.setfName("Kiwi");
        f10.setfPrice(500);
        f10.setImageUrl(R.drawable.kiwi);
        fruitsList.add(f10);

        Fruits f11=new Fruits();
        f11.setfName("Pine Apple");
        f11.setfPrice(160);
        f11.setImageUrl(R.drawable.pineapple);
        fruitsList.add(f11);

        Fruits f12=new Fruits();
        f12.setfName("Plum");
        f12.setfPrice(180);
        f12.setImageUrl(R.drawable.plum);
        fruitsList.add(f12);

        Fruits f13=new Fruits();
        f13.setfName("Pears");
        f13.setfPrice(85);
        f13.setImageUrl(R.drawable.pear);
        fruitsList.add(f13);

        Fruits f14=new Fruits();
        f14.setfName("Water Melon");
        f14.setfPrice(30);
        f14.setImageUrl(R.drawable.watermelon);
        fruitsList.add(f14);

        Fruits f15=new Fruits();
        f15.setfName("Temarind");
        f15.setfPrice(140);
        f15.setImageUrl(R.drawable.tamarind);
        fruitsList.add(f3);

        Fruits f16=new Fruits();
        f16.setfName("Coconut Water");
        f16.setfPrice(60);
        f16.setImageUrl(R.drawable.coconut);
        fruitsList.add(f16);


        Fruits f17=new Fruits();
        f17.setfName("Pomogrante");
        f17.setfPrice(200);
        f17.setImageUrl(R.drawable.pomegranet);
        fruitsList.add(f17);
        FruitsAdapter fruitsAdapter=new FruitsAdapter(getActivity(),fruitsList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(fruitsAdapter);




        return root;
    }
}