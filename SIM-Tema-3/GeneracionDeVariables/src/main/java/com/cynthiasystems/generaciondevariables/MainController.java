package com.cynthiasystems.generaciondevariables;

import com.cynthiasystems.generaciondevariables.GeneracionDeVariables.Generacion.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML private TextArea txtAreaDiscretas;
    @FXML private TextArea txtAreaContinuas;
    @FXML private TextArea txtAreaMetodos;
    @FXML private TextArea txtAreaEspeciales;
    @FXML private TextArea txtAreaPruebas;

    @FXML
    protected void handleDiscretas() {
        String resultado = DiscretasHandler.generarDiscretas();
        txtAreaDiscretas.setText(resultado);
    }

    @FXML
    protected void handleContinuas() {
        String resultado = ContinuasHandler.generarContinuas();
        txtAreaContinuas.setText(resultado);
    }

    @FXML
    protected void handleTransformada() {
        String resultado = MetodosGeneracion.metodoTransformadaInversa();
        txtAreaMetodos.setText("--- 3.4.1 Transformada Inversa ---\n" + resultado);
    }

    @FXML
    protected void handleConvolucion() {
        String resultado = MetodosGeneracion.metodoConvolucion();
        txtAreaMetodos.setText("--- 3.4.2 Convolución ---\n" + resultado);
    }

    @FXML
    protected void handlecomposicion() {
        String resultado = MetodosGeneracion.metodoComposicion();
        txtAreaMetodos.setText("--- 3.4.3 Composición ---\n" + resultado);
    }

    @FXML
    protected void handleProcedimientos() {
        String resultado = ProcedimientosEspeciales.ejecutarProcedimiento();
        txtAreaEspeciales.setText(resultado);
    }

    @FXML
    protected void handlePruebas() {
        String resultado = PruebasEstadisticas.ejecutarPruebas();
        txtAreaPruebas.setText(resultado);
    }
}