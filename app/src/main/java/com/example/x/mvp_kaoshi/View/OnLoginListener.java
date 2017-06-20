package com.example.x.mvp_kaoshi.View;


import com.example.x.mvp_kaoshi.modle.UserBean;

/**
 * Created by X on 2017/6/15.
 */
public interface OnLoginListener {

    public void success(UserBean bean);
    public void failed();
}
