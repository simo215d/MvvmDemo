package com.example.mvvmdemo.model;

public class Model {
    private String text;
    //singleton
    public static Model model = new Model();

    private Model(){}

    public void setText(String text){
        this.text=text;
    }

    public String getText(){
        return text;
    }
}