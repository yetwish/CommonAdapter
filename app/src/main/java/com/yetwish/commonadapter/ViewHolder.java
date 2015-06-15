package com.yetwish.commonadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 抽取的ViewHolder类
 * Created by yetwish on 2015-05-11
 */

public class ViewHolder {

    private View mConvertView;
    private int layoutId;
    private int mPosition;
    /**
     * 存储int -> view
     */
    private SparseArray<View> mViews;
    private ViewHolder(Context context,int layoutId, ViewGroup parent,int position){
        mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mViews = new SparseArray<>();
        //set tag
        mConvertView.setTag(this);
        //set position
        mPosition = position;
    }

    /**
     * view holder 入口
     */
    public static ViewHolder getHolder(Context context,View convertView,int layoutId, ViewGroup parent,int position){
        //判断是否需要加载holder
        if(convertView == null){
            return new ViewHolder(context,layoutId,parent,position);
        }else {
            ViewHolder holder = (ViewHolder)convertView.getTag();
            //更新holder所处位置
            holder.mPosition = position;
            return holder;
        }
    }

    public View getConvertView(){
        return mConvertView;
    }

    /**
     * 获取控件
     */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            //find view
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 给 textView 设置显示文本
     */
    public ViewHolder setText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setImageRes(int viewId, int resId){
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }
}
