package com.example.abdo.todo_list;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.abdo.todo_list.database.AppDatabase;


public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppDatabase mDb;
    private final int mTaskId;

    public AddTaskViewModelFactory(AppDatabase mDb, int mTaskId) {
        this.mDb = mDb;
        this.mTaskId = mTaskId;
    }

    // Note: This can be reused with minor modifications
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
