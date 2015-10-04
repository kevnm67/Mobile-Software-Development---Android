package kevinmorton.com.assignment_1_calculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity implements View.OnClickListener {
    Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero, buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonCancel, buttonEqual, buttonDecimal;
    String optionSelected;
    EditText editText;
    int valueOne, valueTwo;
    boolean shouldAdd, shouldSubtract, shouldDivide, shouldMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
//        Set up buttons and identify using their IDs
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
        try {
            buttonZero.setOnClickListener(this);
            buttonOne.setOnClickListener(this);
            buttonTwo.setOnClickListener(this);
            buttonThree.setOnClickListener(this);
            buttonFour.setOnClickListener(this);
            buttonFive.setOnClickListener(this);
            buttonSix.setOnClickListener(this);
            buttonSeven.setOnClickListener(this);
            buttonEight.setOnClickListener(this);
            buttonNine.setOnClickListener(this);
            buttonZero.setOnClickListener(this);
            buttonCancel.setOnClickListener(this);
            buttonAdd.setOnClickListener(this);
            buttonSubtract.setOnClickListener(this);
            buttonMultiply.setOnClickListener(this);
            buttonDecimal.setOnClickListener(this);
            buttonDivide.setOnClickListener(this);
        } catch (Exception e) {
        }
    }

    public void operation() {
        if (optionSelected.equals("+")) {
            valueTwo = Integer.parseInt(editText.getText().toString());
            editText.setText("");
            valueOne = valueOne + valueTwo;
            editText.setText("= " + Integer.toString(valueOne));
        } else if (optionSelected.equals("-")) {
            valueTwo = Integer.parseInt(editText.getText().toString());
            editText.setText("");
            valueOne = valueOne - valueTwo;
            editText.setText("= " + Integer.toString(valueOne));
        } else if (optionSelected.equals("*")) {
            valueTwo = Integer.parseInt(editText.getText().toString());
            editText.setText("");
            valueOne = valueOne * valueTwo;
            editText.setText("= " + Integer.toString(valueOne));
        } else if (optionSelected.equals("/")) {
            valueTwo = Integer.parseInt(editText.getText().toString());
            editText.setText("");
            valueOne = valueOne / valueTwo;
            editText.setText("= " + Integer.toString(valueOne));
        }
    }
    @Override
    public void onClick(View arg0) {
        Editable str = editText.getText();
        switch (arg0.getId()) {
            case R.id.one:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonTwo.getText());
                editText.setText(str);
                break;
            case R.id.two:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonTwo.getText());
                editText.setText(str);
                break;
            case R.id.three:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonThree.getText());
                editText.setText(str);
                break;
            case R.id.four:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonFour.getText());
                editText.setText(str);
                break;
            case R.id.five:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonFive.getText());
                editText.setText(str);
                break;
            case R.id.six:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonSix.getText());
                editText.setText(str);
                break;
            case R.id.seven:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonEight.getText());
                editText.setText(str);
                break;
            case R.id.eight:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonNine.getText());
                editText.setText(str);
                break;
            case R.id.nine:
                if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                }
                str = str.append(buttonZero.getText());
                editText.setText(str);
                break;
            case R.id.cancel:
                valueOne = 0;
                valueTwo = 0;
                editText.setText("");
                editText.setHint("Click on a number to begin a calculation. Hit '=' to display the result.");
                break;
            case R.id.add:
                optionSelected = "+";
                if (valueOne == 0) {
                    valueOne = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                } else if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                } else {
                    valueTwo = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                    valueOne = valueOne + valueTwo;
                    editText.setText("= " + Integer.toString(valueOne));
                }
                break;
            case R.id.subtract:
                optionSelected = "-";
                if (valueOne == 0) {
                    valueOne = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                } else if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                } else {
                    valueTwo = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                    valueOne = valueOne - valueTwo;
                    editText.setText("= " + Integer.toString(valueOne));
                }
                break;
            case R.id.multiply:
                optionSelected = "*";
                if (valueOne == 0) {
                    valueOne = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                } else if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                } else {
                    valueTwo = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                    valueOne = valueOne * valueTwo;
                    editText.setText("= " + Integer.toString(valueOne));
                }
                break;
            case R.id.divide:
                optionSelected = "/";
                if (valueOne == 0) {
                    valueOne = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                } else if (valueTwo != 0) {
                    valueTwo = 0;
                    editText.setText("");
                } else {
                    valueTwo = Integer.parseInt(editText.getText().toString());
                    editText.setText("");
                    valueOne = valueOne / valueTwo;
                    editText.setText("= " + Integer.toString(valueOne));
                }
                break;
            case R.id.equal:
                if (!optionSelected.equals(null)) {
                    if (valueTwo != 0) {
                        if (optionSelected.equals("+")) {
                            editText.setText(""); /*valueOne = valueOne + valueTwo;*/
                            editText.setText("= " + Integer.toString(valueOne));
                        } else if (optionSelected.equals("-")) {
                            editText.setText("");/* valueOne = valueOne - valueTwo;*/
                            editText.setText("= " + Integer.toString(valueOne));
                        } else if (optionSelected.equals("*")) {
                            editText.setText("");/* valueOne = valueOne * valueTwo;*/
                            editText.setText("= " + Integer.toString(valueOne));
                        } else if (optionSelected.equals("/")) {
                            editText.setText("");/* valueOne = valueOne / valueTwo;*/
                            editText.setText("= " + Integer.toString(valueOne));
                        }
                    } else {
                        operation();
                    }
                }
                break;
        }
    }
}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_calculator, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
