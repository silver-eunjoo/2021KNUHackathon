package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class Home extends Fragment {

    private FragmentActivity myContext;
    public Button scheduleButton, postButton, advertisementButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View view =  inflater.inflate(R.layout.fragment_plan, container, false);
//        scheduleButton=view.findViewById(R.id.scheduleButton);
//        postButton=view.findViewById(R.id.postButton);
//        advertisementButton=view.findViewById(R.id.advertisementButton);}
//
//        scheduleButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentManager.replace(R.id.fragment, new Plan_Fragment());
//                fragmentManager.commit();
//            }
//        });
//
//        postButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentManager.replace(R.id.fragment, new CourseFragment());
//                fragmentManager.commit();
//            }
//        });
//
//        advertisementButton.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentManager.replace(R.id.fragment, new Plan_Fragment());
//                fragmentManager.commit();
//            }
//        });
//
//
//
//
//
//
//
//    }
//
//}