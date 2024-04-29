package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TipCalculator tipCalculator;
    EditText amount;
    TextView tipAmount;
    private  static  final DecimalFormat decFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tipCalculator = new TipCalculator();
        amount = (EditText) findViewById(R.id.costOfService);
        tipAmount = (TextView) findViewById(R.id.tipAmount);

    }

    private void calculateTip(double tip, double total_amount){
        double tipAmountString = tipCalculator.calculateTip(tip, total_amount);
        //System.out.println(decFormat.format(tipAmountString));
        tipAmount.setText(decFormat.format(tipAmountString));
    }


    public void calculateFifteen(View view) {
        double tip = 0.15;
        double a = Double.parseDouble(amount.getText().toString());
        calculateTip(tip, a);
    }

    public void calculateFive(View view) {
        double tip = 0.05;
        double a = Double.parseDouble(amount.getText().toString());
        calculateTip(tip, a);
    }

    public void calculateSeven(View view) {
        double tip = 0.07;
        double a = Double.parseDouble(amount.getText().toString());
        calculateTip(tip, a);
    }

    public void calculateTen(View view) {
        double tip = 0.1;
        double a = Double.parseDouble(amount.getText().toString());
        calculateTip(tip, a);
    }
}