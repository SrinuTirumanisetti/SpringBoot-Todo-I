package com.example.todo;

import com.example.todo.Todo;
import java.util.*;

public interface TodoRepository {
    List<Todo> getTodoList();
    Todo addTodoItem(Todo todo);
    Todo getTodoById(int id);
}

