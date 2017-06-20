package com.example.x.mvp_kaoshi.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.x.mvp_kaoshi.Base.BaseActivity;
import com.example.x.mvp_kaoshi.R;
import com.example.x.mvp_kaoshi.View.SwitchMainViewI;
import com.example.x.mvp_kaoshi.ui.fragment.Spfragment;
import com.example.x.mvp_kaoshi.ui.fragment.Wxfragment;
import com.example.x.mvp_kaoshi.ui.fragment.Wyfragment;

public class ZhuyemianActivity extends BaseActivity implements SwitchMainViewI{

    private FragmentManager fm;
    private Wxfragment wxfragment;
    private Wyfragment wyfragment;
    private Spfragment spfragment;
    private FragmentTransaction ft;
    private LinearLayout mLl_wx,mLl_wy,mLl_sp;

    private String[] tags={"wx","wy","sp"};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_zhuyemian);
//    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_zhuyemian);
        fm=getSupportFragmentManager();

        mLl_wx=(LinearLayout)findViewById(R.id.mLl_wx);
        mLl_wy=(LinearLayout)findViewById(R.id.mLl_wy);
        mLl_sp=(LinearLayout)findViewById(R.id.mLl_sp);

        swichPages();


    }

    @Override
    public void initData() {
        wxfragment=new Wxfragment();
        wyfragment=new Wyfragment();
        spfragment=new Spfragment();

    }

    @Override
    public void swichPages() {
        mLl_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fm,wxfragment,"wx");

            }
        });
        mLl_wy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fm,wyfragment,"wy");

            }
        });
        mLl_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(fm,spfragment,"sp");

            }
        });


    }

    @Override
    public void showFragment(FragmentManager fm, Fragment fragment, String s) {
        ft=fm.beginTransaction();
        for (String tag:tags){

            if(!tag.equals(s)){
                Fragment fragmentTemp=fm.findFragmentByTag(tag);
                if(fragmentTemp!=null){
                    ft.hide(fragmentTemp);
                }
            }
        }
        if(fm.findFragmentByTag(s)==null){
            ft.add(R.id.mMyfragment,fragment,s);
        }
        ft.show(fragment);
        ft.commit();

    }
}
