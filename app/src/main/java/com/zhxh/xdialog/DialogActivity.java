package com.zhxh.xdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zhxh.xdialoglib.DialogUtils;
import com.zhxh.xdialoglib.dialog.adapter.BottomAdapter;
import com.zhxh.xdialoglib.dialog.bean.BuildBean;
import com.zhxh.xdialoglib.dialog.bean.PopBean;
import com.zhxh.xdialoglib.dialog.bean.BottomBean;
import com.zhxh.xdialoglib.dialog.listener.DialogUIDateTimeSaveListener;
import com.zhxh.xdialoglib.dialog.listener.DialogUIItemListener;
import com.zhxh.xdialoglib.dialog.listener.DialogUIListener;
import com.zhxh.xdialoglib.dialog.listener.IDropListener;
import com.zhxh.xdialoglib.dialog.widget.DateSelectorWheelView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhxh on 2018/7/5
 */
public class DialogActivity extends AppCompatActivity {

    Activity mActivity;
    Context mContext;
    @BindView(R.id.ll_main)
    LinearLayout ll_main;
    @BindView(R.id.btn_pop)
    Button btn_pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        mActivity = this;
        mContext = getApplication();
        DialogUtils.init(mContext);
    }

    String msg = "哈哈哈哈哈哈哈哈哈或或";

    @OnClick({R.id.btn_custom_alert, R.id.btn_custom_bottom_alert, R.id.btn_system_alert, R.id.btn_loading, R.id.btn_md_loading, R.id.btn_md_alert, R.id.btn_tie_alert,
            R.id.btn_bottom_sheet_cancel, R.id.btn_center_sheet, R.id.btn_alert_input,
            R.id.btn_alert_multichoose, R.id.btn_alert_singlechoose, R.id.btn_md_bottom_vertical, R.id.btn_md_bottom_horizontal,
            R.id.btn_toast_top, R.id.btn_toast_center, R.id.btn_toast,
            R.id.btn_select_ymd, R.id.btn_select_ymdhm, R.id.btn_select_ymdhms, R.id.btn_pop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pop:
                DialogUtils.showPopWindow(mContext, LinearLayout.LayoutParams.MATCH_PARENT, 4, btn_pop, new IDropListener() {
                    @Override
                    public void initPopData(List<PopBean> lists) {
                        for (int i = 0; i < 5; i++) {
                            PopBean popu = new PopBean();
                            popu.setTitle("item" + i);
                            popu.setId(i);
                            lists.add(popu);
                        }
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position) {
                    }
                });
                break;
            case R.id.btn_custom_alert:
                View rootView = View.inflate(mActivity, R.layout.custom_dialog_layout, null);
                final Dialog dialog = DialogUtils.showCustomAlert(this, rootView, Gravity.CENTER, true, false).show();
                rootView.findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUtils.dismiss(dialog);
                    }
                });
                break;
            case R.id.btn_custom_bottom_alert:
                View rootViewB = View.inflate(mActivity, R.layout.custom_dialog_bottom_layout, null);
                DialogUtils.showCustomBottomAlert(this, rootViewB).show();
                break;
            case R.id.btn_system_alert:
                new AlertDialog
                        .Builder(mActivity)
                        .setTitle("标题")
                        .setMessage("这是内容")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .create()
                        .show();
                break;
            case R.id.btn_loading:
                DialogUtils.showLoading(this, "加载中...", false, true, true, true).show();
                break;
            case R.id.btn_md_loading:
                DialogUtils.showMdLoading(this, "加载中...", true, true, true, true).show();
                break;

            case R.id.btn_alert_multichoose:
                String[] words = new String[]{"1", "2", "3"};
                boolean[] choseDefault = new boolean[]{false, false, false};
                DialogUtils.showMdMultiChoose(mActivity, "标题", words, choseDefault, new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }
                }).show();
                break;
            case R.id.btn_alert_singlechoose:
                String[] words2 = new String[]{"1", "2", "3"};
                DialogUtils.showSingleChoose(mActivity, "单选", 0, words2, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "--" + position);
                    }
                }).show();
                break;
            case R.id.btn_md_alert:
                DialogUtils.showMdAlert(mActivity, "标题", msg, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        showToast("onPositive");
                    }

                    @Override
                    public void onNegative() {
                        showToast("onNegative");
                    }

                }).show();
                break;
            case R.id.btn_tie_alert:
                DialogUtils.showAlert(mActivity, "标题", msg, "", "", "确定", "", true, true, true, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        showToast("onPositive");
                    }

                    @Override
                    public void onNegative() {
                        showToast("onNegative");
                    }

                }).show();
                break;
            case R.id.btn_alert_input:
                DialogUtils.showAlert(mActivity, "登录", "", "请输入用户名", "请输入密码", "登录", "取消", false, true, true, new DialogUIListener() {
                    @Override
                    public void onPositive() {

                    }

                    @Override
                    public void onNegative() {

                    }

                    @Override
                    public void onGetInput(CharSequence input1, CharSequence input2) {
                        super.onGetInput(input1, input2);
                        showToast("input1:" + input1 + "--input2:" + input2);
                    }
                }).show();
                break;
            case R.id.btn_center_sheet: {
                List<BottomBean> strings = new ArrayList<BottomBean>();
                strings.add(new BottomBean("1"));
                strings.add(new BottomBean("2"));
                strings.add(new BottomBean("3"));
                DialogUtils.showSheet(mActivity, strings, "", Gravity.CENTER, true, true, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text);
                    }
                }).show();
            }
            break;
            case R.id.btn_bottom_sheet_cancel: {
                List<BottomBean> strings = new ArrayList<BottomBean>();
                strings.add(new BottomBean("1"));
                strings.add(new BottomBean("2"));
                strings.add(new BottomBean("3"));
                DialogUtils.showSheet(mActivity, strings, "取消", Gravity.BOTTOM, true, true, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("取消");
                    }
                }).show();
            }
            break;
            case R.id.btn_md_bottom_vertical:
                List<BottomBean> datas2 = new ArrayList<BottomBean>();
                datas2.add(new BottomBean("1"));
                datas2.add(new BottomBean("2"));
                datas2.add(new BottomBean("3"));
                datas2.add(new BottomBean("4"));
                datas2.add(new BottomBean("5"));
                datas2.add(new BottomBean("6"));
                BottomAdapter adapter = new BottomAdapter(mContext, datas2, true);
                BuildBean buildBean = DialogUtils.showMdBottomSheet(mActivity, true, "", datas2, 0, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }
                });
                buildBean.mAdapter = adapter;
                buildBean.show();
                break;
            case R.id.btn_md_bottom_horizontal:
                List<BottomBean> datas3 = new ArrayList<BottomBean>();
                datas3.add(new BottomBean("1"));
                datas3.add(new BottomBean("2"));
                datas3.add(new BottomBean("3"));
                datas3.add(new BottomBean("4"));
                datas3.add(new BottomBean("5"));
                datas3.add(new BottomBean("6"));
                DialogUtils.showMdBottomSheet(mActivity, false, "标题", datas3, 4, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        showToast(text + "---" + position);
                    }
                }).show();
                break;

            case R.id.btn_toast_top:
                DialogUtils.showToastTop("上部的Toast弹出方式");
                break;
            case R.id.btn_toast_center:
                DialogUtils.showToastCenter("中部的Toast弹出方式");
                break;
            case R.id.btn_toast:
                DialogUtils.showToast("默认的Toast弹出方式");
                break;
            case R.id.btn_select_ymd: {
                DialogUtils.showDatePick(mActivity, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDD, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

                    }
                }).show();
            }
            break;
            case R.id.btn_select_ymdhm: {
                DialogUtils.showDatePick(mActivity, Gravity.CENTER, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMM, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

                    }
                }).show();
            }
            break;
            case R.id.btn_select_ymdhms: {
                DialogUtils.showDatePick(mActivity, Gravity.BOTTOM, "选择日期", System.currentTimeMillis() + 60000, DateSelectorWheelView.TYPE_YYYYMMDDHHMMSS, 0, new DialogUIDateTimeSaveListener() {
                    @Override
                    public void onSaveSelectedDate(int tag, String selectedDate) {

                    }
                }).show();
            }
            break;

        }
    }


    public void showToast(CharSequence msg) {
        DialogUtils.showToastLong(msg.toString());
    }
}
