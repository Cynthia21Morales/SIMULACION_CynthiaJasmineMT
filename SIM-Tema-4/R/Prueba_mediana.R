# Tema 4.4.2 - Pruebas no parametricas
# Prueba de la mediana: ji-cuadrada sobre la tabla 2x2 (grupo x arriba/abajo de la mediana)
set.seed(42)
grupo_A <- sample(1:10, 15, replace = TRUE)
grupo_B <- sample(1:10, 15, replace = TRUE)

df <- data.frame(Grupo = c(rep("A", 15), rep("B", 15)),
                 Tiempo = c(grupo_A, grupo_B))

mediana_global <- median(df$Tiempo)
cat("Mediana global:", mediana_global, "\n")

menores_A <- sum(grupo_A < mediana_global)
mayores_A <- length(grupo_A) - menores_A
menores_B <- sum(grupo_B < mediana_global)
mayores_B <- length(grupo_B) - menores_B

cat("\nGrupo A -> menores:", menores_A, " mayores o iguales:", mayores_A, "\n")
cat("Grupo B -> menores:", menores_B, " mayores o iguales:", mayores_B, "\n")

# Ji-cuadrada
tabla <- matrix(c(menores_A, mayores_A, menores_B, mayores_B), nrow = 2, byrow = TRUE)
total <- sum(tabla)
chi2 <- 0
for (i in 1:2) {
  for (j in 1:2) {
    esperado <- sum(tabla[i, ]) * sum(tabla[, j]) / total
    chi2 <- chi2 + (tabla[i, j] - esperado)^2 / esperado
  }
}

cat("\nJi-cuadrada =", round(chi2, 3), " (valor critico gl=1, alfa=0.05: 3.841)\n")
if (chi2 < 3.841) {
  cat("No se rechaza H0: ambos grupos tienen la misma mediana\n")
} else {
  cat("Se rechaza H0: las medianas son diferentes\n")
}
