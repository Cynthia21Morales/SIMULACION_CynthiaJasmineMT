# Tema 4.1 - Lenguaje de simulacion y simuladores
# Simulacion Monte Carlo: lanzamiento de un dado
set.seed(42)   # semilla fija para que los resultados se puedan repetir

simular_dado <- function(n) {
  resultados <- sample(1:6, n, replace = TRUE)
  cat("Resultados de", n, "lanzamientos:", resultados, "\n")
  cat("Frecuencias:\n")
  print(table(factor(resultados, levels = 1:6)))
}

simular_dado(20)
