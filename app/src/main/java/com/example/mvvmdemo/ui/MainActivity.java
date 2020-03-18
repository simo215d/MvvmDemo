package com.example.mvvmdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
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

        //add a click listener and specify the click event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ViewModel.viewModel.setText(editText.getText().toString());
                    System.out.println("everything works as intended");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //this line actually doesn't really set the text. it is there to wake up our DBFacade instance
        //so that the constructors are called.
        textView.setText(ViewModel.viewModel.getText());
    }

    //this is called from TextMapper when a change is made
    @Override
    public void update(Observable observable, Object arg) {
        textView.setText(ViewModel.viewModel.getText());
        System.out.println("hi im main activity and i updated because im an observer");
    }
}