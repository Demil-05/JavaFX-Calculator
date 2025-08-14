package com.example.exercise13;

import javafx.scene.control.Button;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;
    private final StringBuilder currentInput = new StringBuilder();

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Connect model result to view display
        model.resultProperty().addListener((obs, oldVal, newVal) -> view.getDisplay().setText(newVal));

        // Number buttons
        for (Button btn : view.getNumberButtons()) {
            if (btn != null) {
                btn.setOnAction(e -> {
                    currentInput.append(btn.getText());
                    view.getDisplay().setText(currentInput.toString());
                });
            }
        }

        // Operators
        view.getAddButton().setOnAction(e -> storeOperandAndOperator("+"));
        view.getSubtractButton().setOnAction(e -> storeOperandAndOperator("-"));
        view.getMultiplyButton().setOnAction(e -> storeOperandAndOperator("*"));
        view.getDivideButton().setOnAction(e -> storeOperandAndOperator("/"));

        // Equals
        view.getEqualsButton().setOnAction(e -> {
            if (!currentInput.isEmpty()) {
                double right = Double.parseDouble(currentInput.toString());
                model.setRightOperand(right);
                model.calculateResult();
                currentInput.setLength(0);
            }
        });

        // C (clear last digit)
        view.getClearLastButton().setOnAction(e -> {
            if (!currentInput.isEmpty()) {
                currentInput.deleteCharAt(currentInput.length() - 1);
                view.getDisplay().setText(currentInput.toString());
            }
        });

        // CE (clear all input)
        view.getClearAllButton().setOnAction(e -> {
            currentInput.setLength(0);
            view.getDisplay().clear();
        });
    }

    private void storeOperandAndOperator(String op) {
        if (!currentInput.isEmpty()) {
            double left = Double.parseDouble(currentInput.toString());
            model.setLeftOperand(left);
            model.setOperator(op);
            currentInput.setLength(0);
            view.getDisplay().clear();
        }
    }
}
