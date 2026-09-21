
# PROYECTO: Generación de Variables Aleatorias y Pruebas Estadísticas


# 3.2 Variables Aleatorias Discretas
cat("=== 3.2 VARIABLES DISCRETAS (Distribución Poisson) ===\n")
# rpois() genera 10 números enteros aleatorios discretos basados en una distribución de Poisson con un parámetro lambda (media) de 4
datos_discretos <- rpois(10, lambda = 4)
cat("Muestra generada:", datos_discretos, "\n")
cat("Media muestral:", mean(datos_discretos), " | Varianza muestral:", round(var(datos_discretos), 4), "\n\n")


# 3.3 Variables Aleatorias Continuas
cat("=== 3.3 VARIABLES CONTINUAS (Distribución Exponencial) ===\n")
# rexp() genera 10 valores reales continuos con una tasa (rate) de 1.5
datos_continuos <- rexp(10, rate = 1.5)
cat("Muestra generada:", round(datos_continuos, 4), "\n")
cat("Media muestral:", round(mean(datos_continuos), 4), "\n\n")


# 3.4.1 Método de la Transformada Inversa
cat("=== 3.4.1 MÉTODO DE LA TRANSFORMADA INVERSA ===\n")
# runif() genera 5 números pseudoaleatorios uniformes (U) entre 0 y 1
u <- runif(5)
lambda_param <- 2.0
# Se aplica la función inversa analítica de la distribución exponencial: X = -ln(1 - U) / lambda
x_transformada <- -log(1 - u) / lambda_param
cat("Valores Uniformes Base (U):", round(u, 4), "\n")
cat("Valores transformados (X):", round(x_transformada, 4), "\n\n")


# 3.4.2 Método de Convolución
cat("=== 3.4.2 MÉTODO DE CONVOLUCIÓN ===\n")
# Se aplica el Teorema del Límite Central sumando 12 variables uniformes y restando 6 para aproximar una distribución normal estándar
z_convolucion <- sum(runif(12)) - 6
cat("Valor Z generado por convolución (Normal Estándar):", round(z_convolucion, 4), "\n\n")


# 3.4.3 Método de Composición
cat("=== 3.4.3 MÉTODO DE COMPOSICIÓN ===\n")
# Se selecciona aleatoriamente una de dos componentes de densidad bajo porcentajes de peso (60% y 40%)
componente <- sample(c(1, 2), size = 1, prob = c(0.6, 0.4))
if (componente == 1) {
  val_comp <- rexp(1, rate = 1)
  cat("Valor generado mediante la componente Exponencial (Peso: 60%):", round(val_comp, 4), "\n\n")
} else {
  val_comp <- rnorm(1, mean = 0, sd = 1)
  cat("Valor generado mediante la componente Normal (Peso: 40%):", round(val_comp, 4), "\n\n")
}


# 3.5 Procedimientos Especiales (Aceptación-Rechazo)
cat("=== 3.5 PROCEDIMIENTOS ESPECIALES (Aceptación-Rechazo) ===\n")
# Algoritmo iterativo de von Neumann para aceptar o rechazar valores bajo una curva mayorante
intentos <- 0
aceptado <- FALSE
while (!aceptado && intentos < 1000) {
  intentos <- intentos + 1
  u1 <- runif(1) # Genera variable candidata
  u2 <- runif(1) # Genera variable de prueba para la condición
  # Condición de aceptación para la función de densidad evaluada
  if (u2 <= (1 - u1)) {
    valor_aceptado <- u1
    aceptado <- TRUE
  }
}
cat("Valor aceptado por Aceptación-Rechazo:", round(valor_aceptado, 4), "tras", intentos, "intentos de prueba.\n\n")


# 3.6 Pruebas Estadísticas
cat("=== 3.6 PRUEBAS ESTADÍSTICAS (Prueba de Kolmogorov-Smirnov) ===\n")
# Se genera una muestra de 50 datos uniformes para evaluar estadísticamente su bondad de ajuste
muestra_prueba <- runif(50)
# ks.test() evalúa la hipótesis de que la muestra proviene de una distribución uniforme teórica ("punif")
resultado_ks <- ks.test(muestra_prueba, "punif")
print(resultado_ks)