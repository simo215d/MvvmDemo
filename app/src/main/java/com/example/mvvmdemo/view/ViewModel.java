package com.example.mvvmdemo.view;

import com.example.mvvmdemo.model.Model;
import com.example.mvvmdemo.persistance.DBFacade;

import java.sql.SQLException;
import java.util.Observer;

public class ViewModel {
    public static ViewModel viewModel = new ViewModel();

    //this adds the main activity to the models list of observers.
    private ViewModel(){
        Model.model.addObserver((Observer) MainActivity.activity);
    }

    public boolean setText(String text) throws SQLException {
        Model.model.setText(text);
        return DBFacade.getDBFacade().setText(text);
    }

    public String getText(){
        return Model.model.getText();
    }

    public String getDBText(){
        return DBFacade.getDBFacade().getDBText();
    }
}