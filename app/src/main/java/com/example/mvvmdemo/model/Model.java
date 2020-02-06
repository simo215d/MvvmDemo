package com.example.mvvmdemo.model;

import java.util.Observable;

public class Model extends Observable {
    private String text;
    //singleton
    public static Model model = new Model();

    private Model(){ }

    public void setText(String text){
        this.text=text;
        setChanged();
        notifyObservers();
    }

    public String getText(){
        return text;
    }
}