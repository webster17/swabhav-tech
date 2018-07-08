package com.techlabs.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnClick;
    private TextView viewLabel;
    private EditText inputText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = this.findViewById(R.id.btn_click);
        viewLabel= this.findViewById(R.id.txtview_welcome);
        inputText= this.findViewById(R.id.txt_name);
        imageView = this.findViewById(R.id.imageView);
        viewLabel.setVisibility(View.GONE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.toast_notify, Toast.LENGTH_LONG).show();
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewLabel.setVisibility(View.VISIBLE);
                viewLabel.setText("Welcome in first app, "+inputText.getText());
                inputText.setText("");
            }
        });
    }
}