package com.example411.termworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usernameett;
    EditText passwordett;
    Button signbtn;
    String RE = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameett = findViewById(R.id.usernameETT);
        passwordett = findViewById(R.id.passwordETT);
        signbtn = findViewById(R.id.signBTN);
        signbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = usernameett.getText().toString();
        String password = passwordett.getText().toString();

        if (checkPassword(password)){
            Bundle bundle = new Bundle();
            bundle.putString("user", username);
            bundle.putString("Lab@2022", password);

            Intent intent = new Intent(this, login.class);
            intent.putExtra("data", bundle);
            startActivity(intent);
        }else{
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(RE);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}