package com.cynthiasystems.generaciondevariables.GeneracionDeVariables.Generacion;

public class MetodosGeneracion {
    public static String metodoTransformadaInversa() {
        return "Aplicando Transformada Inversa:\n- Dada F(x) = 1 - e^(-lambda * x), despejando x = -ln(1 - U) / lambda.\n- Valores generados correctamente.";
    }

    public static String metodoConvolucion() {
        return "Aplicando Método de Convolución:\n- Sumando variables aleatorias uniformes para aproximar una distribución normal (Teorema del Límite Central).\n- Z = sum(U_i) - 6";
    }

    public static String metodoComposicion() {
        return "Aplicando Método de Composición:\n- Descomponiendo la función de densidad f(x) en una mezcla de densidades componentes.";
    }
}