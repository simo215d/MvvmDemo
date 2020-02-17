package com.example.mvvmdemo.persistance.firebase;

import androidx.annotation.NonNull;

import com.example.mvvmdemo.ui.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Observable;
import java.util.Observer;

public class TextMapper extends Observable {
    DatabaseReference rootRef;
    DatabaseReference conditionRef;

    private String text = "error";

    public TextMapper(){
        System.out.println("TextMapper has been created !!!");
        rootRef = FirebaseDatabase.getInstance().getReference();
        conditionRef = rootRef.child("Text");

        //this is triggered initially once, and then whenever it notices a change
        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("DATA HAS CHANGED: "+dataSnapshot.getValue(String.class));
                text=dataSnapshot.getValue(String.class);
                addObserver((Observer) MainActivity.activity);
                setChanged();
                notifyObservers();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("error");
            }
        });
    }

    public boolean setText(String text){
        conditionRef.setValue(text);
        System.out.println("we inserted into firebase database");
        return true;
    }

    public String getText(){
        System.out.println("get text has been calles: "+text);
        return text;
    }
}