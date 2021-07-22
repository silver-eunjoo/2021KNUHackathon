package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class write extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_write, container, false);

        // 버튼의 id를 통한 연결 (onClick 사용 안 했음)
        ImageButton back = (ImageButton) view.findViewById(R.id.imageButton);
        Button no_name = (Button) view.findViewById(R.id.button);
        Button okay = (Button) view.findViewById(R.id.button2);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
        if (v.getId() == R.id.imageButton) {
            getActivity().startActivity(intent);
        } else if (v.getId() == R.id.button) { //익명 글쓰기 구현

        } else { //글쓰기 구현

        }
    }
}