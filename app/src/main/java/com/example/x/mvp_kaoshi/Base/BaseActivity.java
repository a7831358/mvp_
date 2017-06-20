package com.example.x.mvp_kaoshi.Base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


/**
 * Created by root on 17-6-15.
 */

public abstract class BaseActivity extends FragmentActivity  {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();




}
