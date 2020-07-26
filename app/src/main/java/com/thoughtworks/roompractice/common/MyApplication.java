package com.thoughtworks.roompractice.common;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

public class MyApplication extends Application {
    private static final String THOUGHTWORKS_ROOM_DATABASENAME = "com.thoughtworks.room.databasename";
    private static Context myContext;

    private static LocalDataSource localDataSource;
    @Override
    public void onCreate() {
        super.onCreate();
        myContext = getApplicationContext();
        localDataSource = Room.databaseBuilder(myContext, LocalDataSource.class, THOUGHTWORKS_ROOM_DATABASENAME).build();
    }

    public static LocalDataSource getLocalDataSource() {
        return localDataSource;
    }

    public static Context getMyContext() {
        return myContext;
    }
}
