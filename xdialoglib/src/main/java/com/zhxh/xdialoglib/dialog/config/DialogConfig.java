package com.zhxh.xdialoglib.dialog.config;

import android.support.annotation.ColorRes;

import com.zhxh.xdialoglib.R;

public class DialogConfig {

    @ColorRes
    public static int iosBtnColor = R.color.C12;
    @ColorRes
    public static int lvItemTxtColor = R.color.C3;
    @ColorRes
    public static int mdBtnColor = R.color.C2;
    @ColorRes
    public static int titleTxtColor = R.color.C0;
    @ColorRes
    public static int msgTxtColor = R.color.C0;
    @ColorRes
    public static int inputTxtColor = R.color.C4;


    public static CharSequence xdialog_btnTxt1 = "确定";
    public static CharSequence xdialog_btnTxt2 = "取消";
    public static CharSequence xdialog_bottomTxt = "取消";


    public static final int TYPE_LOADING = 1;
    public static final int TYPE_MD_LOADING = 2;
    public static final int TYPE_MD_ALERT = 3;
    public static final int TYPE_MD_MULTI_CHOOSE = 4;
    public static final int TYPE_SINGLE_CHOOSE = 5;
    public static final int TYPE_ALERT = 6;
    public static final int TYPE_SHEET = 10;
    public static final int TYPE_BOTTOM_SHEET = 14;
    public static final int TYPE_CUSTOM_ALERT = 15;
    public static final int TYPE_CUSTOM_BOTTOM_ALERT = 16;
    public static final int TYPE_DATEPICK = 19;


}
