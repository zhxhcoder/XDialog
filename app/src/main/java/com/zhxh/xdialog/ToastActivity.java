package com.zhxh.xdialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhxh.xdialoglib.toast.XToast;

/**
 * Created by zhxh on 2018/7/5
 */
public class ToastActivity extends AppCompatActivity {
    private long lastBackTime = 0;

    public static final String[] ITEMS = {"通用toast"
            , "强调toast"
            , "可点击toast"
            , "通用 + 成功toast"
            , "通用 + 警告toast"
            , "通用 + 错误toast"
            , "强调 + 成功toast"
            , "强调 + 警告toast"
            , "强调 + 错误toast"
            , "可点击 + 成功toast"
            , "可点击 + 警告toast"
            , "可点击 + 错误toast"};
    private static final int REQUEST_PERMISSION_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_layout);
        ListView listView = findViewById(R.id.listview);
        final View.OnClickListener onClickListener = v -> Log.d("ToastActivity", "clicked!!!");
        listView.setAdapter(new ArrayAdapter(ToastActivity.this, R.layout.toast_item, ITEMS));
        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (!requestPermission()) {
                return;
            }
            switch (position) {
                case 0:
                    XToast.makeText(ToastActivity.this, "关注成功", XToast.LENGTH_SHORT, XToast.UNIVERSAL)
                            .setGravity(Gravity.CENTER, 0, 0)
                            .setIcon(R.drawable.ic_toast_done_white_24dp)
                            .show();
                    break;
                case 1:
                    XToast.makeText(ToastActivity.this, "关注成功", XToast.LENGTH_SHORT, XToast.EMPHASIZE)
                            .setIcon(R.drawable.ic_toast_check_circle_white_24dp)
                            .show();
                    break;
                case 2:
                    XToast.makeText(ToastActivity.this, "关注成功", XToast.LENGTH_SHORT, XToast.CLICKABLE)
                            .setIcon(R.drawable.ic_toast_done_white_24dp)
                            .setGravity(Gravity.TOP, 0, 0)
                            .setClickCallBack("查看", onClickListener)
                            .show();
                    break;
                case 3:
                    XToast.makeText(ToastActivity.this, "关注成功", XToast.LENGTH_SHORT).showSuccess();
                    break;
                case 4:
                    XToast.makeText(ToastActivity.this, "请先登录", XToast.LENGTH_SHORT).showWarning();
                    break;
                case 5:
                    XToast.makeText(ToastActivity.this, "关注失败", XToast.LENGTH_SHORT).showError();
                    break;
                case 6:
                    XToast.makeText(ToastActivity.this, "关注成功", XToast.LENGTH_SHORT, XToast.EMPHASIZE).showSuccess();
                    break;
                case 7:
                    XToast.makeText(ToastActivity.this, "请先登录", XToast.LENGTH_SHORT, XToast.EMPHASIZE).showWarning();
                    break;
                case 8:
                    XToast.makeText(ToastActivity.this, "关注失败", XToast.LENGTH_SHORT, XToast.EMPHASIZE).showError();
                    break;
                case 9:
                    XToast.makeText(ToastActivity.this, "关注成功", XToast.LENGTH_SHORT, XToast.CLICKABLE)
                            .setClickCallBack("查看", onClickListener)
                            .showSuccess();
                    break;
                case 10:
                    XToast.makeText(ToastActivity.this, "请先登录", XToast.LENGTH_SHORT, XToast.CLICKABLE)
                            .setClickCallBack("查看", onClickListener)
                            .showWarning();
                    break;
                case 11:
                    XToast.makeText(ToastActivity.this, "关注失败", XToast.LENGTH_SHORT, XToast.CLICKABLE)
                            .setClickCallBack("查看", onClickListener)
                            .showError();
                    break;
                default:
            }
        });
    }

    private boolean requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!Settings.canDrawOverlays(this)) {
                XToast.makeText(this, "请允许悬浮窗权限", XToast.LENGTH_SHORT).showWarning();
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, REQUEST_PERMISSION_CODE);
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && requestCode == REQUEST_PERMISSION_CODE) {
            String text = Settings.canDrawOverlays(this) ? "已获取悬浮窗权限" : "请打开悬浮窗权限";
            XToast.makeText(this, text, XToast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastBackTime < 2000) {
            finish();
        } else {
            lastBackTime = System.currentTimeMillis();
            XToast.makeText(this, "再次返回退出应用", XToast.LENGTH_SHORT)
                    .setGravity(Gravity.CENTER, 0, 0)
                    .show();
        }
    }

}
