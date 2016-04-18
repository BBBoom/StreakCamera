package com.sc.streakcamera.activity;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sc.streakcamera.R;
import com.viewpagerindicator.IconPagerAdapter;

/**
 * Created by Administrator on 2016/4/15. 注意此包中的Fragment导入V4包
 */
public class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
    protected static final String[] CONTENT = new String[] {"this","is","a","test"};
    protected static final int[] ICONS = new int[] {
            R.drawable.perm_group_calendar,
            R.drawable.perm_group_camera,
            R.drawable.perm_group_device_alarms,
            R.drawable.perm_group_location
    };
    private int mCount = CONTENT.length;
    public TestFragmentAdapter(FragmentManager fm){       //v4包中的FragmentManager
        super(fm);
    }
    public Fragment getItem(int position){
        return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
    }
    public int getCount(){
        return mCount;
    }
    public String getPageTitle(int position){                            //本来是字符序列CharSequence类型
        return TestFragmentAdapter.CONTENT[position % CONTENT.length];
    }
    public int getIconResId(int index){
        return ICONS[index % ICONS.length];
    }
    public void setCount(int count){
        mCount = count;
        notifyDataSetChanged();
    }

}
