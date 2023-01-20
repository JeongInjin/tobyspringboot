package com.me.spring.tobyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  http -v ":8080/hello?name=jjj"
 */
//@RestController
public class HelloController {

//    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
