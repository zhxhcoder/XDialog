package com.zhxh.xdialoglib.dialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhxh.xdialoglib.R;
import com.zhxh.xdialoglib.dialog.bean.BottomBean;
import com.zhxh.xdialoglib.dialog.holder.BaseItemHolder;
import com.zhxh.xdialoglib.dialog.holder.BottomItemHolder;

import java.util.List;
/**
 * Created by zhxh on 2018/7/5
 */

public class BottomAdapter extends BaseAdapter<BottomBean> {

    private boolean isItemType;

    public BottomAdapter(Context mContext, List<BottomBean> list, boolean isItemType) {
        super(mContext, list);
        this.isItemType = isItemType;
    }

    public BottomAdapter(Context mContext, List<BottomBean> list) {
        super(mContext, list);
    }

    @Override
    public BaseItemHolder getItemHolder(ViewGroup parent, int viewType) {
        return new BottomItemHolder(mContext, mListener, LayoutInflater.from(mContext).
                inflate(R.layout.xdialog_holder_item_tie, parent, false));
    }

    /**
     * 1top 2midle 3bottom 4all
     */
    protected int countPosition(int position) {
        if (isItemType) {
            if (mDatas.size() == 1) {
                return 4;
            }
            if (mDatas.size() > 1) {
                if (position == 0) {
                    return 1;
                } else if (position == mDatas.size() - 1) {
                    return 3;
                }
            }
            return 2;
        } else {
            return super.countPosition(position);
        }
    }
}
