package com.lima.contador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Label labelTitle = new Label("Contador");
        Label labelNumber = new Label("0");

        Button buttonIncrement = new Button("+");
        Button buttonDecrement = new Button("-");

        HBox buttonBox = new HBox();
        VBox primaryBox = new VBox();

        buttonDecrement.setOnAction(e -> {
            contador--;
            labelNumber.setText(Integer.toString(contador));
        });

        buttonIncrement.setOnAction(e -> {
            contador++;
            labelNumber.setText(Integer.toString(contador));
        });

        buttonBox.getChildren().add(buttonDecrement);
        buttonBox.getChildren().add(buttonIncrement);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        primaryBox.getChildren().add(buttonBox);
        primaryBox.getChildren().add(labelNumber);
        primaryBox.getChildren().add(labelTitle);
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(10);

        Scene scene = new Scene(primaryBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private int contador = 0;
}