# Tema 4.3.1 - Problemas con lineas de espera
# Un cajero automatico (1 servidor), simulacion minuto a minuto
set.seed(7)

tiempo_total <- 20
tiempo <- 0
cola <- c()
tiempo_cajero <- 0
cliente_id <- 0

cat("Simulacion de un cajero automatico\n")
cat("-----------------------------------\n")

while (tiempo < tiempo_total) {
  if (runif(1) < 0.5) {                      # llega un cliente con prob. 0.5
    cliente_id <- cliente_id + 1
    cola <- c(cola, cliente_id)
    cat(sprintf("Minuto %d: Llega el Cliente %d (cola = %d)\n", tiempo, cliente_id, length(cola)))
  }

  if (tiempo_cajero == 0 && length(cola) > 0) {   # cajero libre y hay cola
    cliente <- cola[1]
    cola <- cola[-1]
    tiempo_cajero <- sample(2:5, 1)
    cat(sprintf("Minuto %d: Cliente %d empieza a usar el cajero (tarda %d min)\n", tiempo, cliente, tiempo_cajero))
  }

  if (tiempo_cajero > 0) {
    tiempo_cajero <- tiempo_cajero - 1
    if (tiempo_cajero == 0) {
      cat(sprintf("Minuto %d: El cliente termina su operacion\n", tiempo))
    }
  }

  tiempo <- tiempo + 1
}

cat("\nClientes que llegaron:", cliente_id, "\n")
cat("Clientes que quedaron en cola al final:", length(cola), "\n")
