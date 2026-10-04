# Tema 4.3.1 - Problemas con lineas de espera
# Banco con 2 cajeros (2 servidores) y una sola cola
set.seed(11)

tiempo_total <- 30
tiempo <- 0
cola <- c()
tiempos_cajeros <- c(0, 0)
cliente_id <- 0

cat("Simulacion de un banco con 2 cajeros\n")
cat("------------------------------------\n")

while (tiempo < tiempo_total) {
  if (runif(1) < 0.6) {                      # llegada con prob. 0.6 por minuto
    cliente_id <- cliente_id + 1
    cola <- c(cola, cliente_id)
    cat(sprintf("Minuto %d: Llega el Cliente %d (cola = %d)\n", tiempo, cliente_id, length(cola)))
  }

  for (i in 1:length(tiempos_cajeros)) {
    if (tiempos_cajeros[i] == 0 && length(cola) > 0) {
      cliente <- cola[1]
      cola <- cola[-1]
      tiempos_cajeros[i] <- sample(3:6, 1)
      cat(sprintf("Minuto %d: Cliente %d empieza en Cajero %d (tarda %d min)\n", tiempo, cliente, i, tiempos_cajeros[i]))
    }

    if (tiempos_cajeros[i] > 0) {
      tiempos_cajeros[i] <- tiempos_cajeros[i] - 1
      if (tiempos_cajeros[i] == 0) {
        cat(sprintf("Minuto %d: El Cajero %d termina con un cliente\n", tiempo, i))
      }
    }
  }

  tiempo <- tiempo + 1
}

cat("\nClientes que llegaron:", cliente_id, "\n")
cat("Clientes que quedaron en cola al final:", length(cola), "\n")
