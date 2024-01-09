package com.hfad.todolist

import androidx.lifecycle.LiveData
import com.hfad.todolist.database.Todo
import com.hfad.todolist.database.TodoDao

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    suspend fun insert(todo: Todo){
        todoDao.insert(todo)
    }

    suspend fun delete(todo: Todo){
        todoDao.delete(todo)
    }

    suspend fun update(todo: Todo){
        todoDao.update(todo.id, todo.title, todo.note, todo.fio)
    }
}