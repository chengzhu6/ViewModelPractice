package com.thoughtworks.roompractice.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.thoughtworks.roompractice.R;
import com.thoughtworks.roompractice.common.MyApplication;
import com.thoughtworks.roompractice.common.RxManager;
import com.thoughtworks.roompractice.entity.Person;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ViewActivity extends AppCompatActivity {

    private RxManager rxManager = new RxManager();

    @Override
    protected void onDestroy() {
        rxManager.dispose();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        showAllPerson();
    }

    private void showAllPerson() {
        TextView personInfoTextView = findViewById(R.id.person_info);
        Disposable disposable = MyApplication.getLocalDataSource().personDao().getAllPerson()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable1 -> rxManager.add(disposable1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(people -> {
                    for (Person person :
                            people) {
                        personInfoTextView.append("Name: " + person.name +
                                " Age: " + person.age +
                                " Gender: " + person.gender + "\n");
                    }
                });
        rxManager.add(disposable);
    }
}