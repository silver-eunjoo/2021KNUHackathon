package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class write extends AppCompatActivity {

    public String fname = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_write);
        ImageButton back = (ImageButton)findViewById(R.id.backbtn);
        Button no_name = (Button)findViewById(R.id.button);
        Button okay = (Button) findViewById(R.id.button2);


        //백 버튼눌렀을시에 작동함수입니다 안에서 기능 구현 하시면돼요
        //Oncreate 안에 말고 밖으로 빼고싶으면 함수 밖으로빼고 back 버튼을 전역 선언하면됩니다
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.backbtn) {
                    finish();
                }
            }
        });

        no_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();

            }
        });




        okay.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                EditText content;
                content = (EditText) findViewById(R.id.Sample1);
                EditText content2;
                content2 = (EditText) findViewById(R.id.Sample2);
                String contents = content.getText().toString();
                String contents2 = content2.getText().toString();
                contents = contents.replace("'","\"");

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String datestr = sdf.format(cal.getTime());
                fname=""+datestr+".txt";//저장할 파일 이름설정

                FileOutputStream fn = null;
                try {
                    fn = openFileOutput("path.txt",MODE_PRIVATE);
                    DataOutputStream ds = new DataOutputStream(fn);
                    ds.writeUTF(fname);
                    ds.flush();
                    ds.close();

                    System.out.println("파일 이름을 저장했습니다.");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(fname,MODE_PRIVATE);
                    DataOutputStream dos = new DataOutputStream(fos);
                    dos.writeUTF(contents+"\n"+contents2);
                    dos.flush();
                    dos.close();

                    System.out.println("파일에 글 제목을 저장했습니다.");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finish();
            }
        });




    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.window, fragment);
        fragmentTransaction.commit();
    }

}