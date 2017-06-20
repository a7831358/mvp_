package com.example.x.mvp_kaoshi.View;


import com.example.x.mvp_kaoshi.modle.UserBean;

/**
 * Created by X on 2017/4/14.
 */
public interface IUserLoginViewl {

    String getName();
    String getPassword();

    void clearName();
    void clearPassword();
    void showLoading();
    void hintLoading();
    void toActivity(UserBean bean);
    void loadFailError();

}
