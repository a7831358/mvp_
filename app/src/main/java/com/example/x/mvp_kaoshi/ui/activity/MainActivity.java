package com.example.x.mvp_kaoshi.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.x.mvp_kaoshi.Base.BaseFragment;
import com.example.x.mvp_kaoshi.R;
import com.example.x.mvp_kaoshi.ui.adapter.MyAdapter;
import com.example.x.mvp_kaoshi.ui.fragment.Afragment;
import com.example.x.mvp_kaoshi.ui.fragment.Bbfragment;
import com.example.x.mvp_kaoshi.ui.fragment.Bfragment;
import com.example.x.mvp_kaoshi.ui.fragment.Cfragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private Afragment af;
    private Bfragment bf;
    private Cfragment cf;

    private List<BaseFragment>list;
    private FragmentManager fm;
    private MyAdapter myAdapter;
    private ViewPager mVp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        initView();

    }

    public void initView() {
        mVp=(ViewPager)findViewById(R.id.mVp);

        af=new Afragment();
        bf=new Bfragment();

        cf=new Cfragment();

        list=new ArrayList<>();
        fm=getSupportFragmentManager();
        list.add(af);
        list.add(bf);



        list.add(cf);

        myAdapter=new MyAdapter(list,fm);
        mVp.setAdapter(myAdapter);
    }


}
