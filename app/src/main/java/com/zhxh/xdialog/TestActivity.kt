package com.zhxh.xdialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView

import com.zhxh.xdialog.component.QuantDkMainDialog

import java.util.concurrent.TimeUnit

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TestActivity : AppCompatActivity() {

    private var dialogType = 1
    private var btnRed: Button? = null
    private var tvTime: TextView? = null
    private val TAG = "zhxh_debug"
    private val LINE_SEPARATOR = "\n"

    private val observer: Observer<String>
        get() = object : Observer<String> {

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: String) {
                tvTime!!.append(LINE_SEPARATOR)
                tvTime!!.append(" onNext : value : $value")
                tvTime!!.append(LINE_SEPARATOR)
                Log.d(TAG, " onNext : value : $value")
            }

            override fun onError(e: Throwable) {
                tvTime!!.append(" onError : " + e.message)
                tvTime!!.append(LINE_SEPARATOR)
                Log.d(TAG, " onError : " + e.message)
            }

            override fun onComplete() {
                tvTime!!.append(LINE_SEPARATOR)
                tvTime!!.append(" onComplete")
                tvTime!!.append(LINE_SEPARATOR)
                Log.d(TAG, " onComplete")
            }
        }

    private val observable: Observable<String>
        get() = Observable.just("haha")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        btnRed = findViewById(R.id.btnRed)
        tvTime = findViewById(R.id.tvTime)

        btnRed!!.text = "对话框" + dialogType.toString()

        btnRed!!.setOnClickListener { v ->

            btnRed!!.text = "对话框" + dialogType.toString()

            val dialog = QuantDkMainDialog.newInstance(dialogType)
            dialog.show(supportFragmentManager, "")

            dialogType = dialogType++ % 3 + 1


            //TODO 倒计时
            observable.delay(6, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer)

        }

    }
}
