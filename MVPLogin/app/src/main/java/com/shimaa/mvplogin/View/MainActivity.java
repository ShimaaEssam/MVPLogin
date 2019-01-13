package com.shimaa.mvplogin.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shimaa.mvplogin.Presenter.Presenter;
import com.shimaa.mvplogin.R;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements IView {
    EditText email, pass;
    Button login;

    Presenter presenetr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("  Login");

        email = findViewById(R.id.EmailET);
        pass = findViewById(R.id.PassET);
        login = findViewById(R.id.Loginbtn);

        presenetr = new Presenter(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenetr.onLogin(email.getText().toString(), pass.getText().toString());
            }
        });


    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onLoginFail(String message) {
        Toasty.error(this, message, Toast.LENGTH_LONG).show();

    }
}
