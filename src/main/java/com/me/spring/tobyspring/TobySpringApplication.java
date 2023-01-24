package com.me.spring.tobyspring;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@Configuration
public class TobySpringApplication {

    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloServic() {
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
//        SpringApplication.run(TobySpringApplication.class, args);
//        HelloController helloController = new HelloController();

//        GenericApplicationContext applicationContext = new GenericApplicationContext();
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this) {
                    }).addMapping("/*");
                });
                webServer.start();
            }
        };

        applicationContext.register(TobySpringApplication.class);
        applicationContext.refresh();

    }

}
