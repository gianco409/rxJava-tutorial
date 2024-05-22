package com.codingsaint.learning.rxjava.operators.utility;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TakeWhileOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TakeWhileOperator.class);
    public static void main(String[] args) {
        LOGGER.info("TakeWhile Operator");
        Observable<Integer> positiveNumbers = Observable.fromIterable(RxUtils.positiveNumbers(10));

        positiveNumbers.takeWhile( integer -> {
            return integer < 4;
        }).subscribe(new DemoObserver());
    }
}
