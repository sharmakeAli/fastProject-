package com.example.fastProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "Hello, Spring Boot!";
    }
   // @GetMapping("/hello")
    @RequestMapping(value ="/hello",method = RequestMethod.GET)
    public String getHello(){

        return "Hello, Spring Boot!";
    }
    @GetMapping("/{name}")
  //  @RequestMapping(value ="/{name}",method = RequestMethod.GET)

    public String getName(@PathVariable String name){
        return "Hello, "+ name;
    }

}
