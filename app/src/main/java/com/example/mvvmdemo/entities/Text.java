package com.example.mvvmdemo.entities;

import java.util.Observable;

public class Text extends Observable {

    public static Text textInstance = new Text();

    private Text(){ }

    private String text;

    public void setText(String text){
        this.text=text;
        setChanged();
        notifyObservers();
    }

    public String getText(){
        return text;
    }
}
