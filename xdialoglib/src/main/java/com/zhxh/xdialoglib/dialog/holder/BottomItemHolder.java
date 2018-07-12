package com.zhxh.xdialoglib.dialog.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhxh.xdialoglib.R;
import com.zhxh.xdialoglib.dialog.bean.BottomBean;
import com.zhxh.xdialoglib.dialog.listener.OnItemClickListener;

/**
 * Created by zhxh on 2018/7/5
 */
public class BottomItemHolder extends BaseItemHolder<BottomBean> {

    LinearLayout llBottom;
    TextView tvTitle;

    public BottomItemHolder(Context mContext, OnItemClickListener listener, View itemView) {
        super(mContext, listener, itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        llBottom = (LinearLayout) itemView.findViewById(R.id.ll_tie);
    }

    @Override
    public void refreshView() {
        /**
         * 1top 2midle 3bottom 4all
         */
        if (itemPositionType == 1) {
            llBottom.setBackgroundResource(R.drawable.xdialog_selector_all_top);
        } else if (itemPositionType == 3) {
            llBottom.setBackgroundResource(R.drawable.xdialog_selector_all_bottom);
        } else if (itemPositionType == 4) {
            llBottom.setBackgroundResource(R.drawable.xdialog_selector_all);
        } else {
            llBottom.setBackgroundResource(R.drawable.xdialog_selector_all_no);
        }
        BottomBean data = getData();
        tvTitle.setText("" + data.getTitle());
    }
}
