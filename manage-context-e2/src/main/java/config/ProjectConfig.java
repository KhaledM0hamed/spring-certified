package config;

import beans.Cat;
import beans.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

    @Bean
    @Qualifier("cat1")
    public Cat cat1() {
        Cat cat = new Cat();
        cat.setName("Tom");
        return  cat;
    }

    @Bean
    @Qualifier("cat2")
    public Cat cat2() {
        Cat cat = new Cat();
        cat.setName("Leo");
        return  cat;
    }
}
