package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.support.v4.app.*;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment {

    private FragmentActivity myContext;
    public Button scheduleButton, postButton, advertisementButton;

    public static Home newInstance() {
        return new Home();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, null);
        scheduleButton = (Button) view.findViewById(R.id.scheduleButton);
        postButton = (Button) view.findViewById(R.id.postButton);
        advertisementButton = (Button) view.findViewById(R.id.advertisementButton);

        scheduleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).replaceFragment(Plan.newInstance());

            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ((MainActivity) getActivity()).replaceFragment(CourseFragment.newInstance());
            }
        });

//        advertisementButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//                ((MainActivity)getActivity()).replaceFragment(NewFragment.newInstance());
//            }
//        });


        return view;
    }
}