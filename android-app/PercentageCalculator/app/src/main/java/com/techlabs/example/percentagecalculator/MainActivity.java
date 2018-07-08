package com.techlabs.example.percentagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText fname;
    private EditText lname;
    private TextView view_fname;
    private TextView view_lname;
    private TextView view_percentage;
    private CardView view_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = this.findViewById(R.id.fname);
        lname = this.findViewById(R.id.lname);
        view_fname = this.findViewById(R.id.view_fname);
        view_lname = this.findViewById(R.id.view_lname);
        view_percentage = this.findViewById(R.id.view_percentage);
        view_card = this.findViewById(R.id.view_card);
        view_card.setVisibility(View.GONE);

        TextWatcher fieldValidateText = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(lname.getText().toString().matches("") || fname.getText().toString().matches(""))
                    view_card.setVisibility(View.GONE);
                else
                    displayCalculatedPercentage();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        fname.addTextChangedListener(fieldValidateText);
        lname.addTextChangedListener(fieldValidateText);
    }

    private void displayCalculatedPercentage(){
        view_lname.setText(lname.getText());
        view_fname.setText(fname.getText());
        long percentage = fname.getText().toString().hashCode()+lname.getText().toString().hashCode();
        view_percentage.setText((Math.abs(percentage)%101)+"%");
        view_card.setVisibility(View.VISIBLE);
    }
}

