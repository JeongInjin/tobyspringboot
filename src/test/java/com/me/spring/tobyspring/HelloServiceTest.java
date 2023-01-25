package com.me.spring.tobyspring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HelloServiceTest {

    @Test
    void simpleHelloServiceTest() {
        SimpleHelloService helloService = new SimpleHelloService();
        String result = helloService.sayHello("jij");

        assertThat(result).isEqualTo("Hello jij");
    }

}