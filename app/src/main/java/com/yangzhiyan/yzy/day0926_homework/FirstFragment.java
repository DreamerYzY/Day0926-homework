package com.yangzhiyan.yzy.day0926_homework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private ViewPager viewPager;
    private List<ImageView> list;
    private TextView tvsubject;
    private FirstFragmentAdapter adapter;
    private int[] pics = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
    private LinearLayout lldots;
    private ImageView[] dots;
    private String[] subject = {"武媚娘传奇 - 大结局","神曲《小苹果》","疯狂漫画","痛的领悟！每年过节必心塞","加拿大登山家攀冰史诗"};
    private ListView lvfrag1;
    private List<String> listinfo;
    private ArrayAdapter<String> adapt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.vpnews);
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ImageView iv = new ImageView(getContext());
            iv.setImageResource(pics[i]);
            list.add(iv);
        }
        adapter = new FirstFragmentAdapter(list);
        viewPager.setAdapter(adapter);
        lldots = (LinearLayout) view.findViewById(R.id.lldots);

        dots = new ImageView[5];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = (ImageView) lldots.getChildAt(i);
            dots[i].setEnabled(true);
            dots[i].setTag(i);
            dots[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(Integer.parseInt(v.getTag().toString()));
                }
            });
        }
        dots[0].setEnabled(false);
        tvsubject = (TextView) view.findViewById(R.id.tvsubject);
        tvsubject.setText(subject[0]);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i <lldots.getChildCount() ; i++) {
                    dots[i].setEnabled(true);
                }
                dots[position].setEnabled(false);
                tvsubject.setText(subject[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

}
