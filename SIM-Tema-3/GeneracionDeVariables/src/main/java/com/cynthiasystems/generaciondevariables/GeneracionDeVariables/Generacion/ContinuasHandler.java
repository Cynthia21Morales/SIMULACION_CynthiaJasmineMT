package com.cynthiasystems.generaciondevariables.GeneracionDeVariables.Generacion;

import java.util.Random;

public class ContinuasHandler {
    public static String generarContinuas() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append("Generando 5 valores continuos (ej. Uniforme [0,1] o Exponencial):\n");
        for (int i = 1; i <= 5; i++) {
            double valor = random.nextDouble();
            sb.append("Valor continuo ").append(i).append(": ").append(String.format("%.4f", valor)).append("\n");
        }
        return sb.toString();
    }
}
