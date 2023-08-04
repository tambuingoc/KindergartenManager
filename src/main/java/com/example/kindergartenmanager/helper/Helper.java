package com.example.kindergartenmanager.helper;

import com.example.kindergartenmanager.dao.DBUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {

    public static void changeScence(ActionEvent event, String fxmlFile, String title, String username, String password) {
        Parent root = null;
        String packageName= "/com/example/kindergartenmanager/";
        if(username != null && password != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(packageName+fxmlFile));
                root  = loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(packageName+fxmlFile));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public static void changeScence(ActionEvent event, String fxmlFile) {
        Parent root = null;
        String packageName= "/com/example/kindergartenmanager/";
        try {
            root = FXMLLoader.load(DBUtils.class.getResource(packageName+fxmlFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }
}
