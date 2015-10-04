package kevinmorton.com.assignment_1_kjm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity implements View.OnClickListener {
    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero, buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonCancel, buttonEqual, buttonDecimal;
    EditText editText;
    double valueOne, valueTwo;
    boolean shouldAdd, shouldSubtract, shouldDivide, shouldMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //   Set up buttons and identify using their IDs
        buttonZero = (Button) findViewById(R.id.zero);
        buttonOne = (Button) findViewById(R.id.one);
        buttonTwo = (Button) findViewById(R.id.two);
        buttonThree = (Button) findViewById(R.id.three);
        buttonFour = (Button) findViewById(R.id.four);
        buttonFive = (Button) findViewById(R.id.five);
        buttonSix = (Button) findViewById(R.id.six);
        buttonSeven = (Button) findViewById(R.id.seven);
        buttonEight = (Button) findViewById(R.id.eight);
        buttonNine = (Button) findViewById(R.id.nine);
        buttonAdd = (Button) findViewById(R.id.add);
        buttonSubtract = (Button) findViewById(R.id.subtract);
        buttonDivide = (Button) findViewById(R.id.divide);
        buttonMultiply = (Button) findViewById(R.id.multiply);
        buttonEqual = (Button) findViewById(R.id.equal);
        buttonCancel = (Button) findViewById(R.id.cancel);
        buttonDecimal = (Button) findViewById(R.id.decimalPlace);
        editText = (EditText) findViewById(R.id.displayText);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText() + "3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText() + "4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText() + "7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText() + "8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText() + "0");
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + ".");
            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(editText.getText() + "");
                shouldMultiply = true;
                editText.setText(null);
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(editText.getText() + "");
                shouldDivide = true;
                editText.setText(null);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(editText.getText() + "");
                shouldAdd = true;
                editText.setText(null);
            }
        });
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(editText.getText() + "");
                shouldSubtract = true;
                editText.setText(null);
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("0");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Double.parseDouble(editText.getText() + "");
                if (shouldAdd) {
                    editText.setText(valueOne + valueTwo + "");
                    shouldAdd = false;
                }
                if (shouldSubtract) {
                    editText.setText(valueOne - valueTwo + "");
                    shouldSubtract = false;
                }
                if (shouldMultiply) {
                    editText.setText(valueOne * valueTwo + "");
                    shouldMultiply = false;
                }
                if (shouldDivide) {
                    if (valueTwo == 0 || valueTwo ==0.0){
                        editText.setText("0");
                        shouldDivide = false;
                    } else {
                        editText.setText(valueOne / valueTwo + "");
                    }
                    shouldDivide = false;
                }
                if (shouldDivide) {
                    editText.setText(valueOne / valueTwo + "");
                    shouldDivide = false;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

}