package com.example411.termworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener{
    EditText usernameett;
    EditText passwordett;
    Button loginbtn;
    String username;
    String password;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameett = findViewById(R.id.usernameETT);
        passwordett = findViewById(R.id.passwordETT);
        loginbtn = findViewById(R.id.loginBTN);
        loginbtn.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("data");
        username = bundle.getString("user");
        password = bundle.getString("Lab@2022");
    }

    @Override
    public void onClick(View v) {
        String user = usernameett.getText().toString();
        String pass = passwordett.getText().toString();

        if(username.equals(user) && password.equals(pass)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
        }else {
            count++;
            if (count == 3){
                loginbtn.setEnabled(false);
                Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}