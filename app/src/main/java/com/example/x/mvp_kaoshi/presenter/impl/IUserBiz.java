package com.example.x.mvp_kaoshi.presenter.impl;

import com.example.x.mvp_kaoshi.View.OnLoginListener;

/**
 * Created by X on 2017/6/15.
 */
public interface IUserBiz {
    public void Login(String name, String password, OnLoginListener listener);

}
