package com.me.spring.tobyspring;

import com.me.spring.tobyspring.datasource.MyDataSourceConfigV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;


//@Configuration
//@ComponentScan
@Import(MyDataSourceConfigV1.class)
@SpringBootApplication(scanBasePackages = "com.me.spring.tobyspring.datasource")
public class TobySpringApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(TobySpringApplication.class, args);
    }

}
