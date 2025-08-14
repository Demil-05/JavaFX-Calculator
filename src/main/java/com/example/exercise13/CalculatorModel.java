package com.example.exercise13;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CalculatorModel {
    private double leftOperand;
    private double rightOperand;
    private StringProperty result = new SimpleStringProperty();
    private String operator;

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public StringProperty resultProperty() {
        return result;
    }

    public void calculateResult() {
        double res;
        switch (operator) {
            case "+":
                res = leftOperand + rightOperand;
                break;

            case "-":
                res = leftOperand - rightOperand;
                break;

            case "*":
                res = leftOperand * rightOperand;
                break;

            case "/":
                if (rightOperand != 0) res = leftOperand / rightOperand;
                else {
                    result.set("Error: Division by zero");
                    return;
                };
                break;

            default:
                result.set("Error: Unknown operator");
                return;

        }

        result.set(String.valueOf(res));

    }
}
