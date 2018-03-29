package com.base.baselibrary.utils;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Author  : hasee
 * Data    : 2017/4/14 14:24
 * Explain : 对无法使用AutoLayout的控件长宽进行一定程度的百分比适配
 */
public class AutoFixUtil {
    /**
     * 返回百分比适配后的宽度px
     * @return
     */
    public static float fixWidth(float nowPxWidth){
        int designWidth = AutoLayoutConifg.getInstance().getDesignWidth();
        int screenWidth = AutoLayoutConifg.getInstance().getScreenWidth();

        float fNowPxWidth = (float) nowPxWidth;
        float fDesignWidth = (float) designWidth;
        float fScreenWidth = (float) screenWidth;

        float truePXwidth = fScreenWidth * (fNowPxWidth/fDesignWidth);

        return truePXwidth;

    }

    /**
     * 返回百分比适配后的高度px
     * @return
     */
    public static float fixHeight(float nowPxHeight){
        int designHeight = AutoLayoutConifg.getInstance().getDesignWidth();
        int screenHeight = AutoLayoutConifg.getInstance().getScreenWidth();

        float fNowPxHeight = (float) nowPxHeight;
        float fDesignHeight = (float) designHeight;
        float fScreenHeight = (float) screenHeight;

        float trueHeight = fScreenHeight * (fNowPxHeight/fDesignHeight);

        return trueHeight;
    }
}
