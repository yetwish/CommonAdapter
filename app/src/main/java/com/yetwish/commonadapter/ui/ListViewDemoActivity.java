package com.yetwish.commonadapter.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.yetwish.commonadapter.CommonAdapter;
import com.yetwish.commonadapter.R;
import com.yetwish.commonadapter.ViewHolder;
import com.yetwish.commonadapter.bean.Bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yetwish on 2015-05-11
 */

public class ListViewDemoActivity extends ActionBarActivity {

    private ListView lvBeans;
    private List<Bean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);
        initData();
        initViews();
    }

    /**
     * 初始化获取listView data
     */
    private void initData() {
        mData = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            mData.add(new Bean("新技能" + i, "获取android新技能，打造万能适配器", "2015-5-11", "100" + i * 20));
        }
    }

    /**
     * 初始化布局 获取布局中控件
     */
    private void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvBeans = (ListView) findViewById(R.id.list_demo_lv_beans);
        //给lv设置适配器
        lvBeans.setAdapter(new CommonAdapter<Bean>(this, mData, R.layout.item_example) {
            @Override
            public void convert(ViewHolder holder, int position) {
                holder.setText(R.id.item_example_tv_title, getItem(position).getTitle())
                        .setText(R.id.item_example_tv_content, getItem(position).getContent())
                        .setText(R.id.item_example_tv_time, getItem(position).getTime())
                        .setText(R.id.item_example_tv_comments, getItem(position).getComments());
            }
        });
    }

}
