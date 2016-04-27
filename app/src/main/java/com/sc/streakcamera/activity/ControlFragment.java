package com.sc.streakcamera.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sc.streakcamera.R;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/4/14.
 */
public class ControlFragment extends Fragment{
    ViewPagerAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    FemtoCamera femtoCamera;
    Fragment1 fragment1;
    Fragment2 fragment2;
    TextView titleTextView;

    ArrayList<Fragment> listFragmentsa;
    ArrayList<String> listDeviceName;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listFragmentsa = new ArrayList<Fragment>();                   //viewpager的fragmentArrayList
        listDeviceName = new ArrayList<String>();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        femtoCamera = new FemtoCamera();                              //不实例会报空指针错误
        listFragmentsa.add(femtoCamera);
        listDeviceName.add("飞秒条纹相机");
        listFragmentsa.add(fragment1);
        listDeviceName.add("超快电子衍射仪");
        listFragmentsa.add(fragment2);
        listDeviceName.add("大动态条纹相机");
        mAdapter = new ViewPagerAdapter(getChildFragmentManager(),listFragmentsa);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.control, container,false);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);
        titleTextView = (TextView)view.findViewById(R.id.title);

        mIndicator = (CirclePageIndicator)view.findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.setCurrentItem(0);         //每次载入都是第一个page
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                titleTextView.setText(listDeviceName.get(mPager.getCurrentItem())); //get方法获得指定位置实际得到的是object
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

}
