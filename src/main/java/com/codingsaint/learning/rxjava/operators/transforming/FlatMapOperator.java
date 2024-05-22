package com.codingsaint.learning.rxjava.operators.transforming;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FlatMapOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlatMapOperator.class);

    public static void main(String[] args) {
        LOGGER.info("FlatMap Operator");
        List<Integer> positiveNumbers = RxUtils.positiveNumbers(10);
        Observable.fromIterable(positiveNumbers)
                .flatMap(FlatMapOperator::twice)
                .subscribe(new DemoObserver());
    }

    public static Observable<Integer> twice(Integer integer) {
        return Observable.create(observableEmitter -> {
            if(!observableEmitter.isDisposed()) {
                observableEmitter.onNext(integer);
            } else {
                observableEmitter.onComplete();
            }
        });
    }
}
