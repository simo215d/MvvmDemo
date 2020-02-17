package com.example.mvvmdemo.model;

import com.example.mvvmdemo.persistance.firebase.DBFacade;

import java.util.Observable;

public class Model extends Observable {
    //singleton
    public static Model model = new Model();

    private Model(){ }

    public boolean setText(String text){
        return DBFacade.getDBFacade().setText(text);
    }

    public String getText(){
        return DBFacade.getDBFacade().getDBText();
    }
}