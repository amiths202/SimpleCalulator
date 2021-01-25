package com.example.testcalulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,zero,plus,min,div,mul,eql,clear,dec;
    EditText inputVal;
    TextView equation;
    float val1 = Float.NaN,val2;
    int flag=0;
    StringBuilder strEqn = new StringBuilder();
    private void computeCalculation() {
        if(!Double.isNaN(val1)) {
            val2 = Float.parseFloat(inputVal.getText().toString());
            inputVal.setText(null);
            if(flag == 1)
                val1 = this.val1 + val2;
            else if(flag == 2)
                val1 = this.val1 - val2;
            else if(flag == 3)
                val1 = this.val1 * val2;
            else if(flag == 4)
                val1 = this.val1 / val2;
        }
        else try {
            val1 = Float.parseFloat(inputVal.getText().toString());
        } catch (Exception ignored) {
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equation = findViewById(R.id.eqn);
        inputVal = findViewById(R.id.inputVal);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.button0);
        plus = findViewById(R.id.buttonadd);
        min = findViewById(R.id.buttonsub);
        mul = findViewById(R.id.buttonmul);
        div = findViewById(R.id.buttondiv);
        eql = findViewById(R.id.buttoneql);
        clear = findViewById(R.id.buttonC);
        dec = findViewById(R.id.button10);

        one.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "1"));
        two.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "2"));
        three.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "3"));
        four.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "4"));
        five.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "5"));
        six.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "6"));
        seven.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "7"));
        eight.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "8"));
        nine.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "9"));
        zero.setOnClickListener(v -> inputVal.setText(inputVal.getText() + "0"));

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEqn.append(inputVal.getText() + "+");
                computeCalculation();
                flag = 1;
                equation.setText(strEqn);
                inputVal.setText(null);
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEqn.append(inputVal.getText() + "-");
                computeCalculation();
                flag = 2;
                equation.setText(strEqn);
                inputVal.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEqn.append(inputVal.getText() + "x");
                computeCalculation();
                flag = 3;
                equation.setText(inputVal.getText() + "x");
                inputVal.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strEqn.append(inputVal.getText() + "/");
                computeCalculation();
                flag = 4;
                equation.setText(inputVal.getText() + "/");
                inputVal.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputVal.setText(null);
                equation.setText(null);
                strEqn.delete(0,strEqn.length());
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputVal.setText(inputVal.getText() + ".");
            }
        });
       eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                equation.setText(equation.getText().toString() +
                        val2 + " = " + val1);
                val1 = Float.NaN;
                flag = 0;
            }
        });
    }
}