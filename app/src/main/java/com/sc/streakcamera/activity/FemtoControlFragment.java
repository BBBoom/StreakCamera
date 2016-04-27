package com.sc.streakcamera.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sc.streakcamera.util.MyApplication;
import com.sc.streakcamera.util.MyGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sc.streakcamera.R;

/**
 * Created by Administrator on 2016/4/25.
 */
public class FemtoControlFragment extends Fragment {
    private MyGridView mGridView;
    /**
     * 图标
     */
    private List<Integer> imgDatas = new ArrayList<Integer>();
    /**
     * 名称
     */
    private List<String> nameDatas = new ArrayList<>();
    /**
     * 单位符号
     */
    private List<String> symDatas = new ArrayList<>();
    private CommonAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        /**
         * 导入图标
         */
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        imgDatas.add(R.drawable.five_tab);
        /**
         * 导入名称
         */
        nameDatas.add(" 正偏压");
        nameDatas.add(" 负偏压");
        nameDatas.add("聚焦电流");
        nameDatas.add("阴极电压");
        nameDatas.add("MCP电压");
        nameDatas.add(" 荧光屏");
        /**
         * 导入单位符号
         */
        symDatas.add("V");
        symDatas.add("V");
        symDatas.add("A");
        symDatas.add("V");
        symDatas.add("V");
        symDatas.add("V");

        mAdapter = new CommonAdapter<String>(MyApplication.getContext(),
                nameDatas,R.layout.gv_item_control) {
            @Override
            public void convert(final ViewHolder helper, String item) {
                ImageView imageView = helper.getView(R.id.img_control);
                imageView.setImageResource(imgDatas.get(helper.getPosition()));
                TextView tvName = helper.getView(R.id.tv_control_name);
                tvName.setText(nameDatas.get(helper.getPosition()));
                TextView tvSymbol = helper.getView(R.id.tv_control_symbol);
                tvSymbol.setText(symDatas.get(helper.getPosition()));
            }
        };
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.femto_control_fragment,container,false);
        mGridView = (MyGridView)view.findViewById(R.id.gv_control);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MyApplication.getContext(), "你按了" + nameDatas.get(position) + "选项一下", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MyApplication.getContext(), "你按了" + nameDatas.get(position) + "选项一下", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MyApplication.getContext(), "你按了" + nameDatas.get(position) + "选项一下", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MyApplication.getContext(), "你按了" + nameDatas.get(position) + "选项一下", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MyApplication.getContext(), "你按了" + nameDatas.get(position) + "选项一下", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(MyApplication.getContext(), "你按了" + nameDatas.get(position) + "选项一下", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        return view;
    }

}
