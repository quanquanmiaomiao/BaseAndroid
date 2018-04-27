package com.base.baselibrary.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;


/**
 * Author  : cwj
 * Data    : 2017/11/17 19:01
 * Explain : 请在此输入文件说明
 */

public abstract class BaseActivity extends AutoLayoutActivity {
    protected Context mContext;
    protected BaseActivity mActivity;
    //根view
    protected View mRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        mContext = this;
        mActivity = this;
        mRoot = getRootView();
        setContentView(mRoot);
        initView();
        initData();
        ButterKnife.bind(this);
    }


    /**
     * 进行获取根部的View
     */
    public abstract View getRootView();

    /**
     * 进行初始化相关的View
     */
    public abstract void initView();

    /**
     * 进行初始化相关的数据
     */
    public abstract void initData();


    /**
     * 隐藏软件
     */
    protected void hideSoftInputKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View focusView = getCurrentFocus();
        if (focusView != null) {
            IBinder binder = focusView.getWindowToken();
            if (binder != null && inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(binder, 0);
            }
        }
    }

    /**
     * 防止用户在系统设置大字体导致App适配问题
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
