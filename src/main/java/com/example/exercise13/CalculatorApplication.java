package com.example.exercise13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        new CalculatorController(model, view);

        Scene scene = new Scene(view, 300, 400);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}