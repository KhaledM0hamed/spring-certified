package config;

import beans.Cat;
import beans.Owner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat cat = new Cat();
        cat.setName("tom");
        return cat;
    }

    @Bean
    public Owner owner() {
        Owner owner = new Owner();
        owner.setCat(cat()); // Spring already will find an instance of the cat when calling the method cat() so spring will not make a new instance
        return owner;
    }
}
