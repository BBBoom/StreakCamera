package com.sc.streakcamera.activity;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.sc.streakcamera.R;

/**
 * Created by Administrator on 2016/4/14.
 */
public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater mLayoutInflater;
    /**
     * Fragment数组界面
     */
    private Class mFragmentArray[] = {ControlFragment.class, Fragment2.class, Fragment1.class, Fragment2.class};
    /**
     * 存放图标数组
     */
    private int mImageArray[] = {R.drawable.first_tab, R.drawable.second_tab,
            R.drawable.third_tab, R.drawable.fours_tab};

    /**
     * 选项卡文字
     */
    private String mTextArray[] = {"监控", "设备", "我的", "更多"};

    /**
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    /**
     * 初始化组件
     */
    private void initView() {
        mLayoutInflater = LayoutInflater.from(this);
        //找到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //得到Fragment个数
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            //给每个tab设置图标和文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i]).setIndicator(getTabItemView(i));

            //将tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, mFragmentArray[i], null);
            //设置tab按钮的背景
            mTabHost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.bottom_tab); //自定义
            mTabHost.getTabWidget().setDividerDrawable(null);
        }

    }

    /**
     * 给每个tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = mLayoutInflater.inflate(R.layout.tabwidget, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_name);
        imageView.setImageResource(mImageArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        textView.setText(mTextArray[index]);
        return view;

    }
}
    //        //设置tab切换时动态更改图标
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                tabChange(tabId);
//            }
//        });
//    }
//    //捕获tab变化事件
//    public void tabChange(String tabId){
//        //当前选中项
//        if(tabId.equals("first")){
//            tabHost.setCurrentTabByTag("监控");            //改变监控的tab图标
//        }else if(tabId.equals("second")){
//            tabHost.setCurrentTabByTag("设备");
//        }else if(tabId.equals("third")){
//            tabHost.setCurrentTabByTag("我的");
//        }else if(tabId.equals("fourth")){
//            tabHost.setCurrentTabByTag("设置");
//        }
//
//    }
//    //返回单个选项.tabHost的单个view
//    private View createContent(String text,int resid){
//        View view = LayoutInflater.from(this).inflate(R.layout.tabwidget, null, false);
//        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
//        ImageView iv_icon= (ImageView) view.findViewById(R.id.img_name);
//        tv_name.setText(text);
//        iv_icon.setBackgroundResource(resid);
//        return view;
//    }
//        tabHost = this.getTabHost();    //获取tabHost实例
//        first = tabHost.newTabSpec("first");       //"first"is tabId
//        second = tabHost.newTabSpec("second");
//        third = tabHost.newTabSpec("third");
//        fourth = tabHost.newTabSpec("fourth");
//        //指定选项卡上的文字和图标
//        first.setIndicator(createContent("监控", R.drawable.first_tab));
//        second.setIndicator(createContent("设备", R.drawable.second_tab));
//        third.setIndicator(createContent("我的", R.drawable.third_tab));
//        fourth.setIndicator(createContent("设置", R.drawable.fours_tab));
//        //绑定显示的界面
//        first.setContent(new Intent(this,ControlFragment.class));
//        second.setContent(new Intent(this,DeviceListFragment.class));
//        third.setContent(new Intent(this,MineFragment.class));
//        fourth.setContent(new Intent(this,SettingFragment.class));
//        //将选项卡加入TabHost
//        tabHost.addTab(first);
//        tabHost.addTab(second);
//        tabHost.addTab(third);
//        tabHost.addTab(fourth);
//        tabHost.setCurrentTab(0); //默认TAB选项卡
//        //设置tab切换时动态更改图标
//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String tabId) {
//                tabChange(tabId);
//            }
//        });
//    }
//    //捕获tab变化事件
//    public void tabChange(String tabId){
//        //当前选中项
//        if(tabId.equals("first")){
//            tabHost.setCurrentTabByTag("监控");            //改变监控的tab图标
//        }else if(tabId.equals("second")){
//            tabHost.setCurrentTabByTag("设备");
//        }else if(tabId.equals("third")){
//            tabHost.setCurrentTabByTag("我的");
//        }else if(tabId.equals("fourth")){
//            tabHost.setCurrentTabByTag("设置");
//        }
//
//    }
//    //返回单个选项.tabHost的单个view
//    private View createContent(String text,int resid){
//        View view = LayoutInflater.from(this).inflate(R.layout.tabwidget, null, false);
//        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
//        ImageView iv_icon= (ImageView) view.findViewById(R.id.img_name);
//        tv_name.setText(text);
//        iv_icon.setBackgroundResource(resid);
//        return view;
//    }
//    @Override
//    public boolean onKeyDown(int keyCode,KeyEvent event){
//        if (keyCode == KeyEvent.KEYCODE_BACK){                    //按两下下back键退出，BUG：只在tab=0的选项卡起作用
//            exit();
//            return false;
//        }
//        return super.onKeyDown(keyCode,event);
//    }
//    public void exit(){
//        if((System.currentTimeMillis()-exitTime)>2000){
//            Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_SHORT).show();
//            exitTime=System.currentTimeMillis();
//        }else {
//            finish();
//            System.exit(0);
//        }
//    }

