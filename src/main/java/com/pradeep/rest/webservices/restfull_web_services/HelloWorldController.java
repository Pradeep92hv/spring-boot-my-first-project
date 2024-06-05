package com.pradeep.rest.webservices.restfull_web_services;

import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

//controller
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class HelloWorldController {


    @GetMapping(path = "/hello-world")
    public  String helloWorld()
    {
        return  "Hello world ";
    }


    @GetMapping(path = "/hello-world-bean")
    public  HelloWorldBean helloWorldBean()
    {
       // return new HelloWorldBean("Hello world-changed");
        throw new RuntimeException("Some Error has happend **-**");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean  helloWorldpathvariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
