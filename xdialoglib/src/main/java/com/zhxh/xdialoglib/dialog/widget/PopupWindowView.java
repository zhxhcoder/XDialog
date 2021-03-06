package com.zhxh.xdialoglib.dialog.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.zhxh.xdialoglib.R;
import com.zhxh.xdialoglib.dialog.adapter.PopWindowAdapter;
import com.zhxh.xdialoglib.dialog.bean.PopBean;
import com.zhxh.xdialoglib.dialog.listener.IDropListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhxh on 2018/7/5
 */
public class PopupWindowView implements AdapterView.OnItemClickListener {

    View viewItem = null;
    ListView popupListView;
    PopupWindow pullDownView;// 弹出窗口
    private List<PopBean> popupList = new ArrayList<PopBean>();
    private PopWindowAdapter popWindowAdapter;
    private Context mContext;
    private IDropListener dropListener;
    private int maxLine = 5;

    public PopupWindowView(Context mContext, int widthGravity) {
        this.mContext = mContext;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        viewItem = inflater.inflate(R.layout.xdialog_popu_options, null);
        popupListView = (ListView) viewItem.findViewById(R.id.customui_list);
        popWindowAdapter = new PopWindowAdapter(mContext, popupList);
        popupListView.setAdapter(popWindowAdapter);
        pullDownView = new PopupWindow(viewItem, widthGravity,
                LayoutParams.WRAP_CONTENT, true);
        pullDownView.setOutsideTouchable(true);
        pullDownView.setBackgroundDrawable(new BitmapDrawable());
        popupListView.setOnItemClickListener(this);
    }

    /**
     * 设置下拉框的数据
     */
    public void initPopupData(IDropListener dropListener) {
        this.dropListener = dropListener;
        if (this.dropListener != null) {
            this.dropListener.initPopData(popupList);
        }
        if (popupList != null && popupList.size() > maxLine) {
            pullDownView.setHeight(dip2px(maxLine * 40));
        }
        popWindowAdapter.notifyDataSetChanged();
    }

    private int dip2px(int dip) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * 设置最大行popuWindow
     */
    public void setMaxLines(int maxLines) {
        maxLine = maxLines;
    }

    /**
     * 显示popuWindow
     */
    public void showing(View v) {
        pullDownView.showAsDropDown(v, 0, 0);
    }

    /**
     * 关闭popuWindow
     */
    public void dismiss() {
        pullDownView.dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (dropListener != null) {
            dismiss();
            dropListener.onItemClick(adapterView, view, position);
        }
    }

    /**
     * 获取选择的名称
     */
    public String getTitle(int popuPosition) {
        return popupList.get(popuPosition).getTitle();
    }

    /**
     * 获取选择的id
     */
    public int getId(int popuPosition) {
        return popupList.get(popuPosition).getId();
    }

    /**
     * 获取选择的sid
     */
    public String getSid(int popuPosition) {
        return popupList.get(popuPosition).getSid();
    }

}
