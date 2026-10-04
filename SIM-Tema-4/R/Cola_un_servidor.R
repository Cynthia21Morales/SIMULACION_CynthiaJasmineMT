# Tema 4.3.1 - Problemas con lineas de espera
# Cola de un servidor con llegadas y servicios exponenciales
set.seed(123)

n <- 50
llegadas  <- cumsum(rexp(n, rate = 1 / 4))   # llega 1 cliente cada 4 min en promedio
servicios <- rexp(n, rate = 1 / 3)           # se atiende en 3 min en promedio (rho = 0.75)

inicio <- numeric(n)
fin <- numeric(n)
actual <- 0
for (i in 1:n) {
  inicio[i] <- max(llegadas[i], actual)
  fin[i] <- inicio[i] + servicios[i]
  actual <- fin[i]
}

df <- data.frame(Llegada = llegadas, Inicio = inicio, Fin = fin)
df$Espera <- df$Inicio - df$Llegada
df$TiempoSistema <- df$Fin - df$Llegada

print(head(df))
cat("\nTiempo medio de espera en cola:", mean(df$Espera), "\n")
cat("Tiempo medio en sistema:", mean(df$TiempoSistema), "\n")
