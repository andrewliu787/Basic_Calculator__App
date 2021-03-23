package com.example.basiccalculator101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button SIN;
    private Button COS;
    private Button TAN;
    private Button CLEAR;
    private Button ENTER;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button negative;
    private Button DEL;
    private Button squareRoot;
    private Button exponent;
    private Button decimal;
    private TextView input;
    private TextView output;
    private final char ADD = '+';
    private final char SUB = '−';
    private final char TIMES = '*';
    private final char DIV = '/';
    private final char DECIMAL = '.';
    private final char SQUAREROOT = '√';
    private final char POWER = '^';
    private final char ENT = '$';
    private final char sine = 's';
    private final char cosine = 'c';
    private final char tangent = 't';
    private double val1 = Double.NaN;
    private double val2 = Double.NaN;
    private char OPERATION;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewSetup();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                compute();
                OPERATION = ADD;
                output.setText(String.valueOf(val1) + "+");
                input.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = SUB;
                output.setText(String.valueOf(val1) + "−");
                input.setText(null);
                //input.setText(input.getText().toString() + SUB);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = TIMES;
                output.setText(String.valueOf(val1) + "*");
                input.setText(null);
                //input.setText(input.getText().toString() + TIMES);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = DIV;
                output.setText(String.valueOf(val1) + "/");
                input.setText(null);
                //input.setText(input.getText().toString() + DIV);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + ".");
            }
        });

        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("−"+ input.getText().toString());
            }
        });

        squareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = SQUAREROOT;
                output.setText("(" + SQUAREROOT + String.valueOf(val1));
                input.setText(null);
                //input.setText(input.getText().toString() + SQUAREROOT);
            }
        });

        SIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = sine;
                output.setText( "sin(" + input.getText().toString());
                input.setText(null);
                //input.setText(sine + "in(" + input.getText().toString());
            }
        });

        COS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = cosine;
                output.setText("cos(" + input.getText().toString());
                input.setText(null);
            }
        });

        TAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = tangent;
                output.setText("tan(" + input.getText().toString());
                input.setText(null);
            }
        });

        exponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = POWER;
                output.setText(String.valueOf(val1) + "^");
                input.setText(null);
            }
        });

        ENTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                OPERATION = ENT;
                if (!Double.isNaN(val2)){
                    output.setText(output.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
            }else{
                output.setText(output.getText().toString() + ") " + "= " + String.valueOf(val1));
            }
                input.setText(null);
            }
        });

        CLEAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                input.setText(null);
                output.setText(null);
            }
        });

        DEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() > 0){
                    CharSequence name = input.getText();
                    input.setText(name.subSequence(0, name.length() - 1));
                }else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    input.setText(null);
                    output.setText(null);

                }
                //input.setText(null);
            }
        });


    }

    private void viewSetup(){
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        SIN = (Button) findViewById(R.id.btnSIN);
        COS = (Button) findViewById(R.id.btnCOS);
        TAN = (Button) findViewById(R.id.btnTAN);
        CLEAR = (Button) findViewById(R.id.btnCLEAR);
        ENTER = (Button) findViewById(R.id.btnEnter);
        add = (Button) findViewById(R.id.btnAdd);
        subtract = (Button) findViewById(R.id.btnSubtract);
        multiply = (Button) findViewById(R.id.btnMultiply);
        DEL= (Button) findViewById(R.id.btnDEL);
        divide = (Button) findViewById(R.id.btnDivide);
        negative = (Button) findViewById(R.id.btnNEG);
        squareRoot = (Button) findViewById(R.id.btnROOT);
        exponent = (Button) findViewById(R.id.btnEXP);
        decimal = (Button) findViewById(R.id.btnDec);
        input = (TextView) findViewById(R.id.in);
        output = (TextView) findViewById(R.id.out);
    }

    private void compute(){

        if(!Double.isNaN(val1)){

            //val2 = Double.parseDouble(input.getText().toString());

            switch(OPERATION){
                case ADD:
                    val2 = Double.parseDouble(input.getText().toString());
                    val1 += val2;
                    break;
                case SUB:
                    val2 = Double.parseDouble(input.getText().toString());
                    val1 -= val2;
                    break;
                case TIMES:
                    val2 = Double.parseDouble(input.getText().toString());
                    val1 *= val2;
                    break;
                case DIV:
                    val2 = Double.parseDouble(input.getText().toString());
                    val1 /= val2;
                    break;
                case POWER:
                    val2 = Double.parseDouble(input.getText().toString());
                    val1 = pow(val1, val2);
                    break;
                case ENT:
                    break;
                case sine:

                    val1 = Math.sin(val1);
                    break;

                case cosine:
                    //val2 = Double.NaN;
                    val1 = cos(val1);
                    break;

                case tangent:
                    //val2 = Double.NaN;
                    val1 = Math.tan(val1);
                    break;

                case SQUAREROOT:
                    //val2 = Double.NaN;
                    val1 = sqrt(val1);
                    break;

            }
        }else{
            val1 = Double.parseDouble(input.getText().toString());
        }

    }
}
