package com.pradeep.rest.webservices.restfull_web_services.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Todo getTodos(@PathVariable String username, @PathVariable long id)
    {
        return todoService.findById(id);
    }


    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String useraName ,@PathVariable long id, @RequestBody Todo todo
    )
    {
        Todo todoUpdated = todoService.save(todo);
        return  new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }
}
