package com.hfad.todolist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hfad.todolist.database.Todo
import com.hfad.todolist.database.TodoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TodoRepository
    val allTodo : LiveData<List<Todo>>

    init {
        val dao = TodoDatabase.getDatabase(application).getTodoDao()
        repository = TodoRepository(dao)
        allTodo = repository.allTodos
    }

    fun insertTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(todo)
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        repository.update(todo)
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(todo)
    }
}