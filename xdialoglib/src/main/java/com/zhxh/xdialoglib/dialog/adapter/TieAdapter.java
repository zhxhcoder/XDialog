package com.zhxh.xdialoglib.dialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zhxh.xdialoglib.R;
import com.zhxh.xdialoglib.dialog.bean.TieBean;
import com.zhxh.xdialoglib.dialog.holder.SuperItemHolder;
import com.zhxh.xdialoglib.dialog.holder.TieItemHolder;

import java.util.List;


public class TieAdapter extends BaseAdapter<TieBean> {

    private boolean isItemType;

    public TieAdapter(Context mContext, List<TieBean> list, boolean isItemType) {
        super(mContext, list);
        this.isItemType = isItemType;
    }

    public TieAdapter(Context mContext, List<TieBean> list) {
        super(mContext, list);
    }

    @Override
    public SuperItemHolder getItemHolder(ViewGroup parent, int viewType) {
        return new TieItemHolder(mContext, mListener, LayoutInflater.from(mContext).
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
