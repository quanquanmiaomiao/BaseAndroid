
package com.base.baselibrary.utils.okgo;


import com.base.baselibrary.base.BaseActivity;
import com.base.baselibrary.base.BaseFragment;
import com.lzy.okgo.request.base.Request;


public abstract class DialogCallback<T> extends JsonCallback<T> {


    public DialogCallback(BaseActivity activity) {
        super();
    }

    protected DialogCallback(BaseFragment mFragment) {
        super();
    }


    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
    }


    @Override
    public void onFinish() {


    }
}
