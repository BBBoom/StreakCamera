package com.sc.streakcamera.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.sc.streakcamera.R;
import com.sc.streakcamera.util.MyApplication;

/**
 * Created by Administrator on 2016/4/21.
 * 与传统的ViewHolder不同，我们使用了一个SparseArray<View>
 * 用于存储与之对于的convertView的所有的控件，当需要拿这些控件时，通过getView(id)进行获取
 */
public class ViewHolder {
    private final SparseArray<View> mViews;  //键值为ID，值为控件引用
    private View mConvertView;
    private int mPosition;

    private ViewHolder(Context context,ViewGroup parent,int layoutId,int position){
        this.mViews  = new SparseArray<View>();
        this.mPosition = position;
        mConvertView  = LayoutInflater.from(context).inflate(layoutId,parent,false);   //将xml转换成View，构造方法接收4个参数分别用于veiw，position，
        mConvertView.setTag(this);   //给一个View绑定viewholder
    }
    /**
     * 拿到一个ViewHolder对象
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static  ViewHolder get(Context context,View convertView,ViewGroup parent,
                                  int layoutId,int position){
        if (convertView == null){
            return new ViewHolder(context,parent,layoutId,position);
        }
        return (ViewHolder) convertView.getTag();      //通过convertView的标签得到返回的ViewHolder
    }
    /**
     * 通过控件的Id获取对应的控件，如果没有则加入views
     * @param viewId
     * @return
     */
    public <T extends View>T getView(int viewId){       //返回一个T类型，T继承于View；？？？为什么不直接是View(泛型)
        View view = mViews.get(viewId);                 //viewId为R文件里的ID是int型，作为键值存在SparseArray里
        if(view == null){
            view = mConvertView.findViewById(viewId);   //如果没取到则去findViewById
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public View getConvertView(){
        return mConvertView;
    }
    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;          //return this;返回的是实际调用这个方法的实例化对象。
    }
    public ViewHolder setTextWithColor(int viewId, String text,int colorId) {
        TextView view = getView(viewId);
        view.setText(text);
        view.setTextColor(colorId);
        return this;          //return this;返回的是实际调用这个方法的实例化对象。
    }
    public ViewHolder setToggleButton(int viewId, int drawableId)
    {
        ToggleButton button = getView(viewId);
        button.setButtonDrawable(drawableId);
        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MyApplication.getContext(),"打开",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MyApplication.getContext(),"关闭",Toast.LENGTH_SHORT).show();

                }
            }
        });

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int drawableId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }


    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param
     * @return
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param
     * @param
     * @return
     */
//    public ViewHolder setImageByUrl(int viewId, String url)
//    {
//        ImageLoader.getInstance(3, Type.LIFO).loadImage(url,
//                (ImageView) getView(viewId));
//        return this;
//    }

    public int getPosition()
    {
        return mPosition;
    }
}
