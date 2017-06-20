package com.example.x.mvp_kaoshi.presenter.impl.impl;


import com.example.x.mvp_kaoshi.modle.UserBean;
import com.example.x.mvp_kaoshi.presenter.impl.IUserBiz;
import com.example.x.mvp_kaoshi.View.OnLoginListener;

/**
 * Created by X on 2017/6/15.
 */
public class UserBiz implements IUserBiz {





    @Override
    public void Login(final String name, final String password, final OnLoginListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                //耗时操作
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!("").equals(name)&&!("").equals(password)){





                    UserBean bean=new UserBean();
                    bean.setName(name);
                    bean.setPassword(password);

                    listener.success(bean);


                }else {
                    listener.failed();
                }

            }
        }).start();
    }
}
