package main;

import beans.Cat;
import beans.Owner;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /**
     *  1. Wiring:
     *  So, Wiring is when you can the method that creates an instance of a bean, spring check the context if there is
     *  an already created instance will return it instead of executing the creation method that you called.
     *
     *  2. Autowiring:
     *  is better option(using parameters instead of calling creation methods) as it enables you to have multiple configuration files and take beans from other files.
     */
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            Cat cat = context.getBean(Cat.class);
            Owner owner = context.getBean(Owner.class);

            cat.setName("Leo"); // the owner also will change cause the owner has a reference to the cat
            System.out.println(cat);
            System.out.println(owner);

        }
    }
}