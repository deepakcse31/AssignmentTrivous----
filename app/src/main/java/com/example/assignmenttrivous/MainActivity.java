package com.example.assignmenttrivous;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("India.com"));
        tabLayout.addTab(tabLayout.newTab().setText("Hindustan Times"));
        tabLayout.addTab(tabLayout.newTab().setText("Live mint"));
        tabLayout.addTab(tabLayout.newTab().setText("The Times of India"));
        tabLayout.addTab(tabLayout.newTab().setText("google news"));
        tabLayout.addTab(tabLayout.newTab().setText("Techradar"));
        tabLayout.addTab(tabLayout.newTab().setText("NDTV News"));
        tabLayout.addTab(tabLayout.newTab().setText("News18"));
        tabLayout.addTab(tabLayout.newTab().setText("Inside Sport"));
        tabLayout.addTab(tabLayout.newTab().setText("Business Standard"));
        tabLayout.addTab(tabLayout.newTab().setText("Zoom"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
         MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
