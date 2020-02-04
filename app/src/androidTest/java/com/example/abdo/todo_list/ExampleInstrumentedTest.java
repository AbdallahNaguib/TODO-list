package com.example.abdo.todo_list;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.abdo.todo_list.database.AppDatabase;
import com.example.abdo.todo_list.database.TaskDAO;
import com.example.abdo.todo_list.database.TaskEntry;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void saveTask() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        TaskDAO dao= AppDatabase.getInstance(appContext).taskDao();
        TaskEntry task=dao.loadTaskById(2);
        assertNotEquals(task.getDescription(),null);
    }
}
