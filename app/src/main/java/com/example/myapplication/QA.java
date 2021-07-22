package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class QA extends Fragment implements View.OnClickListener {

    public static QA newInstance(){
        return new QA();
    }

    write wr = new write();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_a, container, false);

        FloatingActionButton write = (FloatingActionButton) view.findViewById(R.id.writebutton_qa);
        write.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        //Intent 부분으로 write 클래스 작동시킵니다
        Intent intent = new Intent(getContext(),write.class);
        startActivity(intent);

    }

    /*** // To main
     * @Override
     *     public void onClick(View v) {
     *         Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
     *         getActivity().startActivity(intent);
     *     }
     */
}