package com.pradeep.rest.webservices.restfull_web_services.todo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class todoHardCodedService {

    private static List<Todo> todos=new ArrayList<>();
    private static int idcounter=0;

    static {
        todos.add(new Todo(false,new Date(),"s","s",++idcounter));
        todos.add(new Todo(false,new Date(),"s","p",++idcounter));
    }

    public List<Todo> findAll()
    {
        return todos;
    }

    public Todo deleteByid(long id)
    {
        Todo todo=findById(id);

        if(todo==null) return null;

        if(todos.remove(todo))
            return todo;
        return  null;


    }

    public Todo findById(long id) {
        for(Todo todo: todos){
            if(todo.getId()== id)
                return todo;
        }
        return  null;
    }
    public Todo save(Todo todo){
        if (todo.getId() == 0 || todo.getId() == -1) {
            todo.setId(++idcounter);
            todos.add(todo);
        }
        else
        {
            deleteByid(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}
