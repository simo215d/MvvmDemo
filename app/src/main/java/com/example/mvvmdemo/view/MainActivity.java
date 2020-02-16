package com.example.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.view.ViewModel;

import java.sql.SQLException;
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
                    //if it returns true then the 'set' into database was a success and we can the 'get' the data we inserted
                    if (ViewModel.viewModel.setText(editText.getText().toString())){
                        //((TextView)findViewById(R.id.text_view1)).setText(editText.getText());
                        ((TextView)findViewById(R.id.text_view1)).setText(ViewModel.viewModel.getDBText());
                        System.out.println("everything works as intended");
                    } else System.out.println("SOMETHING VERY WRONG");
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });

        //this line will make sure the default text, when we open the app, is what we has stored in the database
        textView.setText(ViewModel.viewModel.getDBText());
    }

    @Override
    public void update(Observable observable, Object arg) {
        textView.setText(ViewModel.viewModel.getText());
    }
}
