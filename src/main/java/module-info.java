module com.example.sistema_bancario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sistema_bancario to javafx.fxml;
    exports com.example.sistema_bancario;
    exports com.example.sistema_bancario.controllers;
    opens com.example.sistema_bancario.controllers to javafx.fxml;
    exports com.example.sistema_bancario.Main;
    opens com.example.sistema_bancario.Main to javafx.fxml;
    exports com.example.sistema_bancario.controllers;
    opens com.example.sistema_bancario.controllers to javafx.fxml;
}