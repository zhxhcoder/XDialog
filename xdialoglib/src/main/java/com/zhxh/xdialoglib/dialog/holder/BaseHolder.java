package com.zhxh.xdialoglib.dialog.holder;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;

import com.zhxh.xdialoglib.dialog.bean.BuildBean;
/**
 * Created by zhxh on 2018/7/5
 */
public abstract class BaseHolder {
    public View rootView;

    public BaseHolder(Context context) {
        rootView = View.inflate(context, setLayoutRes(), null);
        findViews();
    }

    protected abstract void findViews();

    protected abstract
    @LayoutRes
    int setLayoutRes();

    /**
     * 一般情况下，实现这个方法就足够了
     *
     * @param context
     * @param bean
     */
    public abstract void assignDatasAndEvents(Context context, BuildBean bean);


}
