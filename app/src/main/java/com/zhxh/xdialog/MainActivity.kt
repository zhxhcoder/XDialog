package com.zhxh.xdialog

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btnToast).setOnClickListener { v -> startActivity(Intent(this@MainActivity, ToastActivity::class.java)) }
        findViewById<View>(R.id.btnDialog).setOnClickListener { v -> startActivity(Intent(this@MainActivity, DialogActivity::class.java)) }
        findViewById<View>(R.id.btnDialogFragment).setOnClickListener { v -> startActivity(Intent(this@MainActivity, TestActivity::class.java)) }
    }
}
