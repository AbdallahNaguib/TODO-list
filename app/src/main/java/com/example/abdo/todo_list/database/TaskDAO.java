package com.example.abdo.todo_list.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface TaskDAO {

    @Query("select * from task order by priority")
    LiveData<List<TaskEntry>> loadAllTasks();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(TaskEntry taskEntry);

    @Delete
    void deleteTask(TaskEntry taskEntry);

    @Insert
    void insertTask(TaskEntry taskEntry);

    @Query("select * from task where id = :id")
    LiveData<TaskEntry> loadTaskById(int id);
}
