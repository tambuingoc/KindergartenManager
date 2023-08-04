module com.example.kindergartenmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;
    requires de.jensd.fx.glyphs.fontawesome;



    opens com.example.kindergartenmanager to javafx.fxml;
    exports com.example.kindergartenmanager;
}