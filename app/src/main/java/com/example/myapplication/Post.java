package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class Post extends Fragment {

    Toolbar myToolbar;
    private ViewPager viewPager;

    private QA qa;
    private TP tp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        myToolbar = (Toolbar) view.findViewById(R.id.toolbar_post);
        ((AppCompatActivity)getActivity()).setSupportActionBar(myToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        myToolbar.setTitle("게시판");

        qa = new QA();
        tp = new TP();

        TabLayout tabs = (TabLayout) view.findViewById(R.id.tab_layout);
        tabs.addTab(tabs.newTab().setText("질문"));
        tabs.addTab(tabs.newTab().setText("팀플 및 스터디"));

        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        return view;
    }

    private class PagerAdapter extends FragmentPagerAdapter{
        public PagerAdapter(FragmentManager fm) {
            super(fm);
            getItem(0);
        }

        public Fragment getItem(int position) {
            if(position==0) {
                return qa;
            } else {
                return tp;
            }
        }

        public int getCount(){
            return 2;
        }

    }
}