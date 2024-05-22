package com.codingsaint.learning.rxjava.observables;

import com.codingsaint.learning.rxjava.observer.DemoObserver;
import com.codingsaint.learning.rxjava.utils.RxUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservableWithoutBackpressure {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithoutBackpressure.class);

    public static void main(String... args) {
        Observable<Integer> positiveNumberEvents = Observable.fromIterable(RxUtils.positiveNumbers(100000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread());

        positiveNumberEvents.subscribe(new DemoObserver());
        RxUtils.sleep(100000);
    }
}
