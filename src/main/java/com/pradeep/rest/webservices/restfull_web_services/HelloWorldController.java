package com.pradeep.rest.webservices.restfull_web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

//controller
@RestController
public class HelloWorldController {


    @GetMapping(path = "/hello-world")
    public  String helloWorld()
    {
        return  "Hello world ";
    }

    @GetMapping(path = "/h")
    public HelloWorldBean  f()
    {
        return new HelloWorldBean("bean");
    }
}
