package com.base.baselibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.base.baselibrary.R;


/**
 * Created by quanquan on 2018/4/27.
 * 顶部导航栏
 */

public class TopBar extends View {

    // 控件
    private TextView tvLeft;
    private TextView tvTitle;
    private TextView tvRight;
    // 属性
    private String leftStr;
    private int leftIcon;
    private int leftColor;
    private String titleStr;
    private int titleColor;
    private String rightStr;
    private int rightIcon;
    private int rightColor;
    // 事件
    private OnClickLeftListener leftListener;
    private OnClickRightListener rightListener;
    private Context context;

    public TopBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(attrs);
    }

    private void initView(AttributeSet attrs){
        // 读取配置
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TOP_BAR);
        leftStr = array.getString(R.styleable.TOP_BAR_leftTxt);
        leftIcon = array.getResourceId(R.styleable.TOP_BAR_leftIcon,0);
        leftColor = array.getResourceId(R.styleable.TOP_BAR_leftColor,0);
        titleStr = array.getString(R.styleable.TOP_BAR_titleTxt);
        titleColor = array.getResourceId(R.styleable.TOP_BAR_titleColor,0);
        rightStr = array.getString(R.styleable.TOP_BAR_rightTxt);
        rightIcon = array.getResourceId(R.styleable.TOP_BAR_rightIcon,0);
        rightColor = array.getResourceId(R.styleable.TOP_BAR_rightColor,0);
        View view = View.inflate(context, R.layout.view_top_bar, null);
        tvLeft = view.findViewById(R.id.tv_left);
        tvTitle = view.findViewById(R.id.tv_title);
        tvRight = view.findViewById(R.id.tv_right);
        if(!TextUtils.isEmpty(leftStr)){
            setLeftTxt(leftStr);        }
        if (leftIcon!=0){
            setLeftDrawable(leftIcon);
        }
        if (leftColor!=0){
            tvLeft.setTextColor(leftColor);
        }
        if(!TextUtils.isEmpty(titleStr)){
            setTitleTxt(titleStr);
        }
        if (titleColor!=0){
            tvTitle.setTextColor(titleColor);
        }
        if(TextUtils.isEmpty(rightStr)){
            setRightTxt(rightStr);
        }
        if (rightIcon!=0){
            setRightDrawable(rightIcon);
        }
        if (rightColor!=0){
            tvRight.setTextColor(rightColor);
        }

        tvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftListener!=null){
                    leftListener.onLeftClick(view);
                }
            }
        });

        tvRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rightListener!=null){
                    rightListener.onRightClick(view);
                }
            }
        });
    }



    /**
     * 设置左边按钮的可见状态
     *
     * @param visibility
     */
    public void setLeftVisibility(int visibility){
        tvLeft.setVisibility(visibility);
    }


    /**
     * 设置左边按钮的文本
     *
     * @param str
     */
    public void setLeftTxt(String str){
        if(tvLeft!=null){
            tvLeft.setText(str);
        }
    }

    /**
     * 设置左边按钮的文本颜色
     *
     * @param color
     */
    public void setLeftColor(String color){
        if(tvLeft!=null){
            tvLeft.setTextColor(Color.parseColor(color));
        }
    }

    /**
     * 设置左边按钮的图标
     *
     * @param resourcesId
     */
    public void setLeftDrawable(int resourcesId){
        Drawable drawable = context.getResources().getDrawable(resourcesId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        if (drawable!=null){
            tvLeft.setCompoundDrawables(drawable,null,null,null);
            tvLeft.setCompoundDrawablePadding(10);
        }
    }

    /**
     * 设置标题按钮的文本
     *
     * @param str
     */
    public void setTitleTxt(String str){
        if(tvTitle!=null){
            tvTitle.setText(str);
        }
    }


    /**
     * 设置标题按钮的文本颜色
     *
     * @param color
     */
    public void setTitleColor(String color){
        if(tvTitle!=null){
            tvTitle.setTextColor(Color.parseColor(color));
        }
    }

    /**
     * 设置标题按钮的可见状态
     *
     * @param visibility
     */
    public void setTitleVisibility(int visibility){
        tvTitle.setVisibility(visibility);
    }


    /**
     * 设置右边按钮的文本
     *
     * @param str
     */
    public void setRightTxt(String str){
        if(tvRight!=null){
            tvRight.setText(str);
        }
    }

    /**
     * 设置右边按钮的字体颜色
     *
     * @param color
     */
    public void setRightColor(String color){
        if(tvRight!=null){
            tvRight.setTextColor(Color.parseColor(color));
        }
    }

    /**
     * 设置右边按钮的图标
     *
     * @param resourcesId
     */
    public void setRightDrawable(int resourcesId){
        Drawable drawable = context.getResources().getDrawable(resourcesId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        if (drawable!=null){
            tvRight.setCompoundDrawables(drawable,null,null,null);
            tvRight.setCompoundDrawablePadding(10);
        }
    }


    /**
     * 设置右边按钮的可见状态
     *
     * @param visibility
     */
    public void setRightVisibility(int visibility){
        tvRight.setVisibility(visibility);
    }


    /**
     * 设置左边按钮的回调
     *
     * @param listener
     */
    public void setOnClickLeftListener(OnClickLeftListener listener){
        leftListener = listener;
    }


    /**
     * 设置右边按钮的回调
     *
     * @param listener
     */
    public void setOnClickRightListener(OnClickRightListener listener){
        rightListener = listener;
    }

    public interface OnClickLeftListener{
        void onLeftClick(View view);
    }

    public interface OnClickRightListener{
        void onRightClick(View view);
    }
}
