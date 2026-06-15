module com.example.sistema_bancario {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.xml.crypto;

    opens com.example.sistema_bancario to javafx.fxml;

    requires javafx.base;
    requires kernel;
    requires layout;

    exports com.example.sistema_bancario.main;
    opens com.example.sistema_bancario.main to javafx.fxml;
    exports com.example.sistema_bancario.controller.servicosController;
    opens com.example.sistema_bancario.controller.servicosController to javafx.fxml;

    exports com.example.sistema_bancario.controller.login.e.cadastro.controllers;
    opens com.example.sistema_bancario.controller.login.e.cadastro.controllers to javafx.fxml;

}