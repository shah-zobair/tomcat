package com.redhat.developers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@SpringBootApplication

public class SpringBootWarApplication {

    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        log.info("Prefix :{} and User:{}", prefix, user);
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format("%s %s! Welcome to Configuring Spring Boot on Kubernetes!", prefix, user);
    }

}
