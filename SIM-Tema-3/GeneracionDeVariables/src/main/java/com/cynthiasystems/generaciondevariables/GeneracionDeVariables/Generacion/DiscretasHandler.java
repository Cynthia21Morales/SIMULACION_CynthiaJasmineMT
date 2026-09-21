package com.cynthiasystems.generaciondevariables.GeneracionDeVariables.Generacion;

import java.util.Random;

public class DiscretasHandler {
    public static String generarDiscretas() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append("Generando 5 valores discretos (ej. Distribución de Poisson/Binomial):\n");
        for (int i = 1; i <= 5; i++) {
            int valor = random.nextInt(10); // Simulación simple
            sb.append("Elemento ").append(i).append(": ").append(valor).append("\n");
        }
        return sb.toString();
    }
}