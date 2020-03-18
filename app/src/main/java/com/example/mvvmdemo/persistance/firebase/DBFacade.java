package com.example.mvvmdemo.persistance.firebase;

public class DBFacade {
    private static final DBFacade theDBFacade = new DBFacade();
    private TextMapper textMapper;

    private DBFacade(){
        System.out.println("db facade is here :)");
        textMapper = new TextMapper();
    }

    public static DBFacade getDBFacade() {
        return theDBFacade;
    }

    public void setText(String text) {
        textMapper.setText(text);
    }

    public String getDBText(){
        return textMapper.getText();
    }

    public TextMapper getTextMapper(){
        return textMapper;
    }
}