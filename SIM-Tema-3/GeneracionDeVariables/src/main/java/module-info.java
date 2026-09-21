module com.cynthiasystems.generaciondevariables {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.cynthiasystems.generaciondevariables to javafx.fxml;
    exports com.cynthiasystems.generaciondevariables;
}