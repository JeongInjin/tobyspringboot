package com.me.spring.tobyspring;

import java.util.Objects;

/**
 *  http -v ":8080/hello?name=jjj"
 */
//@RestController
public class HelloController {

//    @GetMapping("/hello")
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
