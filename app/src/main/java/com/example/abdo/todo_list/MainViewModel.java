package com.example.abdo.todo_list;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.abdo.todo_list.database.AppDatabase;
import com.example.abdo.todo_list.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel{
    private LiveData<List<TaskEntry>> tasks;
    public MainViewModel(@NonNull Application application) {
        super(application);
        tasks=AppDatabase.getInstance(this.getApplication())
                .taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
