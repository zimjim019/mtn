package com.example411.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button addBtn, subBtn, mulBtn, divBtn, modBtn;
    EditText numberOneEt, numberTwoEt;
    TextView resultTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);
        modBtn = findViewById(R.id.modBtn);

        numberOneEt = findViewById(R.id.numberOneEt);
        numberTwoEt = findViewById(R.id.numberTwoEt);

        resultTv = findViewById(R.id.resultTv);

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        modBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        double operandOne = Double.parseDouble(numberOneEt.getText().toString());
        double operandTwo = Double.parseDouble(numberTwoEt.getText().toString());
        double result;
        if (v.equals(addBtn)){
            result = operandOne + operandTwo;
        }else if(v.equals(subBtn)){
            result = operandOne - operandTwo;
        }else if(v.equals(mulBtn)){
            result = operandOne * operandTwo;
        }else if(v.equals(divBtn)){
            result = operandOne / operandTwo;
        }else if(v.equals(modBtn)){
            result = operandOne % operandTwo;
        }else {
            result = 0;
        }
        resultTv.setText(String.valueOf(result));
    }
}