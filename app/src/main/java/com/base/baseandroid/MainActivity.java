package com.base.baseandroid;


import android.view.View;

import com.base.baseandroid.fragment.FourFragment;
import com.base.baseandroid.fragment.FristFragment;
import com.base.baseandroid.fragment.SecondFragment;
import com.base.baseandroid.fragment.ThridFragment;
import com.base.baselibrary.base.BaseActivity;
import com.base.baselibrary.view.BottomBar;




public class MainActivity extends BaseActivity {


   private BottomBar bottomBar;

    @Override
    public View getRootView() {
        return View.inflate(this,R.layout.activity_main,null);
    }


    @Override
    public void initView() {
        bottomBar = findViewById(R.id.bottom_bar);
        initBottomBar();
    }


    @Override
    public void initData() {

    }


    private void initBottomBar(){
        if (bottomBar!=null){
            bottomBar.setContainer(R.id.fr_layout)
                    .setTitleBeforeAndAfterColor("#999999", "#ff5d5e")
                    .addItem(FristFragment.class,"第一页",R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
                    .addItem(SecondFragment.class,"第二页",R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
                    .addItem(ThridFragment.class,"第三页",R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
                    .addItem(FourFragment.class,"第四页",R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round)
                    .build();
        }
    }
}
