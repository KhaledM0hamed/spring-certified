package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloServices;

public class Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            HelloServices services = context.getBean(HelloServices.class);
            String result = services.hello("khaled");
            System.out.println(result);
        }

    }
}