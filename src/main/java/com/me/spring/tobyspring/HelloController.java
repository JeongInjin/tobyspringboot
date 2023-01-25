package com.me.spring.tobyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http -v ":8080/hello?name=jjj"
 */
//@RestController
@RequestMapping
@RestController
public class HelloController {

    //    @GetMapping("/hello")
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;

    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }
}
