module com.example.sistema_bancario {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.example.sistema_bancario;
    requires java.desktop;


    opens com.example.sistema_bancario to javafx.fxml;
<<<<<<< HEAD
    exports com.example.sistema_bancario;
    exports com.example.sistema_bancario.controllers;
    opens com.example.sistema_bancario.controllers to javafx.fxml;
    exports com.example.sistema_bancario.Main;
    opens com.example.sistema_bancario.Main to javafx.fxml;
    exports com.example.sistema_bancario.controllers;
    opens com.example.sistema_bancario.controllers to javafx.fxml;
=======
    exports com.example.sistema_bancario.controller;
    opens com.example.sistema_bancario.controller to javafx.fxml;
    exports com.example.sistema_bancario.Main;
    opens com.example.sistema_bancario.Main to javafx.fxml;
    exports com.example.sistema_bancario.controller.ServicosController;
    opens com.example.sistema_bancario.controller.ServicosController to javafx.fxml;
    exports com.example.sistema_bancario.controller.LoginECadastroControllers;
    opens com.example.sistema_bancario.controller.LoginECadastroControllers to javafx.fxml;
>>>>>>> master
}