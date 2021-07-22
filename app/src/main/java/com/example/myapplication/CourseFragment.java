package com.example.myapplication;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static CourseFragment newInstance(){
        return new CourseFragment();
    }

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ArrayAdapter yearAdapter;
    private Spinner areaSpinner;
    private ArrayAdapter areaAdapter;


    private String courseUniversity ="";
    private String courseArea = "";

    private ListView courseListView;
    private CourseListAdapter adapter;
    private List<Course> courseList;


    @Override
    public void onActivityCreated(Bundle b){
        super.onActivityCreated(b);

        final RadioGroup courseUniversityGroup = (RadioGroup) getView().findViewById(R.id.courseUniversityGroup);
        areaSpinner = (Spinner) getView().findViewById(R.id.areaSpinner);

        courseUniversityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int i) {
                RadioButton courseButton = (RadioButton) getView().findViewById(i);
                courseUniversity = courseButton.getText().toString();

                if(courseUniversity.equals("학부")) {
                    areaAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universityArea, android.R.layout.simple_spinner_dropdown_item);
                    areaSpinner.setAdapter(areaAdapter);
                }

                else if(courseUniversity.equals("대학원")) {
                    areaAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.graduateArea, android.R.layout.simple_spinner_dropdown_item);
                    areaSpinner.setAdapter(areaAdapter);
                }

            }
        });


        courseListView = (ListView) getView().findViewById(R.id.courseListView);
        courseList = new ArrayList<Course>();
        adapter = new CourseListAdapter(getContext().getApplicationContext(), courseList);
        courseListView.setAdapter(adapter);

        Button searchButton = (Button) getView().findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener(){

//            @Override
//            public void onClick(View v) {
//                new BackgroundTask().onPostExecute(areaSpinner.getSelectedItem().toString());
//            }
            @Override
            public void onClick(View v){
                try {
                    courseList.clear();

                    Sugang_dehakwon dehakwon = new Sugang_dehakwon();
                    Sugang_gyoyang gyoyang = new Sugang_gyoyang();
                    Sugang_jungong jungong = new Sugang_jungong();
                    Sugang_won_a won_a = new Sugang_won_a();
                    Sugang_wongyuk wongyuk = new Sugang_wongyuk();

                    ArrayList<String> dehakwon_code = dehakwon.get_dehakwon_code();
                    ArrayList<String> dehakwon_name = dehakwon.get_dehakwon_name();

                    ArrayList<String> gyoyang_code = gyoyang.get_gyoyang_code();
                    ArrayList<String> gyoyang_name = gyoyang.get_gyoyang_name();

                    ArrayList<String> jungong_code = jungong.get_jungong_code();
                    ArrayList<String> jungong_name = jungong.get_jungong_name();

                    ArrayList<String> won_a_code = won_a.get_won_a_code();
                    ArrayList<String> won_a_name = won_a.get_won_a_name();

                    ArrayList<String> wongyuk_code = wongyuk.get_wongyuk_code();
                    ArrayList<String> wongyuk_name = wongyuk.get_wongyuk_name();

                    int count = 0;
                    String coursenum;
                    String courseTitle;

                    while(count<dehakwon_name.size()){
                        coursenum = dehakwon.get_dehakwon_code(count);
                        courseTitle = dehakwon.get_dehakwon_name(count);
                        Course course = new Course(coursenum, courseTitle);
                        courseList.add(course);
                        count++;
                    }
                    adapter.notifyDataSetChanged();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course, container, false);
    }



//    class BackgroundTask extends AsyncTask<Void, Void, String>
//    {
//        String target;
//
//        @Override
//        protected String doInBackground(Void... voids) {
//            return null;
//        }
//
//        public void onPostExecute(String result){
//        try {
//            courseList.clear();
//
//            Sugang_dehakwon dehakwon = new Sugang_dehakwon();
//            Sugang_gyoyang gyoyang = new Sugang_gyoyang();
//            Sugang_jungong jungong = new Sugang_jungong();
//            Sugang_won_a won_a = new Sugang_won_a();
//            Sugang_wongyuk wongyuk = new Sugang_wongyuk();
//
//            ArrayList<String> dehakwon_code = dehakwon.get_dehakwon_code();
//            ArrayList<String> dehakwon_name = dehakwon.get_dehakwon_name();
//
//            ArrayList<String> gyoyang_code = gyoyang.get_gyoyang_code();
//            ArrayList<String> gyoyang_name = gyoyang.get_gyoyang_name();
//
//            ArrayList<String> jungong_code = jungong.get_jungong_code();
//            ArrayList<String> jungong_name = jungong.get_jungong_name();
//
//            ArrayList<String> won_a_code = won_a.get_won_a_code();
//            ArrayList<String> won_a_name = won_a.get_won_a_name();
//
//            ArrayList<String> wongyuk_code = wongyuk.get_wongyuk_code();
//            ArrayList<String> wongyuk_name = wongyuk.get_wongyuk_name();
//
//            int count = 0;
//            String coursenum;
//            String courseTitle;
//
//            while(count<dehakwon_name.size()){
//                coursenum = dehakwon.get_dehakwon_code(count);
//                courseTitle = dehakwon.get_dehakwon_name(count);
//                Course course = new Course(coursenum, courseTitle);
//                courseList.add(course);
//                count++;
//            }
//            adapter.notifyDataSetChanged();
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }

//    }

}