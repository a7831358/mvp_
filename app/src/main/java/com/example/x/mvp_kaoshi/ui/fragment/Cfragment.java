package com.example.x.mvp_kaoshi.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.x.mvp_kaoshi.Base.BaseFragment;
import com.example.x.mvp_kaoshi.R;
import com.example.x.mvp_kaoshi.ui.activity.DengluActivity;

/**
 * Created by X on 2017/6/15.
 */

public class Cfragment extends BaseFragment {

    private ImageView mImg;
    private TextView mTv_du, mTv_tiao;
    private int i;

    @Override
    public View initView() {

        View v = View.inflate(getActivity(), R.layout.cfragment_layout, null);
        mImg = (ImageView) f(v, R.id.mImg);
        mTv_du = (TextView) f(v, R.id.mTv_du);
        mTv_tiao=(TextView)f(v,R.id.mTv_tiao);


        return v;
    }

    @Override
    public void initList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i = 3; i <4; i--) {
                    Message msg = hd.obtainMessage();
                    msg.what = 1;
                    msg.obj = i;
                    hd.sendMessage(msg);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 1) {
                        Intent in = new Intent(getActivity(), DengluActivity.class);
                        startActivity(in);

                        getActivity().finish();

                    }
                }
            }
        }).start();
    }

    @Override
    public void setOnclick() {
        mTv_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
            }
        });

    }

    @Override
    protected void Start() {

    }

    private Handler hd = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                int s = (int) msg.obj;
                mTv_du.setText(s + "");
            }
        }
    };
}
