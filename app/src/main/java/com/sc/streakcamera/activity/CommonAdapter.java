package com.sc.streakcamera.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/21.
 * Adapter一般需要保持一个List对象，
 * 存储一个Bean的集合，不同的ListView，Bean肯定是不同的，这个CommonAdapter肯定需要支持泛型，
 * 内部维持一个List<T>，就解决我们的问题了；
 */
public  abstract class CommonAdapter<T> extends BaseAdapter {  //抽象类中的非抽象方法不用重写，其他必须重写
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;
    protected int mItemLayoutId;

    public CommonAdapter (Context context,List<T> mdatas,int itemLayoutId){
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mdatas;
        this.mItemLayoutId = itemLayoutId;
    }
    @Override
    public int getCount(){
        return mDatas.size();
    }
    @Override
    public T getItem(int position){               //注意泛型T ，之前是Object
        return mDatas.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    /**
     * 我们把getView第一行和最后一行写死，把中间变化的部分抽取出来
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ViewHolder viewHolder = getViewHolder(position, convertView,       //获得ViewHolder的实例 final
                parent);
        convert(viewHolder, getItem(position));                                //getItem类型为T
        return viewHolder.getConvertView();

    }

    /**
     * 对外公布convert方法，这里要写变化的中间两行：通过ViewHolder把View找到，通过Item设置值；
     * 注意此方法是每个ITEM都会执行，会执行很多次.
     * @param item
     */
    public abstract void convert(ViewHolder helper, T item);    //该抽象方法需要重写，对外公布了一个convert方法，并且还把viewHolder和本Item对于的Bean对象给传出去
       //实际上跟这个item毛关系没有，只是为了方便传入数据，例如item.getString可以获得一个类似list<String>.get（position）的效果
    /**
     * 3个参数返回一个viewholder实例，其他参数是构造方法中的
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent)
    {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
                position);
    }

}

