package com.codingsaint.learning.rxjava.operators.filtering;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkipOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkipOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Skip Operator");
        Observable.fromIterable(RxUtils.positiveNumbers(10))
                .skip(6)
                .subscribe(new DemoObserver());
    }
}
