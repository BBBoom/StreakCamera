package com.sc.streakcamera.activity;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sc.streakcamera.R;
import com.viewpagerindicator.IconPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/15. 注意此包中的Fragment导入V4包
 */
public class ViewPagerAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
//    protected static final String[] TITLE = new String[] {"FemtoCamera","is","a","test"};
    protected ArrayList<Fragment> listFragment;

    protected static final int[] ICONS = new int[] {
            R.drawable.perm_group_calendar,
            R.drawable.perm_group_camera,
            R.drawable.perm_group_device_alarms,
            R.drawable.perm_group_location
    };
//    public int mCount = listFragment.size();                   //如果不注释掉这句话会报空指针错误
//    private int sCount = TITLE.length;
    public ViewPagerAdapter(FragmentManager fm){       //v4包中的FragmentManager
        super(fm);
//        List<Fragment> listFragment = new ArrayList<Fragment>();
//        listFragment.add(new Fragment1());   //为了测试只
//        listFragment.add(new Fragment2());
    }
    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> al){
        super(fm);
        listFragment = al;
    }
    public Fragment getItem(int position){
        return listFragment.get(position);
    }
    public int getCount(){
        return listFragment.size();
    }

    public int getItemPosition(Object object){
        return super.getItemPosition(object);
    }
//    public String getPageTitle(int position){                            //本来是字符序列CharSequence类型
//        return ViewPagerAdapter.TITLE[position % TITLE.length];
//    }
    public int getIconResId(int index){
        return ICONS[index % ICONS.length];
    }
//    public void setCount(int count){
//        mCount = count;
//        notifyDataSetChanged();
//    }

}
