module com.example.kindergartenmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;
    requires de.jensd.fx.glyphs.fontawesome;



    opens com.example.kindergartenmanager to javafx.fxml;
    exports com.example.kindergartenmanager;
    exports com.example.kindergartenmanager.model;
    opens com.example.kindergartenmanager.model to javafx.fxml;
    exports com.example.kindergartenmanager.dao;
    opens com.example.kindergartenmanager.dao to javafx.fxml;
    exports com.example.kindergartenmanager.controller;
    opens com.example.kindergartenmanager.controller to javafx.fxml;
}