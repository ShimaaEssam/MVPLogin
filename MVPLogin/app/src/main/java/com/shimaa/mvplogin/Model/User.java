package com.shimaa.mvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

import com.shimaa.mvplogin.Model.IUser;


public class User implements IUser {
    private  String email,pass;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public int isValidData() {
        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if(TextUtils.isEmpty(getPass()))
            return 1;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 2;
        else if (getPass().length()<6)
            return 3;
        else
            return -1;
    }
}
