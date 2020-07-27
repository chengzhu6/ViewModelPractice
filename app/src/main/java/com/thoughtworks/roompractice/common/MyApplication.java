package com.thoughtworks.roompractice.common;

import android.app.Application;

import androidx.room.Room;

import com.thoughtworks.roompractice.dao.AppDatabase;

public class MyApplication extends Application {
    private static final String THOUGHTWORKS_ROOM_DATABASENAME = "com.thoughtworks.room.databasename";
    private LocalDataSource localDataSource;

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, THOUGHTWORKS_ROOM_DATABASENAME).build();
        localDataSource = new LocalDataSource(appDatabase);
    }

    public LocalDataSource getLocalDataSource() {
        return localDataSource;
    }
}
