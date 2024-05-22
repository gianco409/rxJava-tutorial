package com.codingsaint.learning.rxjava.operators.transforming;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ScanOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScanOperator.class);

    public static void main(String[] args){
        LOGGER.info("Scan Operator");
        List<Integer> numbers = RxUtils.positiveNumbers(10);
        Observable.fromIterable(numbers)
                .scan(Integer::sum).subscribe(new DemoObserver());
    }
}
