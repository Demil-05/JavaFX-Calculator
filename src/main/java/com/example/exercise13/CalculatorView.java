package com.example.exercise13;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculatorView extends BorderPane {
    private final TextField display = new TextField("0");
    private final Button[] numberButtons = new Button[10];
    private final Button addButton = new Button("+");
    private final Button subtractButton = new Button("-");
    private final Button multiplyButton = new Button("*");
    private final Button divideButton = new Button("/");
    private final Button equalsButton = new Button("=");
    private final Button clearLastButton = new Button("C");
    private final Button clearAllButton = new Button("CE");

    public CalculatorView() {
        VBox vbox = new VBox(25);
        display.setEditable(false);
        display.setMaxWidth(180);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        int num = 1;
        for (int row = 2; row >= 0; row--) {
            for(int col = 0; col < 3; col++) {
                numberButtons[num] = new Button(String.valueOf(num));
                numberButtons[num].setMinSize(50, 50);
                grid.add(numberButtons[num], col, row);
                num++;
            }
        }

        numberButtons[0] = new Button("0");
        numberButtons[0].setMinSize(50, 50);
        grid.add(numberButtons[0], 1, 3);

        // Operators
        addButton.setMinSize(50, 50);
        subtractButton.setMinSize(50, 50);
        multiplyButton.setMinSize(50, 50);
        divideButton.setMinSize(50, 50);
        equalsButton.setMinSize(50, 50);
        clearLastButton.setMinSize(50, 50);
        clearAllButton.setMinSize(50, 50);

        grid.add(addButton, 3, 0);
        grid.add(subtractButton, 3, 1);
        grid.add(multiplyButton, 3, 2);
        grid.add(divideButton, 3, 3);
        grid.add(equalsButton, 2, 3);
        grid.add(clearLastButton, 0, 3);
        grid.add(clearAllButton, 3, 4);

        vbox.getChildren().add(0, display);
        vbox.getChildren().add(1, grid);

        setCenter(vbox);
    }

    public TextField getDisplay() { return display; }
    public Button[] getNumberButtons() { return numberButtons; }
    public Button getAddButton() { return addButton; }
    public Button getSubtractButton() { return subtractButton; }
    public Button getMultiplyButton() { return multiplyButton; }
    public Button getDivideButton() { return divideButton; }
    public Button getEqualsButton() { return equalsButton; }
    public Button getClearLastButton() { return clearLastButton; }
    public Button getClearAllButton() { return clearAllButton; }
}
