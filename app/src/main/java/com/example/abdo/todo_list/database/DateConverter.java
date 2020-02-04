package com.example.abdo.todo_list.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long date){
        return date==null?null:new Date(date);
    }

    @TypeConverter
    public static Long toTime(Date date){
        return date==null?null:date.getTime();
    }
}
