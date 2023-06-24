package main;

import beans.MyBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {

            MyBean b1 = context.getBean(MyBean.class);
            MyBean b2 = context.getBean(MyBean.class);

            System.out.println(b1.getText());
            System.out.println(b2.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}