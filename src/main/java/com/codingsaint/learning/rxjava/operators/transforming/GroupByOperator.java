package com.codingsaint.learning.rxjava.operators.transforming;

import com.codingsaint.learning.rxjava.models.Shape;
import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupByOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupByOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.shapes(20))
                .groupBy(new Function<Shape, Object>() {

                    @Override
                    public Object apply(@NonNull Shape shape) {
                        return shape.getShape();
                    }
                })
                //.observeOn(Schedulers.newThread())
                .subscribe(new Observer<>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull GroupedObservable<Object, Shape> objectShapeGroupedObservable) {
                        LOGGER.info("key {}", objectShapeGroupedObservable.getKey());
                        objectShapeGroupedObservable.subscribe(new DemoObserver());
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
