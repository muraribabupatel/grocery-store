package com.example.grocerymart.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.grocerymart.Fragment.FruitsFragment;
import com.example.grocerymart.Fragment.VegetablesFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){

            case 1:
                return new FruitsFragment();

            case 2:
                return new VegetablesFragment();

        }
return new VegetablesFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
