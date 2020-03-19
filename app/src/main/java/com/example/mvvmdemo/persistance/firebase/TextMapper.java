package com.example.mvvmdemo.persistance.firebase;

import androidx.annotation.NonNull;

import com.example.mvvmdemo.model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Observable;
import java.util.Observer;

public class TextMapper implements Observer {
    private DatabaseReference rootRef;
    private DatabaseReference conditionRef;

    private Model model;

    public TextMapper(Model model){
        rootRef = FirebaseDatabase.getInstance().getReference();
        conditionRef = rootRef.child("Text");

        this.model=model;

        model.getTextInstance().addObserver(this);

        //this is triggered initially once, and then whenever it notices a change
        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("DATA HAS CHANGED: "+dataSnapshot.getValue(String.class));
                String text = dataSnapshot.getValue(String.class);
                model.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("error");
            }
        });
    }

    private void setText(String text){
        conditionRef.setValue(text);
        System.out.println("TextMapper: we inserted into firebase database");
    }

    public Model getModel(){
        return model;
    }

    @Override
    public void update(Observable observable, Object arg) {
        setText(model.getText());
    }
}