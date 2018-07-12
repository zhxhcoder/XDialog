package com.zhxh.xdialoglib.dialog.listener;

import java.util.List;

public interface RefreshableListener {
    void refresh(List newData);

    void addAll(List newData);

    void clear();

    void delete(int position);

    void add(Object object);
}
