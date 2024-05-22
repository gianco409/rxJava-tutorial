package com.codingsaint.learning.rxjava.operators.combining;

import com.codingsaint.learning.rxjava.models.Shape;
import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Merge Operator");

        Observable<? extends Shape> observable = Observable.fromIterable(RxUtils.shapes(5));
        Observable<Integer> observable1 = Observable.fromIterable(RxUtils.positiveNumbers(5));

        Observable.merge(observable, observable1).subscribe(new DemoObserver());
    }
}
