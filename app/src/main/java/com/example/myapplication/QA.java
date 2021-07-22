package com.example.myapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.google.android.material.internal.ContextUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Context;

import static android.content.Context.MODE_PRIVATE;

public class QA extends Fragment implements View.OnClickListener {

    String fname = null;
    String text = null;
    String text2 = null;
    public int num;

    public void print(){
        FileInputStream fn = null;
        try {
            fn = getContext().openFileInput("path.txt");
            DataInputStream ds = new DataInputStream(fn);
            fname = ds.readUTF();
            ds.close();

            System.out.println("파일 이름은 "+ fname);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fos = null;
        try {
            fos = getContext().openFileInput(fname);
            DataInputStream dos = new DataInputStream(fos);
            text = dos.readUTF();
            dos.close();

            System.out.println("글 제목은 "+text);
        //    System.out.println("\n글 내용은 "+text2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


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