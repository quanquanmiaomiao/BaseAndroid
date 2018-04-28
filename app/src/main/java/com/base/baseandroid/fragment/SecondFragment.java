package com.base.baseandroid.fragment;

import android.view.View;

import com.base.baseandroid.R;
import com.base.baselibrary.base.BaseFragment;

/**
 * Created by quanquan on 2018/4/28.
 */

public class SecondFragment extends BaseFragment {


    @Override
    public View initView() {
        return View.inflate(getContext(), R.layout.fragment_second,null);
    }


    @Override
    public void initData() {
        super.initData();
    }
}
