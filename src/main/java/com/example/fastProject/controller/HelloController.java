package com.example.fastProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "Hello, Spring Boot!";
    }
    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        return "Hello, "+ name;
    }
    @GetMapping("/hello")
    public String getHello(@PathVariable String name){
        return "Hello, Spring Boot!"+ name;
    }
}
