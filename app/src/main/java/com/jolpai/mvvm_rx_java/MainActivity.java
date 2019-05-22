package com.jolpai.mvvm_rx_java;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    //https://www.toptal.com/android/functional-reactive-android-rxjava
    @BindView(R.id.hello_text)
    TextView helloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Observable.just("This is Tanim").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                helloText.setText(s);
            }
        });

        //Creating a observable object which will emit 1,2,3 respectively
        Observable <Integer>  observable = Observable.just(1,2,3);

        observable.subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("Test", "In onError()");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d("Test", "In onNext():" + integer);
            }

            @Override
            public void onComplete() {
                Log.d("Test", "In onCompleted()");
            }
        });



    }
}
