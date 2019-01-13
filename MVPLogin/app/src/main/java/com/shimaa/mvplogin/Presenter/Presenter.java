package com.shimaa.mvplogin.Presenter;

import com.shimaa.mvplogin.View.IView;
import com.shimaa.mvplogin.Model.User;

public class Presenter implements IPresenetr {
    IView iView;

    public Presenter(IView iView) {
        this.iView = iView;
    }

    @Override
    public void onLogin(String email, String pass) {

        User user=new User(email,pass);
        int isloginSuccess=user.isValidData();
        if(isloginSuccess==0)
            iView.onLoginFail("You must Enter Your Email");
        else if(isloginSuccess==1)
            iView.onLoginFail("You must Enter Your Pass");
        else if(isloginSuccess==2)
            iView.onLoginFail("You must Enter Correct Email");
        else if(isloginSuccess==3)
            iView.onLoginFail("You must Enter Pass more  than or equal to 6");
        else
            iView.onLoginSuccess("Login Success");
    }
}
