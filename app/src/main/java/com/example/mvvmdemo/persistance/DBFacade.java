package com.example.mvvmdemo.persistance;


import com.example.mvvmdemo.view.MainActivity;

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
