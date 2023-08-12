package com.example.kindergartenmanager.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Notice {
    Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
    Alert alertError = new Alert(Alert.AlertType.ERROR);
    Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
    public Notice(){}
    public void successSignUp() {
        alertInformation.setTitle("Information Message");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("Successfully Sign up!");
        alertInformation.showAndWait();
    }
    public void accountExist() {
        alertError.setTitle("Error Message");
        alertError.setHeaderText(null);
        alertError.setContentText("The account has existed!");
        alertError.showAndWait();
    }
    public void accountNotExist() {
        alertError.setTitle("Error Message");
        alertError.setHeaderText(null);
        alertError.setContentText("The account doesn't exist!");
        alertError.showAndWait();
    }
    public void errorBlankField() {
        alertError.setTitle("Error Message");
        alertError.setHeaderText(null);
        alertError.setContentText("Please fill all the blank fields");
        alertError.showAndWait();
    }
    public void successLogin() {
        alertInformation.setTitle("Information Message");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("Successfully Login!");
        alertInformation.showAndWait();
    }

    public void invalidEmail() {
        alertError.setTitle("Error Message");
        alertError.setHeaderText(null);
        alertError.setContentText("Invalid Email");
        alertError.showAndWait();
    }
    public Optional<ButtonType> confirmLogout() {
        alertConfirm.setTitle("Confirmation Message");
        alertConfirm.setHeaderText(null);
        alertConfirm.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alertConfirm.showAndWait();
        return option;
    }
    public void successDelete() {
        alertInformation.setTitle("Information Message");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("Successfully Deleted!");
        alertInformation.showAndWait();
    }
    public void successUpdate() {
        alertInformation.setTitle("Information Message");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("Successfully Updated!");
        alertInformation.showAndWait();
    }
    public void successAdd() {
        alertInformation.setTitle("Information Message");
        alertInformation.setHeaderText(null);
        alertInformation.setContentText("Successfully Added!");
        alertInformation.showAndWait();
    }
    public void falseAdd() {
        alertError.setTitle("Error Message");
        alertError.setHeaderText(null);
        alertError.setContentText("Add Student Failed!");
        alertError.showAndWait();
    }
}
