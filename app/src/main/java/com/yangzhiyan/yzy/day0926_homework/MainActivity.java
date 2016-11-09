package com.yangzhiyan.yzy.day0926_homework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<Fragment> list;
    private MyFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        list.add(new ThirdFragment());
        viewPager = (ViewPager) findViewById(R.id.vpinfos);


        adapter = new MyFragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
    }
}
