# 1. Crear los datos
# Tabla de contingencia: filas = género, columnas = voto
# Los datos son ficticios
datos <- matrix(c(200, 150, 50,
                  250, 100, 40), 
                nrow = 2, 
                byrow = TRUE,
                dimnames = list(Genero = c("Hombre", "Mujer"),
                                Voto = c("Partido A", "Partido B", "Partido C")))

# Imprimir la tabla de datos
print(datos)

# 2. Realizar la prueba de chi-cuadrado para la independencia
prueba_chi_cuadrado <- chisq.test(datos)

# Imprimir los resultados de la prueba
print(prueba_chi_cuadrado)