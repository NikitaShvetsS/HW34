package org.example;

import org.springframework.context.annotation.Bean;

public class DispatcherServlet {
    @Bean
    DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

}
