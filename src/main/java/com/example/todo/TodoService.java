package com.example.todo;

import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
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
    public List<Todo> getTodoList(){
        return new ArrayList<>(todoList.values());
    }

    @Override
    public Todo addTodoItem(Todo todo){
        todo.setId(currentId);
        todoList.put(currentId,todo);
        currentId+=1;
        return todo;
    }

    @Override
    public Todo getTodoById(int id){
        Todo todo = todoList.get(id);
        if(todo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return todo;
    }

    @Override
    public Todo updateTodoById(int id,Todo todo){
        Todo existingtodo = todoList.get(id);
        if(todo.getTodo()!=null){
            existingtodo.setTodo(todo.getTodo());
        }
        if(todo.getPriority()!=null){
            existingtodo.setPriority(todo.getPriority());
        }
        if(todo.getStatus()!=null){
            existingtodo.setStatus(todo.getStatus());
        }
        return existingtodo;
    }

    @Override
    public void deleteTodo(int id){
        if(todoList.get(id)==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        todoList.remove(id);
    }
}
