package com.zhxh.xdialoglib.dialog.listener;

import android.view.View;
import android.widget.AdapterView;

import com.zhxh.xdialoglib.dialog.bean.PopBean;

import java.util.List;

/**
 * 设置动态下拉框的数据
 */
public interface IDropListener {
    /**
     * 初始化数据
     */
    void initPopData(List<PopBean> lists);

    /**
     * 点击事件
     */
    void onItemClick(AdapterView<?> adapterView, View view, int position);
}