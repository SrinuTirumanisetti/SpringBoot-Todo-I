package com.example.todo;

import com.example.todo.Todo;
import com.example.todo.TodoRepository;
import java.util.*;

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    private static int currentId = 6; // Next ID to be assigned

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));
    }

    @Override
    public List<Todo> getTodos() {
        return new ArrayList<>(todoList.values());
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(currentId++);
        todoList.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Todo getTodoById(int id) {
        return todoList.get(id);
    }

    @Override
    public Todo updateTodoStatus(int id, String status) {
    Todo todo = todoList.get(id);
    if (todo == null) {
        return null;
    }
    todo.setStatus(status);
    return todo;
    }

}

