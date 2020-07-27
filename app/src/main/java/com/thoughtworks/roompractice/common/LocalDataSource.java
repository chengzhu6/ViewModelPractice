package com.thoughtworks.roompractice.common;

import com.thoughtworks.roompractice.dao.AppDatabase;
import com.thoughtworks.roompractice.entity.Person;

import java.util.List;

import io.reactivex.Single;

public class LocalDataSource {
    private AppDatabase appDatabase;

    public LocalDataSource(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    public Single<Long> insertPerson(Person person) {
        return appDatabase.personDao().insertPerson(person);
    }

    public Single<List<Person>> getAllPerson() {
        return appDatabase.personDao().getAllPerson();
    }
}
