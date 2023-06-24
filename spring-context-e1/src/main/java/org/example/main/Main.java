package org.example.main;

import org.example.beans.MyBean;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /**
         * configurations can come from XML or
         * Annotations
         */
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            MyBean b1 = context.getBean("b1", MyBean.class);
            MyBean b2 = context.getBean("b2", MyBean.class);

            System.out.println(b1.getText());
            System.out.println(b2.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}