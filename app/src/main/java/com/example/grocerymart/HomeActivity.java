package com.example.grocerymart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerymart.Adapter.FragmentAdapter;
import com.example.grocerymart.Adapter.SliderAdapter;
import com.example.grocerymart.Model.SliderData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
public class HomeActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    ImageView cartIcon;
    private ProgressDialog dialog;
    DrawerLayout drawer;
    NavigationView navigationView;
    public static Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;

    public static TextView cartTxt;
    SharedPreferences sharedpreferences;
    EditText searchData;
    TextView User_Name;
    private FirebaseAuth firebaseAuth;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentAdapter fragmentAdapter;
    public static EditText searchEdt;
    private int cartQty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebaseAuth = FirebaseAuth.getInstance();
        searchEdt = findViewById(R.id.searchEdt);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        cartTxt = findViewById(R.id.carttxt);
        ImageView menuBtn = findViewById(R.id.menuBtn);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);
        tabLayout.addTab(tabLayout.newTab().setText("Vegetables"));
        tabLayout.addTab(tabLayout.newTab().setText("Fruits"));
        dialog = new ProgressDialog(this);
        dialog.setMessage("Log Out...");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                tabLayout.selectTab(tabLayout.getTabAt(position));

            }
        });


        String url1 = "https://github.com/muraribabupatel/muraribabupatel/blob/main/is%20Now%20Accepting%20Orders.png?raw=true";
        String url2 = "https://github.com/muraribabupatel/muraribabupatel/blob/main/Covid.png?raw=true";
        String url3 = "https://github.com/muraribabupatel/muraribabupatel/blob/main/20%25%20off%20if%20you%20buy%20two%20Vegetables%20and%20fruits.png?raw=true";


        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);
        sliderView.setIndicatorSelectedColor(R.color.black);
        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer.openDrawer(GravityCompat.START);
            }
        });
        View header = navigationView.getHeaderView(0);

        User_Name = (TextView) header.findViewById(R.id.u_name);
        Intent intent = getIntent();
        SharedPreferences sharedPreferences = getSharedPreferences("Grocery Mart", MODE_PRIVATE);
        String fName = sharedPreferences.getString("email", "");

        // receive the value by getStringExtra() methodf
        // and key must be same which is send by first activity

        // display the string into textView
        User_Name.setText(fName);


        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_camera);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        drawerToggle = setupDrawerToggle();

        FloatingActionButton fab = findViewById(R.id.fab);
        cartIcon = findViewById(R.id.cartIcon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddToCartActivity.class));

            }


        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setupDrawerLayout();


    }

    public void setupDrawerLayout() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;
                switch (id) {
                    case R.id.nav_home:
                        Intent ic = new Intent(getApplicationContext(), HomeActivity.class);
                        ic.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(ic);
                        break;
                    case R.id.nav_profile:
                        Intent ic1 = new Intent(getApplicationContext(), ProfileActivity.class);
                        ic1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(ic1);
                        break;
                    case R.id.nav_cart:
                        Intent ic5 = new Intent(getApplicationContext(), AddToCartActivity.class);
                        ic5.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(ic5);
                        break;
                    case R.id.nav_about:
                        Intent ic2 = new Intent(getApplicationContext(), AboutActivity.class);
                        ic2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(ic2);
                        break;
                    case R.id.nav_contact:
                        Intent ic3 = new Intent(getApplicationContext(), ContactUsActivity.class);
                        ic3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(ic3);
                        break;

                    case R.id.nav_shareapp:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT,
                                "Grocery Mart fresh Vegetables & Fruits App Order now " + "https://play.google.com/store/apps/details?id=" + "com.awiskartechvizag.grocerymart" + " & enjoy it."); // getApplicationContext().getPackageName()
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);

                        break;

                    case R.id.nav_logout:
                        dialog.show();

                        SharedPreferences preferences = getSharedPreferences("Grocery Mart", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.clear();
                        editor.apply();
                        finish();
                        FirebaseAuth.getInstance().signOut();
                        Intent ic4 = new Intent(getApplicationContext(), LandingActivity.class);
                        ic4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(ic4);
                        break;


                }
                drawer.closeDrawers();
                return false;
            }
        });
    }

public void updateQty(int qty){
        cartQty = cartQty+qty;
    cartTxt.setText(cartQty+"");
}
}