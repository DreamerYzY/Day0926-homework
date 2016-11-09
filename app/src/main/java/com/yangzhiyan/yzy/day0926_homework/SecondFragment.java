package com.yangzhiyan.yzy.day0926_homework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private List<String> list;
    private ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second, container, false);
        ListView listView = (ListView) view.findViewById(R.id.lvfrag2);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item"+(i+1));
        }
        return view;
    }

}
