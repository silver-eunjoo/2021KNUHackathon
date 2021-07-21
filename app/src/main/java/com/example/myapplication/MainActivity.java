package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends FragmentActivity {

    TabLayout tabs;

    Home home;
    Post post;
    Plan plan;
    Alarm alarm;
    Setting setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new Home();
        post = new Post();
        plan = new Plan();
        alarm = new Alarm();
        setting = new Setting();

        getSupportFragmentManager().beginTransaction().add(R.id.container, home).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Home"));
        tabs.addTab(tabs.newTab().setText("Post"));
        tabs.addTab(tabs.newTab().setText("Plan"));
        tabs.addTab(tabs.newTab().setText("Alarm"));
        tabs.addTab(tabs.newTab().setText("Setting"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = home;
                else if(position == 1)
                    selected = post;
                else if(position == 2)
                    selected = plan;
                else if(position == 3)
                    selected = alarm;
                else if(position == 4)
                    selected = setting;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
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