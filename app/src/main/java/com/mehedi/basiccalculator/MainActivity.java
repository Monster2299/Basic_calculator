package com.mehedi.basiccalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private Button add,sub,div,multi,eq,clear,delete;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        declaration();
        click_function();

    }
    public void declaration(){
        btn0 = findViewById(R.id.button10);
        btn1 = findViewById(R.id.button7);
        btn2 = findViewById(R.id.button8);
        btn3 = findViewById(R.id.button9);
        btn4 = findViewById(R.id.button6);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button4);
        btn7 = findViewById(R.id.button);
        btn8 = findViewById(R.id.button2);
        btn9 = findViewById(R.id.button3);

        add = findViewById(R.id.button14);
        sub = findViewById(R.id.button13);
        div = findViewById(R.id.button12);
        multi = findViewById(R.id.mult);
        eq = findViewById(R.id.button15);

        clear = findViewById(R.id.clear);
        delete = findViewById(R.id.delete);

        display = findViewById(R.id.display);

    }
    public void click_function(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        multi.setOnClickListener(this);
        div.setOnClickListener(this);
        eq.setOnClickListener(this);
        clear.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.button10:
          display.append("0");
            break;
        case R.id.button7:
            display.append("1");
            break;
        case R.id.button8 :
            display.append("2");
            break;
        case R.id.button9 :
            display.append("3");
            break;
        case R.id.button6 :
            display.append("4");
            break;
        case R.id.button5 :
            display.append("5");
            break;
        case R.id.button4 :
            display.append("6");
            break;
        case R.id.button :
            display.append("7");
            break;
        case R.id.button2 :
            display.append("8");
            break;
        case R.id.button3 :
            display.append("9");
            break;
        case R.id.clear :
            display.setText("");
            break;
        case R.id.delete :
           String s = display.getText().toString();
            if (s.length()!=0) {
                StringBuffer sb = new StringBuffer(s);
                sb.deleteCharAt(sb.length() - 1);
                display.setText(sb);
            }
            break;
        case R.id.button14 :
          display.append("+");

            break;
        case R.id.button13 :
            display.append("-");
            break;
        case R.id.button12 :
            display.append("/");
            break;
        case R.id.mult :
            display.append("*");
            break;
        case R.id.button15 :
            String dis = display.getText().toString();
           int n = dis.length();
            if (n>0) {
                char first = dis.charAt(0);
                char last = dis.charAt(n - 1);
                boolean eq;
                eq = dis.contains("=");
                if (first != '+' && first != '-' && first != '/' && first != '*' && first != '=' && last != '+' && last != '-' && last != '*' && last != '/' && last != '=' && first != 'S' && !eq) {
                    Expression expression = new ExpressionBuilder(dis).build();
                    double result = expression.evaluate();
                    display.append("=" + result);
                } else {
                    display.setText("Syntax Error !");
                }
            }else {
                Toast.makeText(this, "Input is blank !", Toast.LENGTH_SHORT).show();
            }
            break;
    }

    }
}