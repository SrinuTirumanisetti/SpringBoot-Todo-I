package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController {

    TodoService todoService = new TodoService();

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
}
