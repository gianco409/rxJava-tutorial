package com.codingsaint.learning.rxjava.operators.utility;

import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContainsOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContainsOperator.class);
    public static void main(String[] args) {
        LOGGER.info("Contains Operator");

        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.positiveNumbers(10));
        positiveNumbers.contains(10).subscribe(new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onSuccess(@NonNull Boolean aBoolean) {
                LOGGER.info("Element present {}", aBoolean);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {

            }
        });
    }
}
