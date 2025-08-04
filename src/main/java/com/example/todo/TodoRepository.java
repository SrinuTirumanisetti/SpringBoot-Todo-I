package com.example.todo;

import java.util.*;

public interface TodoRepository {
    List<Todo> getTodos();
    Todo addTodo(Todo todo);
}

