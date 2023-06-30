package com.example.l8springboot101.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
//@Controller
//@ResponseBody
// just return this text in the request body and don't search for a
// page on static folder that called hello
**/

// you may use @RestController instead of previous both annotations
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        String hello;
        hello = "Hello";
        return hello;
    }
}
