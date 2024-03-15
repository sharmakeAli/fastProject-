package com.example.fastProject.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

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
    @GetMapping("/error")
    public ResponseEntity<Map<String, String>> getError() {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", "Something went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

    @GetMapping("/withHeaders")
    public ResponseEntity<String> getWithHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "value");
        return ResponseEntity.ok().headers(headers).body("Response with headers");
    }
    @GetMapping("/customStatus")
    public ResponseEntity<String> getWithCustomStatus() {
        return new ResponseEntity<>("Custom Status Message", HttpStatus.ACCEPTED);
    }
}
