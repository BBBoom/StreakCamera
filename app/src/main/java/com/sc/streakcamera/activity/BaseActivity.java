package com.sc.streakcamera.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/4/6.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
