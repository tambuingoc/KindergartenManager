package com.example.kindergartenmanager;

import com.example.kindergartenmanager.helper.Helper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String packageName= "/com/example/kindergartenmanager/";
        String initScence = "admin.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(packageName+initScence));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}