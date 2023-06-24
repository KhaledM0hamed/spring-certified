package beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean {

    private String text;

    /**
     * Called after the instance creation 
     */
    @PostConstruct
    private void init() {
        this.text = "hi";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public MyBean () {
        System.out.println("Inside MyBean Constructor");
    }
}
