package com.me.spring.tobyspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

class HelloApiTest {

    @Test
    void helloAPi() {
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<String> result = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Jeong");

        assertThat(result.getStatusCode()).isEqualTo(OK);
        assertThat(result.getHeaders().getFirst(CONTENT_TYPE)).startsWith(TEXT_PLAIN_VALUE);
        assertThat(result.getBody()).isEqualTo("Hello Jeong");
    }

}