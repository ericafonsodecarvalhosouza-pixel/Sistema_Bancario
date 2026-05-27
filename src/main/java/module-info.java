module com.example.sistema_bancario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sistema_bancario to javafx.fxml;
    exports com.example.sistema_bancario;
    exports com.example.sistema_bancario.controller;
    opens com.example.sistema_bancario.controller to javafx.fxml;
}