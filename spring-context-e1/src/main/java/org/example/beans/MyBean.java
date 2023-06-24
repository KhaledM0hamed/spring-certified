package org.example.beans;

public class MyBean {

    private String text;

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
