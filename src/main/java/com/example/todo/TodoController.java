package com.example.todo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.todo.TodoService;
import com.example.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class TodoController {

    @Autowired
    public TodoService service;

    @GetMapping("/todos")
    public List<Todo> getTodoList() {
        return service.getTodoList();
    }

    @PostMapping("/todos")
    public Todo addTodoItem(@RequestBody Todo todo){
        return service.addTodoItem(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        return service.getTodoById(id);
    }
}

