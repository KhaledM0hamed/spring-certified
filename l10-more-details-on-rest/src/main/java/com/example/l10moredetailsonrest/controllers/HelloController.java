package com.example.l10moredetailsonrest.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @PostMapping(path = "/test/{name}")
    public String test(@PathVariable String name,
                       @RequestHeader String a,
                       @RequestHeader String b,
                       @RequestHeader String c,
                       @RequestBody String body,
                       HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        // you may add header too
        response.setHeader("test", "good");
        return name + " " + a + " " + b + " " + c + " " + body;
    }

    @GetMapping("/all")
    public Map<String, String> getAll(@RequestHeader Map<String, String> map) {
        return map;
    }

    /**
     * If you want to return a pdf file or image
     */
    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file() {
        byte [] file = new byte[100];
        return file;
    }

}
