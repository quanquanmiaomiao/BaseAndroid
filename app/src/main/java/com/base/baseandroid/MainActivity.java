package com.base.baseandroid;


import android.view.View;
import com.base.baselibrary.base.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    public View getRootView() {
        return View.inflate(this,R.layout.activity_main,null);
    }


    @Override
    public void initView() {
    }


    @Override
    public void initData() {

    }



}
