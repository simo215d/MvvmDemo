package com.example.mvvmdemo.view;

import com.example.mvvmdemo.model.Model;
import com.example.mvvmdemo.ui.MainActivity;

import java.util.Observer;

public class ViewModel {
    public static ViewModel viewModel = new ViewModel();
    private ViewModel(){
        Model.model.addObserver((Observer) MainActivity.activity);
    }

    public void setText(String text){
        Model.model.setText(text);
    }

    public String getText(){
        return Model.model.getText();
    }
}