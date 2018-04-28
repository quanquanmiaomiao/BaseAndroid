package com.base.baselibrary.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.base.baselibrary.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by quanquan on 2018/2/7.
 *
 * 加载数据效果
 */

public class LoadingDialog extends Dialog {

    private View view;
    private RelativeLayout rlRoot;
    private ImageView ivLoading;


    public LoadingDialog(Context context) {
        super(context, R.style.BaseDialog);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        setContentView(view);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        ivLoading = view.findViewById(R.id.iv_loading);
        rlRoot = view.findViewById(R.id.rl_root);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        Glide.with(context)
                .applyDefaultRequestOptions(options)
                .load(R.drawable.ic_loading).into(ivLoading);
        rlRoot.setLayoutParams(new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

    }
}
