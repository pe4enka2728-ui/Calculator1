package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonClean;
    private Button buttonSqrt, buttonSquare;
    private TextView operation, result;
    private EditText number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonClean = (Button) findViewById(R.id.buttonclean);
        buttonSqrt = (Button) findViewById(R.id.buttonSqrt);
        buttonSquare = (Button) findViewById(R.id.buttonSquare);
        operation = (TextView) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.result);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonClean.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
        buttonSquare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
     float num1=0;
     float num2=0;
     float res=0;
        if (id == R.id.buttonclean) {
            number1.setText("");
            number2.setText("");
            operation.setText("");
            result.setText("");
            return;
        }

        String text1 = number1.getText().toString().trim();
        String text2 = number2.getText().toString().trim();

        String pattern = "[+-]?\\d+(\\.\\d+)?";

        if (text1.matches(pattern) && text2.matches(pattern)) {
            num1 = Float.parseFloat(text1);
            num2 = Float.parseFloat(text2);
        } else {
            result.setText("Введите два корректных числа");
            return;
        }
     num1=Float.parseFloat(number1.getText().toString());
     num2=Float.parseFloat(number2.getText().toString());

        if (id == R.id.buttonAdd) {
            operation.setText("+");
            res = num1 + num2;
        } else if (id == R.id.buttonSubtract) {
            operation.setText("-");
            res = num1 - num2;
        } else if (id == R.id.buttonDivide) {
            operation.setText("/");
            res = num1 / num2;
        } else if (id == R.id.buttonMultiply) {
            operation.setText("*");
            res = num1 * num2;
        } else if (id == R.id.buttonSqrt) {
            operation.setText("√");
            res = (float) Math.pow(Math.abs(num1), 1.0 / num2);
        } else if (id == R.id.buttonSquare) {
            operation.setText("^");
            res = (float) Math.pow(num1, num2);
        } else {
            return;
        }




        result.setText(String.valueOf(res));

    }
}
