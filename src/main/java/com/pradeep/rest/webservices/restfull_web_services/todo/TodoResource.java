package com.pradeep.rest.webservices.restfull_web_services.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private todoHardCodedService todoService;

    @GetMapping(path = "/user/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
    return todoService.findAll();
    }

    @DeleteMapping(path = "/user/{username}/todos/{id}")
    public ResponseEntity<Void> deteleTodo(@PathVariable String username,@PathVariable long id)
    {
     Todo todo=   todoService.deleteByid(id);
        if(todo!=null)
        {
            return ResponseEntity.noContent().build();
        }

         return ResponseEntity.notFound().build();
    }


    @GetMapping(path = "/user/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id)
    {
        return todoService.findById(id);
    }


    @PutMapping("/user/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username ,@PathVariable long id, @RequestBody Todo todo
    )
    {
        Todo todoUpdated = todoService.save(todo);
        return  new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/user/{username}/todos")
    public ResponseEntity<Void> createTodo(
            @PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);


        // Build the URI for the newly created Todo
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();

        // Return ResponseEntity with 201 Created status and location header
        return ResponseEntity.created(uri).build();
    }

}
