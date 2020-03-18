package com.example.mvvmdemo.persistance.firebase;

import androidx.annotation.NonNull;

import com.example.mvvmdemo.entities.Text;
import com.example.mvvmdemo.model.Model;
import com.example.mvvmdemo.ui.MainActivity;
import com.example.mvvmdemo.ui.ViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Observable;
import java.util.Observer;

public class TextMapper implements Observer {
    DatabaseReference rootRef;
    DatabaseReference conditionRef;

    private String text = "error";

    public TextMapper(){
        System.out.println("TextMapper has been created !!!");
        rootRef = FirebaseDatabase.getInstance().getReference();
        conditionRef = rootRef.child("Text");

        Text.textInstance.addObserver(this);

        //this is triggered initially once, and then whenever it notices a change
        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("DATA HAS CHANGED: "+dataSnapshot.getValue(String.class));
                text=dataSnapshot.getValue(String.class);
                //addObserver((Observer) MainActivity.activity);
                //setChanged();
                //notifyObservers();
                Model.model.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("error");
            }
        });
    }

    public void setText(String text){
        conditionRef.setValue(text);
        System.out.println("we inserted into firebase database");
    }

    public String getText(){
        System.out.println("get text has been called: "+text);
        return text;
    }

    @Override
    public void update(Observable observable, Object arg) {
        setText(Model.model.getText());
    }
}