package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private TextView TextView1;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button buttonDiv;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button buttonMul;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonSub;
    private Button button0;
    private Button buttonDot;
    private Button buttonEqual;
    private Button buttonAdd;
    private String currentInput = "";
    private double operand1 = 0;
    private String operator = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView1 = findViewById(R.id.TextView1);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        updateDisplay();
    }

    public void onOperatorClick(View view) {
        if (!currentInput.isEmpty()) {
            operand1 = Double.parseDouble(currentInput);
            operator = ((Button) view).getText().toString();
            currentInput = "";
        }
    }

    public void onEqualsClick(View view) {
        if (!currentInput.isEmpty()) {
            double operand2 = Double.parseDouble(currentInput);
            double result = performOperation(operand1, operand2, operator);
            currentInput = String.valueOf((result));
            updateDisplay();
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        operand1 = 0;
        operator = "";
        updateDisplay();
    }

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return Double.NaN;
                }
            default:
                return 0;
        }
    }

    public void updateDisplay() {
        TextView1.setText(currentInput);
    }
}
