package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class write extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_write);
        ImageButton back = (ImageButton)findViewById(R.id.imageButton);
        Button no_name = (Button)findViewById(R.id.button);
        Button okay = (Button) findViewById(R.id.button2);

        //백 버튼눌렀을시에 작동함수입니다 안에서 기능 구현 하시면돼요
        //Oncreate 안에 말고 밖으로 빼고싶으면 함수 밖으로빼고 back 버튼을 전역 선언하면됩니다
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.imageButton) {
                    finish();
                } else if (v.getId() == R.id.button) { //익명 글쓰기 구현

                } else { //글쓰기 구현

                }
            }
        });

    }



}