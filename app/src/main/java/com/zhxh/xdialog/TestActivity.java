package com.zhxh.xdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.zhxh.xdialog.component.QuantDkMainDialog;

import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestActivity extends AppCompatActivity {

    private int dialogType = 1;
    private Button btnRed;
    private TextView tvTime;
    private String TAG = "zhxh_debug";
    private String LINE_SEPARATOR = "\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnRed = findViewById(R.id.btnRed);
        tvTime = findViewById(R.id.tvTime);

        btnRed.setText("对话框" + String.valueOf(dialogType));

        btnRed.setOnClickListener(v -> {

            btnRed.setText("对话框" + String.valueOf(dialogType));

            QuantDkMainDialog dialog = QuantDkMainDialog.Companion.newInstance(dialogType);
            dialog.show(getSupportFragmentManager(), "");

            dialogType = (dialogType++) % 3 + 1;


            //TODO 倒计时
            getObservable().delay(6, TimeUnit.SECONDS)
                 //  .subscribeOn(Schedulers.io())
                 //  .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getObserver());

        });


    }

    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                tvTime.append(LINE_SEPARATOR);
                tvTime.append(" onNext : value : " + value);
                tvTime.append(LINE_SEPARATOR);
                Log.d(TAG, " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                tvTime.append(" onError : " + e.getMessage());
                tvTime.append(LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                tvTime.append(LINE_SEPARATOR);
                tvTime.append(" onComplete");
                tvTime.append(LINE_SEPARATOR);
                Log.d(TAG, " onComplete");
            }
        };
    }

    private Observable<String> getObservable() {
        return Observable.just("haha");
    }

}
