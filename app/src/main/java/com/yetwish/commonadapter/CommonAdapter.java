package com.yetwish.commonadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 万能适配器 抽象类，需实现convert()方法，将views装载到holder中
 * 复用问题：可存储 一个选中的position 数组，或根据bean对象中的标记位isChecked 判断该position是否需要选中
 * Created by yetwish on 2015-05-11
 */

public abstract class CommonAdapter<T> extends BaseAdapter{

    protected List<T> mData;
    protected int mLayoutId;
    protected Context mContext;

    public CommonAdapter(Context context,List<T> data,int layoutId){
        mContext = context;
        mData = data;
        mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = ViewHolder.getHolder(mContext,convertView,mLayoutId,parent,position);
        //findView
        convert(holder,position);
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,int position);
}
