# Tema 4.1 - Lenguaje de simulacion y simuladores
# Estadisticas basicas de tiempos de servicio (datos de entrada de un simulador)
df <- data.frame(Cliente = c("C1", "C2", "C3"),
                 TiempoServicio = c(5, 7, 4))

cat("Datos de servicio:\n")
print(df)

cat("\nEstadisticas:\n")
x <- df$TiempoServicio
cat("count", length(x), "\n")
cat("mean ", mean(x), "\n")
cat("std  ", sd(x), "\n")
print(summary(x))   # min, cuartiles, media, max
