package com.zhxh.xdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zhxh.xdialog.component.QuantDkMainDialog;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.btnRed).setOnClickListener(v -> {
            QuantDkMainDialog dialog = QuantDkMainDialog.Companion.newInstance(1);
            dialog.show(getSupportFragmentManager(), "");
        });
    }
}
