package ru.diti.converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;

public class ConverterApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane root = FXMLLoader.load(getClass().getClassLoader().getResource("converter/main.fxml"));

        Scene scene = new Scene(root, 500, 275);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("css/main.css").toExternalForm());

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
