package com.sc.streakcamera.activity;

;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * Created by Administrator on 2016/4/15.
 */
public final class TestFragment extends Fragment {
    private static final String KEY_CONTENT ="TestFragment:Content";

    public static TestFragment newInstance(String content){
        TestFragment fragment = new TestFragment();           //newInstance实例化一个Testfragment并将content加入StringBuilder
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < 20;i++){
            //StringBuilder.Append (String)	在此实例的结尾追加指定字符串的副本
            //加content加空格
            builder.append(content).append(" ");

        }
        //java.lang.StringBuffer.deleteCharAt() 在这个序列中的指定位置删除字符,也就是删除最后一个位置的字符??是空格？？
        builder.deleteCharAt(builder.length()-1);
        fragment.mContent = builder.toString();
        return fragment;
    }
    private String mContent = "???";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //如果保存数据不为空，并且含有关键字KEY_CONTENT
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_CONTENT)){
            mContent = savedInstanceState.getString(KEY_CONTENT);   //用于setText
        }
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        //布局加一个TextView
        TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER);
        text.setText(mContent);
        text.setTextSize(20 * getResources().getDisplayMetrics().density); //适配屏幕
        text.setPadding(20, 20, 20, 20);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(text);

        return layout;
    }
}
