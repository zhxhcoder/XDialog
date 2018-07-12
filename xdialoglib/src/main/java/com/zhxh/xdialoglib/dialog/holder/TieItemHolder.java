package com.zhxh.xdialoglib.dialog.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhxh.xdialoglib.R;
import com.zhxh.xdialoglib.dialog.bean.TieBean;
import com.zhxh.xdialoglib.dialog.listener.OnItemClickListener;


public class TieItemHolder extends SuperItemHolder<TieBean> {


    LinearLayout llTie;
    TextView tvTitle;

    public TieItemHolder(Context mContext, OnItemClickListener listener, View itemView) {
        super(mContext, listener, itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        llTie = (LinearLayout) itemView.findViewById(R.id.ll_tie);
    }

    @Override
    public void refreshView() {
        /**
         * 1top 2midle 3bottom 4all
         */
        if (itemPositionType == 1) {
            llTie.setBackgroundResource(R.drawable.dialogui_selector_all_top);
        } else if (itemPositionType == 3) {
            llTie.setBackgroundResource(R.drawable.dialogui_selector_all_bottom);
        } else if (itemPositionType == 4) {
            llTie.setBackgroundResource(R.drawable.dialogui_selector_all);
        } else {
            llTie.setBackgroundResource(R.drawable.dialogui_selector_all_no);
        }
        TieBean data = getData();
        tvTitle.setText("" + data.getTitle());
    }
}
