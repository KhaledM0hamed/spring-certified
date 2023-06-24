package org.example.config;

import org.example.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean("b1")
    public MyBean myBean1() {
        MyBean b1 = new MyBean();
        b1.setText("hello");
        return b1;
    }

    @Bean("b2")
    public MyBean myBean2 () {
        MyBean b2 = new MyBean();
        b2.setText("world");
        return b2;
    }
}
