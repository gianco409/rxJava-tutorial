package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableWithBackPressure {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlowableWithBackPressure.class);

    public static void main(String... args) {
        Flowable<Integer> flowablePositiveNumbers = Flowable.fromIterable(RxUtils.positiveNumbers(1000000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> LOGGER.info("emitting integer -> {}", integer));

        flowablePositiveNumbers.subscribe(new Subscriber<>() {
            private Subscription subscription;
            private final AtomicInteger counter = new AtomicInteger(0);

            @Override
            public void onSubscribe(Subscription s) {
                LOGGER.info("onSubscribe");
                this.subscription = s;
                subscription.request(5);
            }

            @Override
            public void onNext(Integer integer) {
                LOGGER.info("onNext {} ->", integer);
                RxUtils.sleep(100L);
                if (counter.incrementAndGet() % 5 == 0) {
                    subscription.request(5);
                }
            }

            @Override
            public void onError(Throwable t) {
                LOGGER.info("onError {}", t.getMessage());
            }

            @Override
            public void onComplete() {
                LOGGER.info("onComplete");
            }
        });

        RxUtils.sleep(10000);
    }
}
