package com.swabhav.santosh.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.swabhav.santosh.loginapp.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class CredentialViewModel extends BaseObservable{

    private Activity activity;
    private ActivityMainBinding binding;
    private String userName;
    private String password;
    private String loginBtnText;

    public CredentialViewModel(Activity activity, ActivityMainBinding binding){
        this.activity=activity;
        this.binding=binding;
        this.setUserName("");
        this.setPassword("");
        this.setLoginBtnText("Login");
        this.binding.setCredentialViewModel(this);
    }


    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    private Activity getActivity(){
        return this.activity;
    }

    public void authAttempt(final View view){
        setLoginBtnText("Logging In...");
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                if(getUserName().trim().length() < 1 || getPassword().trim().length()<1){
                    setLoginBtnText("Retry Login");
                    Snackbar.make(view, "Username and Password is required", Snackbar
                            .LENGTH_LONG).setAction("Action", null).show();
                }
                else {
                    Intent intent = new Intent(activity, WelcomeActivity.class);
                    intent.putExtra("userName", userName);
                    getActivity().startActivityForResult(intent, 2);
                    setUserName("");
                    setPassword("");
                    setLoginBtnText("Login");
                }
            }
        }, 1200);
    }

    @Bindable
    public String getLoginBtnText() {
        return loginBtnText;
    }

    public void setLoginBtnText(String loginBtnText) {
        this.loginBtnText = loginBtnText;
        notifyPropertyChanged(BR.loginBtnText);
    }
}