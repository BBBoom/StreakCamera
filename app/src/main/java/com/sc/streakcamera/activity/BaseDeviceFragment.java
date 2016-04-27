package com.sc.streakcamera.activity;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/4/20.
 */
public class BaseDeviceFragment extends Fragment{
    public String deviceName;
//    public void BaseDeviceFragment(String name){};

    public void setName(String name){
        this.deviceName = name;
    }
    public String getName(){
        return deviceName;
    }
}
