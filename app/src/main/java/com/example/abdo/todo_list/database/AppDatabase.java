package com.example.abdo.todo_list.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.util.Log;

@Database(entities = {TaskEntry.class} , version = 1 , exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG=AppDatabase.class.getSimpleName();
    private static final Object LOCK=new Object();
    private static final String DATABASE_NAME="todolist";

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance==null){
            synchronized (LOCK){
                Log.d(TAG,"creating new database instance");
                instance= Room.databaseBuilder(context.getApplicationContext()
                        ,AppDatabase.class,DATABASE_NAME)
                        .build();
            }
        }
        Log.d(TAG,"getting database instance");
        return instance;
    }
    public abstract TaskDAO taskDao();
}
