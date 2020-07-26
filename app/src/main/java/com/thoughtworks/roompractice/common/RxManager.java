package com.thoughtworks.roompractice.common;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxManager {
    private CompositeDisposable compositeDisposable;

    public RxManager() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public void add(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public void dispose() {
        compositeDisposable.dispose();
    }
}
