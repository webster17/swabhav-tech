package com.swabhav.santosh.bindingapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.swabhav.santosh.bindingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new DataForViewModel(this, (ActivityMainBinding) DataBindingUtil.setContentView(this, R.layout.activity_main));
    }
}