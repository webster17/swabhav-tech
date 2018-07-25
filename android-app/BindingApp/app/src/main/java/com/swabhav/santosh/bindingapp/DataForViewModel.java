package com.swabhav.santosh.bindingapp;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.swabhav.santosh.bindingapp.databinding.ActivityMainBinding;

public class DataForViewModel extends BaseObservable{
    private String fname;
    private String lname;
    private String address;
    private String fnameInput;
    private Activity activity;
    private ActivityMainBinding binding;
    private int i=0;

    public DataForViewModel(Activity activity, ActivityMainBinding binding){
        this.activity = activity;
        this.binding = binding;
        intialize();
        this.binding.setViewModel(this);
    }

    private void intialize(){
        this.fname="Santosh";
        this.lname="Dangodra";
        this.address="Dahisar, Mumbai";
        this.fnameInput="";

        this.binding.changeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAddress(address+(++i));
            }
        });
    }

    @Bindable
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
        notifyPropertyChanged(BR.fname);
    }

    @Bindable
    public String getFnameInput(){
        return fnameInput;
    }

    public void setFnameInput(String fnameInput){
        this.fnameInput = fnameInput;
        setFname(fnameInput);
        notifyPropertyChanged(BR.fnameInput);
    }

    @Bindable
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
        notifyPropertyChanged(BR.lname);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }
}