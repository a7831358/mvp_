package com.example.x.mvp_kaoshi.presenter.impl.impl;

import android.os.Handler;

import com.example.x.mvp_kaoshi.View.IUserLoginViewl;
import com.example.x.mvp_kaoshi.modle.UserBean;
import com.example.x.mvp_kaoshi.View.OnLoginListener;

/**
 * Created by X on 2017/6/15.
 */

public class UserLoginPersener {

    private UserBiz userBiz;
    private IUserLoginViewl loginView;
    private Handler handler=new Handler();

    public UserLoginPersener(IUserLoginViewl loginView){

        this.loginView=loginView;
        this.userBiz=new UserBiz();
    }

    public void Login(){

        loginView.showLoading();
        userBiz.Login(loginView.getName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void success(final UserBean bean) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        loginView.toActivity(bean);
                        loginView.hintLoading();
                    }
                });

            }

            @Override
            public void failed() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.loadFailError();
                        loginView.hintLoading();
                    }
                });
            }
        });
    }
    public void clear(){
        loginView.clearName();
        loginView.clearPassword();
    }
}
