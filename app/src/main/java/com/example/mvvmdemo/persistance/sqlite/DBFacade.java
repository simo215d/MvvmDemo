package com.example.mvvmdemo.persistance.sqlite;


import com.example.mvvmdemo.ui.MainActivity;

public class DBFacade {
    private static final DBFacade theDBFacade = new DBFacade();
    private TextMapper textMapper;

    private DBFacade(){
        textMapper = new TextMapper(MainActivity.activity);
    }

    public static DBFacade getDBFacade() {
        return theDBFacade;
    }

    public boolean setText(String text) {
        return textMapper.setText(text);
    }

    public String getDBText(){
        return textMapper.getText();
    }
}
