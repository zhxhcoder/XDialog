package com.zhxh.xdialoglib.dialog.listener;

import java.util.List;

public interface RefreshableListener {
    public void refresh(List newData);

    public void addAll(List newData);

    public void clear();

    public void delete(int position);

    public void add(Object object);
}
