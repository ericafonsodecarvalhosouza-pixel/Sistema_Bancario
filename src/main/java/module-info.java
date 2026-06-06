module com.example.sistema_bancario {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.xml.crypto;

    exports com.example.sistema_bancario;
    opens com.example.sistema_bancario to javafx.fxml;

    exports com.example.sistema_bancario.controller.ServicosController;
    opens com.example.sistema_bancario.controller.ServicosController to javafx.fxml;

    exports com.example.sistema_bancario.controller.LoginECadastroControllers;
    opens com.example.sistema_bancario.controller.LoginECadastroControllers to javafx.fxml;

    exports com.example.sistema_bancario.Main;
    opens com.example.sistema_bancario.Main to javafx.fxml;
}