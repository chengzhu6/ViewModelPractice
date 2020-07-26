package com.thoughtworks.roompractice.common;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.thoughtworks.roompractice.dao.PersonDao;
import com.thoughtworks.roompractice.entity.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class LocalDataSource extends RoomDatabase {
    public abstract PersonDao personDao();
}
