package com.example.mvvmdemo.ui;

import com.example.mvvmdemo.model.Model;
import com.example.mvvmdemo.persistance.firebase.DBFacade;

import java.util.Observer;

public class ViewModel {
    public static ViewModel viewModel = new ViewModel();

    //this adds the main activity to the models list of observers.
    private ViewModel(){
        DBFacade.getDBFacade().getTextMapper().addObserver((Observer)MainActivity.activity);
    }

    public void setText(String text) {
        Model.model.setText(text);
    }

    public String getText(){
        return Model.model.getText();
    }
}