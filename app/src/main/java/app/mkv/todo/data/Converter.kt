package app.mkv.todo.data

import androidx.room.TypeConverter
import app.mkv.todo.data.model.Priority

class Converter {


    @TypeConverter
    fun fromPriority(priority: Priority): String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }


}