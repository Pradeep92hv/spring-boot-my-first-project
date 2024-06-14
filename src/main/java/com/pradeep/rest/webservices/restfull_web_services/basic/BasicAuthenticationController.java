package com.pradeep.rest.webservices.restfull_web_services.basic;

import org.springframework.web.bind.annotation.*;

//controller
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean()
    {
        return new AuthenticationBean("Hello world-changed");
       // throw new RuntimeException("Some Error has happend **-**");
    }

}
