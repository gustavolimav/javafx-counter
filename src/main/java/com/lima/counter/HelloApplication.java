package com.lima.counter;

import javafx.application.Application;
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
        Label labelTitle = new Label("Counter");
        Label labelNumber = new Label("0");

        Button buttonIncrement = new Button("+");
        Button buttonDecrement = new Button("-");

        HBox buttonBox = new HBox();
        VBox contentBox = new VBox();

        buttonDecrement.setOnAction(e -> {
            counter--;
            _updateLabelNumber(labelNumber);
        });

        buttonIncrement.setOnAction(e -> {
            counter++;
            _updateLabelNumber(labelNumber);
        });

        buttonDecrement.getStyleClass().add("button");
        buttonIncrement.getStyleClass().add("button");

        labelNumber.getStyleClass().add("number");
        labelTitle.getStyleClass().add("title");

        buttonBox.getChildren().add(buttonDecrement);
        buttonBox.getChildren().add(buttonIncrement);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        contentBox.getChildren().add(labelTitle);
        contentBox.getChildren().add(labelNumber);
        contentBox.getChildren().add(buttonBox);
        contentBox.getStyleClass().add("background");
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setSpacing(10);

        String pathCss = getClass().getResource("/com/lima/counter/css/Counter.css").toExternalForm();
        Scene scene = new Scene(contentBox, 400, 400);
        scene.getStylesheets().add(pathCss);
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald&display=swap");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void _updateLabelNumber(Label label) {
        label.setText(Integer.toString(counter));

        label.getStyleClass().remove("red");
        label.getStyleClass().remove("green");

        if(counter > 0) {
            label.getStyleClass().add("green");
        } else if (counter < 0) {
            label.getStyleClass().add("red");
        }
    }

    private int counter = 0;
}