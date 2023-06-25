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
    public Owner owner(Cat cat) {
        Owner owner = new Owner();
        owner.setCat(cat); // spring injected the instance of cat bean from the context
        return owner;
    }
}
