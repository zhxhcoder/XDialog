package com.zhxh.xdialoglib;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by zhxh on 2018/6/29
 */
public class CommonDropDownView {

    private Context context;

    private View view;

    private Handler handler;

    public PopupWindow popupwindow;

    private int height = 0;

    private int width = 0;

    private View popView;

    private int selectIndex = 0;

    private String[] customArray;

    private boolean isShowUp = false;

    private int viewType = 0;

    int selectColor;

    int density = 3;

    public CommonDropDownView(Context context, View view, Handler handler, String[] showArray, int selectIndex) {

        isShowUp = false;
        this.context = context;
        this.view = view;
        this.handler = handler;
        this.customArray = showArray;
        this.selectIndex = selectIndex;
        createAutoDialog();
    }

    public CommonDropDownView(int viewType, Context context, View view, Handler handler, String[] showArray, int selectIndex) {
        this.viewType = viewType;
        isShowUp = false;
        this.context = context;
        this.view = view;
        this.handler = handler;
        this.customArray = showArray;
        this.selectIndex = selectIndex;
        createAutoDialog();
    }

    public CommonDropDownView(Context context, View view, Handler handler, String[] showArray, int selectIndex, boolean isShowUp) {

        this.context = context;
        this.view = view;
        this.handler = handler;
        this.customArray = showArray;
        this.selectIndex = selectIndex;
        this.isShowUp = isShowUp;
        createAutoDialog();
    }


    private void createAutoDialog() {

        selectColor = context.getResources().getColor(R.color.C16);
        if (viewType == 1) {
            selectColor = context.getResources().getColor(R.color.C13);
        }

        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflate.inflate(R.layout.pop_common_drop_down, null);

        if (isShowUp) {
            popupView.setBackgroundResource(R.drawable.topicchoose_down);
        } else {
            popupView.setBackgroundResource(R.drawable.topicchoose);
        }

        popupView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                dismiss();
                return false;
            }
        });

        final LinearLayout ll_pop_layout;

        ll_pop_layout = (LinearLayout) popupView.findViewById(R.id.ll_pop_layout);

        for (int i = 0; i < customArray.length; i++) {

            int j;
            int tempIndex;

            if (isShowUp) {
                j = customArray.length - 1 - i;
                tempIndex = selectIndex;
            } else {
                j = i;
                tempIndex = selectIndex;
            }

            View spaceLine = new View(context);
            spaceLine.setBackgroundColor(0xFF5c5d5d);
            LinearLayout.LayoutParams lineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1);
            spaceLine.setLayoutParams(lineParams);
            spaceLine.setPadding(10, 0, 10, 0);

            TextView textView = new TextView(context);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            textView.setText(customArray[j]);

            if (j == tempIndex) {
                textView.setTextColor(selectColor);
            } else {
                textView.setTextColor(context.getResources().getColor(R.color.C9));
            }

            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(textViewParams);

            if (j == 0 || j == customArray.length - 1) {
                textView.setPadding(0, getDensityValue(10, context), 0, getDensityValue(10, context));
            } else {
                textView.setPadding(0, getDensityValue(12, context), 0, getDensityValue(12, context));
            }
            textView.setBackgroundResource(R.drawable.trade_button_bg);

            ll_pop_layout.addView(textView);
            if (!isShowUp && j != customArray.length - 1)
                ll_pop_layout.addView(spaceLine);
            if (isShowUp && j != 0)
                ll_pop_layout.addView(spaceLine);

            textView.setOnClickListener(new CommonDropDownView.ClickTextView(j, ll_pop_layout));

        }

        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        ll_pop_layout.measure(w, h);
        this.popView = ll_pop_layout;
        view.measure(w, h);
        width = ll_pop_layout.getMeasuredWidth();
        height = ll_pop_layout.getMeasuredHeight();
        int[] location = new int[2];
        view.getLocationOnScreen(location);

        popupwindow = new PopupWindow(popupView, width, height);
        popupwindow.setTouchable(true); // 设置PopupWindow可触摸
        popupwindow.setOutsideTouchable(true);
        popupwindow.setFocusable(true);
        popupwindow.setBackgroundDrawable(new BitmapDrawable());

        popupwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                handler.sendEmptyMessage(-2);
            }
        });

    }

    private int getDensityValue(int i, Context context) {
        return density * i;
    }


    public void dismiss() {

        if (popupwindow != null && popupwindow.isShowing()) {

            popupwindow.dismiss();
        }
    }

    public void show() {

        int[] location = new int[2];

        view.getLocationInWindow(location);
        //为popWindow添加动画效果
        popupwindow.setAnimationStyle(R.style.popWindow_animation);
        popupwindow.showAtLocation(view, Gravity.TOP, location[0] - width * 3 / 2, location[1] - height - 15);
    }

    public void showPublish() {

        int[] location = new int[2];

        view.getLocationInWindow(location);
        popupwindow.setAnimationStyle(R.style.popWindow_animation);
        popupwindow.showAtLocation(view, Gravity.TOP, location[0] - width * 5 / 4 + getDensityValue(12, context), location[1] - height - 15);

    }

    public void show(int x, int y) {

        int[] location = new int[2];

        view.getLocationInWindow(location);
        //为popWindow添加动画效果
        popupwindow.setAnimationStyle(R.style.popWindow_animation);
        popupwindow.showAtLocation(view, Gravity.TOP, x, y);
    }

    public void show(int y) {

        int[] location = new int[2];

        view.getLocationInWindow(location);
        //为popWindow添加动画效果
        popupwindow.setAnimationStyle(R.style.popWindow_animation);
        popupwindow.showAtLocation(view, Gravity.TOP, location[0] - width * 3 / 2, y);
    }

    public void showOnViewBottom() {

        int[] location = new int[2];

        view.getLocationInWindow(location);
        //为popWindow添加动画效果
        popupwindow.setAnimationStyle(R.style.popWindow_animation1);
        if (location[1] > 320 * density) {
            popupwindow.showAsDropDown(view, location[0] - width * 3 / 2, (int) (-height - 16 * density));
        } else {
            popupwindow.showAsDropDown(view, location[0] - width * 3 / 2, 0);
        }
        popupwindow.update();
    }


    class ClickTextView implements View.OnClickListener {

        int position;
        LinearLayout linearLayout;

        public ClickTextView(int position, LinearLayout linearLayout) {

            this.position = position;
            this.linearLayout = linearLayout;
        }

        @Override
        public void onClick(View v) {

            int childCount = linearLayout.getChildCount();

            for (int i = 0; i < childCount; i++) {

                View view = linearLayout.getChildAt(i);

                if (view instanceof TextView) {

                    ((TextView) view).setTextColor(context.getResources().getColor(R.color.C9));
                }
            }

            TextView textView = (TextView) v;
            textView.setTextColor(selectColor);
            handler.sendEmptyMessage(position);
            dismiss();
        }

    }

}
