package app.mkv.todo.data.repository

import androidx.lifecycle.LiveData
import app.mkv.todo.data.ToDoDao
import app.mkv.todo.data.model.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }

}