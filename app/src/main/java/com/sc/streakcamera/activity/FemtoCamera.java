package com.sc.streakcamera.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.sc.streakcamera.R;
import com.sc.streakcamera.util.MyApplication;
import com.sc.streakcamera.util.MyGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public class FemtoCamera extends BaseDeviceFragment {
    private MyGridView mGridView;
    /**
     * 图标状态
     */
    private List<Integer> imgDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.five_tab));


    /**
     * 名字
     */
    private List<String> mDatas = new ArrayList<String>();
    private CommonAdapter mAdapter;
    private ViewHolder viewHolder;
    /**
     * 控制碎片
     */
    private FemtoControlFragment femtoControlFragment;
    /**
     * 监测碎片
     */
    private FemtoMonitorFragment femtoMonitorFragment;



    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mAdapter = new CommonAdapter<String>(MyApplication.getContext(),
                mDatas,R.layout.gv_item_switch){
            @Override
            public void convert(final ViewHolder helper, String item)
            {
//                helper.setText(R.id.tv_switch_name, item);   //item替换为mDatas.get(helper.getPosition())一样结果
//                helper.setImageResource(R.id.img_switch, imgDatas.get(helper.getPosition())); //注意这个方法和item的关系
//                helper.setToggleButton(R.id.tb_switch, imgDatas.get(helper.getPosition()));
//                FemtoCamera.this.viewHolder = helper;
                final TextView tvSwitch = helper.getView(R.id.tv_switch_name);
                tvSwitch.setText(mDatas.get(helper.getPosition()));
                ToggleButton tbSwitch = helper.getView(R.id.tb_switch);
                tbSwitch.setButtonDrawable(imgDatas.get(helper.getPosition()));    //选中变色的开关图案
                /**
                 * 开关逻辑
                 */
                tbSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        isChecked = "收到服务器对应position指令"
                        if (isChecked) {
                            Toast.makeText(MyApplication.getContext(), "你打开了" + mDatas.get(helper.getPosition()) + "开关", Toast.LENGTH_SHORT).show();
                            tvSwitch.setSelected(true); //为了选中变色
                        } else {
                            Toast.makeText(MyApplication.getContext(), "你关闭了" + mDatas.get(helper.getPosition()) + "开关", Toast.LENGTH_SHORT).show();
                            tvSwitch.setSelected(false);
                        }
                    }
                });
            }
        };
        /**
         *  导入switch图标
         */
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        /**
         * //导入switch文字
         */
        mDatas.add("电源");
        mDatas.add("高压");
        mDatas.add("动态");
        mDatas.add("电磁阀");
        mDatas.add("光电");
        mDatas.add("离子规");
        mDatas.add("触发恢复");
        mDatas.add("CCD");

    }


    public View onCreateView (LayoutInflater inflater,ViewGroup container,
                              Bundle savedInstanceState){


        //飞秒布局
        View view = inflater.inflate(R.layout.femto_camera,container,false);
        //MyGridView的switch布局
        mGridView = (MyGridView) view.findViewById(R.id.gv_switch);
        android.support.v4.app.FragmentManager fragmentManager = getChildFragmentManager();
        android.support.v4.app.FragmentTransaction transaction =fragmentManager.beginTransaction();
        if (femtoControlFragment == null){
            femtoControlFragment=new FemtoControlFragment();
            transaction.add(R.id.control_layout,femtoControlFragment);
        }else {
            transaction.show(femtoControlFragment);
        }
        if (femtoMonitorFragment == null){
            femtoMonitorFragment=new FemtoMonitorFragment();
            transaction.add(R.id.monitor_layout,femtoMonitorFragment);
        }else {
            transaction.show(femtoMonitorFragment);
        }
        transaction.commit();
        /**
         * 给MyGridView设置Adapter
         */
        mGridView.setAdapter(mAdapter); //也可以把mAdapter直接用匿名内部类写在此处

        /**
         * 给MyGridView绑定点击监听
         */
//        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//
//                    case 0:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        mGridView.setItemChecked(position,true);
//                        break;
//                    case 1:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 3:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 4:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 5:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 6:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 7:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 8:
//                        Toast.makeText(MyApplication.getContext(),"你按了"+mDatas.get(position)+"开关一下",Toast.LENGTH_SHORT).show();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });

        return view;
    }

}
