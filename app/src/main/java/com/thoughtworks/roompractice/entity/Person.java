package com.thoughtworks.roompractice.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int gender;
    public int age;

}
