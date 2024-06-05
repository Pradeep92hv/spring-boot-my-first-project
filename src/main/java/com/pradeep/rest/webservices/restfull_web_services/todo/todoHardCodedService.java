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
        todos.add(new Todo(false,new Date(),"s","s",2));
        todos.add(new Todo(false,new Date(),"s","p",1));
    }

    public List<Todo> findAll()
    {
        return todos;
    }


    public Todo deleteById(long id)
    {
        Todo todo=findById(id);
        if(todo ==null) return  null;
        todos.remove(todo);

        return  todo;
    }

    private Todo findById(long id) {
        for(Todo todo:todos){
            if(todo.getId()==id){
                return todo;
            }
        }
        return null;
    }
}
