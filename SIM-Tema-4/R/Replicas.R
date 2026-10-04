# Tema 4.2 - Aprendizaje y uso de un lenguaje de simulacion
# Replicas independientes de una simulacion (tiempos de espera exponenciales)
set.seed(42)

replicas <- 10
clientes <- 20
Replica <- rep(1:replicas, each = clientes)
TiempoEspera <- rexp(replicas * clientes, rate = 1 / 5)   # media 5 min

df <- data.frame(Replica = Replica, TiempoEspera = TiempoEspera)
print(head(df))

resumen <- tapply(df$TiempoEspera, df$Replica, mean)
cat("\nPromedio de cada replica:\n")
print(resumen)
cat("\nPromedio global de las replicas:", mean(resumen), "\n")
