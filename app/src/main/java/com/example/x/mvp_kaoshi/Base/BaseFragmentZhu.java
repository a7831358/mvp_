package com.example.x.mvp_kaoshi.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by X on 2017/6/15.
 */

public abstract  class BaseFragmentZhu extends Fragment {

    public LayoutInflater inflater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.inflater=inflater;
        return initView();
    }

    public void initData(){

    }
    protected abstract View initView();
}
