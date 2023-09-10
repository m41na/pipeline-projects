package works.hop.todo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import works.hop.todo.model.Todo
import works.hop.todo.repository.TodoRepository

@CrossOrigin(origins = "http://localhost:8093")
@RestController
@RequestMapping("/api/todos")
class TodoController {

    @Autowired
    TodoRepository todoRepository

    @GetMapping()
    ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok().body(todoRepository.allTodos());
    }

    @GetMapping("/{id}")
    ResponseEntity<Todo> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(todoRepository.byId(id));
    }
}
