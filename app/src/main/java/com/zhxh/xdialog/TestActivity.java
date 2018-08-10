package com.zhxh.xdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhxh.xdialog.component.QuantDkMainDialog;

public class TestActivity extends AppCompatActivity {

    private int dialogType = 1;
    private Button btnRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnRed = findViewById(R.id.btnRed);

        btnRed.setText("对话框" + String.valueOf(dialogType));

        btnRed.setOnClickListener(v -> {

            btnRed.setText("对话框" + String.valueOf(dialogType));

            QuantDkMainDialog dialog = QuantDkMainDialog.Companion.newInstance(dialogType);
            dialog.show(getSupportFragmentManager(), "");

            dialogType = (dialogType++) % 3 + 1;
        });
    }
}
