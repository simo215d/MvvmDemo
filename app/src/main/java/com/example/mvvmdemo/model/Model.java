package com.example.mvvmdemo.model;

import com.example.mvvmdemo.entities.Text;
import com.example.mvvmdemo.persistance.firebase.DBFacade;

import java.util.Observable;

public class Model extends Observable {
    //singleton
    public static Model model = new Model();

    private Model(){ }

    /*public void setText(String text){
        DBFacade.getDBFacade().setText(text);
    }

     */

    public void setText(String text){
        Text.textInstance.setText(text);
    }

    /*public String getText(){
        return DBFacade.getDBFacade().getDBText();
    }

     */

    public String getText(){
        return Text.textInstance.getText();
    }
}