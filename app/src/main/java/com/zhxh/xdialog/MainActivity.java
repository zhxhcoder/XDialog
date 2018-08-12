package com.zhxh.xdialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnDialog).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DialogActivity.class)));
        findViewById(R.id.btnDialogFragment).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TestActivity.class)));
    }
}
