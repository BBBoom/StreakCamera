package com.sc.streakcamera.activity;


import java.util.Random;

import com.sc.streakcamera.R;
import com.viewpagerindicator.PageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/15.  ViewPagerIndicator  的BaseActivity
 */

public abstract class BaseSampleActivity extends Fragment {
    private static final Random RANDOM = new Random();

    ViewPagerAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.control, null);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.random:
//                final int page = RANDOM.nextInt(mAdapter.getCount());
//                Toast.makeText(this, "Changing to page " + page, Toast.LENGTH_SHORT);
//                mPager.setCurrentItem(page);
//                return true;
//
//            case R.id.add_page:
//                if (mAdapter.getCount() < 10) {
//                    mAdapter.setCount(mAdapter.getCount() + 1);
//                    mIndicator.notifyDataSetChanged();
//                }
//                return true;
//
//            case R.id.remove_page:
//                if (mAdapter.getCount() > 1) {
//                    mAdapter.setCount(mAdapter.getCount() - 1);
//                    mIndicator.notifyDataSetChanged();
//                }
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
