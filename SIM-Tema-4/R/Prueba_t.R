# Tema 4.4.1 - Pruebas parametricas
# Prueba t de una muestra: H0: mu = 50
set.seed(1)
datos <- rnorm(30, mean = 50, sd = 5)

media_muestral <- mean(datos)
media_hipotesis <- 50
desv_estandar <- sd(datos)      # sd() ya es la desviacion muestral (n - 1)
n <- length(datos)

t_stat <- (media_muestral - media_hipotesis) / (desv_estandar / sqrt(n))
t_critico <- 2.045   # t de tabla, alfa = 0.05 a dos colas, gl = n - 1 = 29

cat("Media de los datos:", media_muestral, "\n")
cat("Estadistico t:", t_stat, "\n")
cat("Valor critico (gl = 29, alfa = 0.05):", t_critico, "\n")

cat("\nInterpretacion:\n")
if (abs(t_stat) < t_critico) {
  cat("|t| < valor critico -> no se rechaza H0: no hay diferencia significativa\n")
} else {
  cat("|t| >= valor critico -> se rechaza H0: hay diferencia significativa\n")
}
