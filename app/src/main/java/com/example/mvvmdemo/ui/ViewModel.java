package com.example.mvvmdemo.ui;

import com.example.mvvmdemo.model.Model;

public class ViewModel {
    private Model model;

    public ViewModel(Model model){
        this.model =  model;
    }

    public void setText(String text) {
        model.setText(text);
    }

    public String getText(){
        return model.getText();
    }

    public Model getModel(){
        return model;
    }
}