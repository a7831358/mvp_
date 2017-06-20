package com.example.x.mvp_kaoshi.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.x.mvp_kaoshi.Base.BaseFragment;

import java.util.List;

/**
 * Created by X on 2017/6/14.
 */

public class MyAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> list;
    private FragmentManager fm;

    public MyAdapter(List<BaseFragment> list,FragmentManager fm){
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
