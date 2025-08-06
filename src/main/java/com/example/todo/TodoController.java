import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable int id) {
        Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
        return todo;
    }
}
