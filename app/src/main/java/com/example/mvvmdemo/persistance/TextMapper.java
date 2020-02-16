package com.example.mvvmdemo.persistance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TextMapper extends SQLiteOpenHelper {

    private final static String TABLE_NAME = "text_table";
    private final static String COL_1 = "text";

    public TextMapper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("NOW ON UPGRADE");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        System.out.println("ON UPGRADE SUCCESS");
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("NOW ON CREATE");
        String createTable = "CREATE TABLE "+TABLE_NAME+" (ID INT PRIMARY KEY, "+COL_1+" VARCHAR(255))";
        db.execSQL(createTable);
        System.out.println("TABLE HAS BEEN CREATED");
        db.execSQL("INSERT INTO "+TABLE_NAME+" (ID, "+COL_1+") VALUES (1,'defaulttext')");
        System.out.println("ON CREATE SUCCESS");
    }

    public boolean setText(String text){
        System.out.println("THE CURRENT TEXT IS: "+getText());
        SQLiteDatabase db = this.getWritableDatabase();
        //update the table
        try {
            db.execSQL("UPDATE " + TABLE_NAME + " SET " + COL_1 + " = '" + text + "' WHERE ID = 1");
            return true;
        } catch (Exception e){
            System.out.println("something went wrong, oopsie doopsie");
            e.printStackTrace();
        }
        return false;
    }

    public String getText(){
        SQLiteDatabase db = this.getWritableDatabase();
        String result = "ERROR";
        Cursor res = db.rawQuery("SELECT "+COL_1+" FROM "+TABLE_NAME,null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            result=(res.getString(res.getColumnIndex(COL_1)));
            res.moveToNext();
        }
        System.out.println("WE FOUND: "+result);
        return result;
    }
}
