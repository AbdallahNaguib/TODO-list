package com.example.abdo.todo_list;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.abdo.todo_list.database.AppDatabase;
import com.example.abdo.todo_list.database.TaskEntry;


public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
