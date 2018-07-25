package com.swabhav.santosh.loginapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.swabhav.santosh.loginapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private CredentialViewModel credentialViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        credentialViewModel = new CredentialViewModel(this, binding);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(resultCode, requestCode, intent);
        if(resultCode == 2) {
            Toast.makeText(getApplicationContext(), "Logged out successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
