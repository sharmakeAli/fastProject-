package com.example.fastProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/responses")
public class ResponseController {
@GetMapping("/")
    public ResponseEntity getOk(){
    // status=200
    return ResponseEntity.ok("successfully");
}
    @GetMapping("/created")
    public ResponseEntity created(){
    // status=201
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }
    @GetMapping("/badRequest")
    public ResponseEntity badRequest(){
    //statusCode=400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("badRequest");
    }
    //Unauthorized
    @GetMapping("/Unauthorized")
    public ResponseEntity unAuthorized(){
        //statusCode=401
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }
    @GetMapping("/NotFound")
    public ResponseEntity notFound(){
        //statusCode=404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NotFound");
    }
}
