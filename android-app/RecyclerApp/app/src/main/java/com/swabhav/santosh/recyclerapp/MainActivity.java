package com.swabhav.santosh.recyclerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.swabhav.santosh.recyclerapp.implementation.DataViewAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private View.OnClickListener onClickListener;
    private Button changeDataSet;
    private int i = 0;

    String[] names = {"Sarvesh", "Santosh", "Vipul", "Prasad", "Himanshu", "Pratik", "Dheeraj"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        changeDataSet = (Button) findViewById(R.id.changeDataSet);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) view;
                Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        };

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //final DataViewAdapter dataViewAdapter = new DataViewAdapter(names, onClickListener);
        recyclerView.setAdapter(new DataViewAdapter(names, onClickListener));

        changeDataSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names[i % 7] = names[i % 7] + (i + 1) % 8;
                recyclerView.setAdapter(new DataViewAdapter(names, onClickListener));
                i++;
            }
        });

    }
}