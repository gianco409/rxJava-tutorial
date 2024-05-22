package com.codingsaint.learning.rxjava.operators.utility;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class AllOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllOperator.class);
    public static void main(String[] args) {
        LOGGER.info("All Operator");

        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.positiveNumbers(10));
        positiveNumbers.all(
                integer -> integer > 5
        ).subscribe(new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onSuccess(@NonNull Boolean aBoolean) {
                LOGGER.info("Do all of the events are greater than 5 {}", aBoolean);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }
        });
    }
}
