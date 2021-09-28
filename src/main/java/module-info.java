module fr.damien.library {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    opens fr.damien.library to javafx.fxml;
    exports fr.damien.library;
    exports fr.damien.library.controller;
    opens fr.damien.library.controller to javafx.fxml;
}