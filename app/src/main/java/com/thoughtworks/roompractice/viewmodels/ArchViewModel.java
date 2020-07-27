package com.thoughtworks.roompractice.viewmodels;

import android.os.SystemClock;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ArchViewModel extends ViewModel {
    private MutableLiveData<Integer> increaseNumber;
    private boolean isComputing;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        isComputing = false;
        super.onCleared();
    }

    public void increase() {
        if (isComputing) {
            return;
        }
        isComputing = true;
        Disposable disposable = Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            int number = 0;
            while (isComputing) {
                emitter.onNext(number++);
                SystemClock.sleep(1000);
            }
            emitter.onComplete();
        }).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(compositeDisposable::add)
                .subscribe(increaseNumber::setValue);
        compositeDisposable.add(disposable);
    }

    public MutableLiveData<Integer> getIncreaseNumber() {
        if (increaseNumber == null) {
            increaseNumber = new MutableLiveData<>();
        }
        return increaseNumber;
    }
}
