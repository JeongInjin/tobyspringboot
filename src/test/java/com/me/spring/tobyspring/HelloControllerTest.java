package com.me.spring.tobyspring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class HelloControllerTest {

    @Test
    void HelloControllerTest() {
        HelloController helloController = new HelloController(name -> name);
        String result = helloController.hello("test");
        assertThat(result).isEqualTo("test");
    }

    @Test
    void failsHelloControllerTest() {
        HelloController helloController = new HelloController(name -> name);

        assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}