package com.codingsaint.learning.rxjava.observer;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DemoObserver implements Observer<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Observer.class);
    @Override
    public void onSubscribe(@NonNull Disposable disposable) {
        LOGGER.info("onSubscribe");
    }

    @Override
    public void onNext(@NonNull Object o) {
        LOGGER.info("onNext -> {}", o);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        LOGGER.info("onError {}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        LOGGER.info("onComplete");
    }
}
