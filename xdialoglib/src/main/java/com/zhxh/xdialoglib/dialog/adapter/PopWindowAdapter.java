package com.zhxh.xdialoglib.dialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhxh.xdialoglib.R;
import com.zhxh.xdialoglib.dialog.bean.PopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhxh on 2018/7/5
 */
public class PopWindowAdapter extends BaseAdapter {
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 供下拉的集合包括id
     */
    List<PopBean> list;
    private LayoutInflater inflater;

    public PopWindowAdapter(Context mContext, List<PopBean> lists) {
        this.mContext = mContext;
        this.list = lists;
        if (list == null) {
            list = new ArrayList<PopBean>();
        }
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.xdialog_popu_option_item, null);

            holder.textView = (TextView) convertView
                    .findViewById(R.id.customui_item_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(list.get(position).getTitle());


        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }

}
