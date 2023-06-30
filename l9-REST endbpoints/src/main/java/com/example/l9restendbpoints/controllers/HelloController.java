package com.example.l9restendbpoints.controllers;

import com.example.l9restendbpoints.dto.Person;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

//    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    /**
     * Instead of using the above long line you may use the following annotation
     */
    @GetMapping(path = "/hello/{name}") // shorter version :)
    public String Hello(@PathVariable("name") String name) {
        return "Hello! " + name;
    }

    @PostMapping(path = "/goodbye")
    public String goodBye(@RequestBody Person person) {
        return "Goodbye, " + person.getName() + "!";
    }

    @GetMapping(path = "/get")
    public Person getPerson() {
        Person person = new Person();
        person.setName("hamada");
        return person;
    }

    @GetMapping(path = "/getall")
    public List<Person> getAllPerson() {
        Person person1 = new Person();
        person1.setName("hamada");

        Person person2 = new Person();
        person2.setName("alaa");
        return Arrays.asList(person1, person2);
    }

    /**
     * Manipulate the response status code
     */
    @GetMapping(path = "/statustest")
    public void statusTest(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
