package services;

import org.springframework.stereotype.Service;

@Service
public class HelloServices {

    public String hello(String name) {
        String result = "hello, " + name;

        System.out.println(result);
        return result;
    }
}
