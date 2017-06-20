package com.example.x.mvp_kaoshi.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import com.example.x.mvp_kaoshi.Base.BaseFragment;
import com.example.x.mvp_kaoshi.R;

/**
 * Created by X on 2017/6/15.
 */

public class Bbfragment extends BaseFragment {

    private ImageView mImg;
    @Override
    public View initView() {
        View v=View.inflate(getActivity(), R.layout.bfragment_layout,null);
        mImg=(ImageView)f(v,R.id.mImg);
        return v;

    }

    @Override
    public void initList() {

    }

    @Override
    public void setOnclick() {

    }

    @Override
    protected void Start() {

    }
}
