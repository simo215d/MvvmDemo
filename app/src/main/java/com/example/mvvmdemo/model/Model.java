package com.example.mvvmdemo.model;

import com.example.mvvmdemo.entities.Text;

import java.util.Observable;

public class Model extends Observable {

    private Text textInstance;

    public Model(){
        textInstance = new Text();
    }

    public void setText(String text){
        textInstance.setText(text);
    }

    public String getText(){
        return textInstance.getText();
    }

    public Text getTextInstance(){
        return textInstance;
    }
}