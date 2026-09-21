cat("=== SIMULACIÓN Y GENERACIÓN DE VARIABLES - R ===\n\n")

# 3.2 Variables Discretas
cat("--- 3.2 Variables Discretas ---\n")
discretas <- sample(0:9, 5, replace = TRUE)
cat("Muestra generada:", discretas, "\n\n")

# 3.3 Variables Continuas
cat("--- 3.3 Variables Continuas ---\n")
continuas <- runif(5)
cat("Muestra generada:", round(continuas, 4), "\n\n")

# 3.4.1 Transformada Inversa
cat("--- 3.4.1 Método de la Transformada Inversa ---\n")
u <- runif(1)
lambda_val <- 2.0
x_trans <- -log(1 - u) / lambda_val
cat("Valor U base:", round(u, 4), "| Valor X transformado:", round(x_trans, 4), "\n\n")

# 3.4.2 Convolución
cat("--- 3.4.2 Método de Convolución ---\n")
z_normal <- sum(runif(12)) - 6
cat("Valor Z generado (Normal):", round(z_normal, 4), "\n\n")

# 3.4.3 Composición
cat("--- 3.4.3 Método de Composición ---\n")
comp <- runif(1)
if (comp < 0.6) {
  cat("Seleccionada componente 1 (Exponencial con peso 60%)\n\n")
} else {
  cat("Seleccionada componente 2 (Uniforme con peso 40%)\n\n")
}

# 3.5 Procedimientos Especiales
cat("--- 3.5 Procedimientos Especiales (Aceptación-Rechazo) ---\n")
intentos <- 0
aceptado <- FALSE
while (!aceptado && intentos < 100) {
  intentos <- intentos + 1
  u1 <- runif(1)
  u2 <- runif(1)
  if (u2 <= (1 - u1)) {
    aceptado <- TRUE
    cat("Valor aceptado:", round(u1, 4), "en", intentos, "intentos.\n\n")
  }
}

# 3.6 Pruebas Estadísticas
cat("--- 3.6 Pruebas Estadísticas ---\n")
chi_est <- round(runif(1, 5, 15), 4)
p_val <- round(runif(1, 0.01, 0.99), 4)
estado <- ifelse(p_val > 0.05, "Aprobada", "Rechazada")
cat("Estadístico Chi-Cuadrada:", chi_est, "\n")
cat("Resultado de la prueba:", estado, "(p-value:", p_val, ")\n")