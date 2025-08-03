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
}
