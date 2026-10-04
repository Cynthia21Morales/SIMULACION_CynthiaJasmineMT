# Tema 4.4.1 - Pruebas parametricas (validacion de datos simulados)
# Se valida que la media de tiempos de espera simulados coincida con la teorica (20 min)
set.seed(1)
tiempos <- rnorm(30, mean = 20, sd = 2)
df <- data.frame(Tiempo = tiempos)

print(summary(df))
cat("std:", sd(df$Tiempo), "\n")

mu_teorica <- 20
media_muestral <- mean(df$Tiempo)
std_muestral <- sd(df$Tiempo)
n <- nrow(df)

t_stat <- (media_muestral - mu_teorica) / (std_muestral / sqrt(n))
t_critico <- 2.045   # gl = 29, alfa = 0.05, dos colas

cat(sprintf("t=%.3f  (valor critico = %s)\n", t_stat, t_critico))
if (abs(t_stat) < t_critico) {
  cat("No se rechaza H0: el simulador reproduce la media teorica\n")
} else {
  cat("Se rechaza H0: el simulador NO reproduce la media teorica\n")
}
