package com.thoughtworks.roompractice.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.thoughtworks.roompractice.entity.Person;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface PersonDao {

    @Insert
    Single<Long> insertPerson(Person person);

    @Query("SELECT * FROM person")
    Single<List<Person>> getAllPerson();
}
