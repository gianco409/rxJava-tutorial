package com.codingsaint.learning.rxjava.operators.combining;

import com.codingsaint.learning.rxjava.models.Shape;
import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZipOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Zip Operator");

        Observable<Shape> shapes = Observable.fromIterable(RxUtils.shapes(5));
        Observable<Integer> numbers = Observable.fromIterable(RxUtils.positiveNumbers(3));

        numbers.zipWith(shapes, (o, o2) -> o + ": " + o2).subscribe(new DemoObserver());
    }
}
