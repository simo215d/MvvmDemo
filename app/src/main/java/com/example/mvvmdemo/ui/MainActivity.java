package com.example.mvvmdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.model.Model;
import com.example.mvvmdemo.persistance.firebase.TextMapper;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    private ViewModel viewModel;

    private Button button;
    private TextView textView;
    private EditText editText;

    public static AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity=this;
        //find the views
        button = findViewById(R.id.button1);
        textView = findViewById(R.id.text_view1);
        editText = findViewById(R.id.edit_text1);

        initialiseModulesWithFirebase();

        //add a click listener and specify the click event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    System.out.println("button clicked");
                    viewModel.setText(editText.getText().toString());
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    //start the objects
    private void initialiseModulesWithFirebase(){
        TextMapper textMapper = new TextMapper(new Model());
        viewModel = new ViewModel(textMapper.getModel());
        viewModel.getModel().getTextInstance().addObserver(this);
    }

    //this is called from Text when a change is made
    @Override
    public void update(Observable observable, Object arg) {
        textView.setText(viewModel.getText());
        System.out.println("hi im main activity and i updated because im an observer");
    }
}