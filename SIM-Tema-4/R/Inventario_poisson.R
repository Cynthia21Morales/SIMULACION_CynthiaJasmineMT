# Tema 4.3.2 - Problemas con sistemas de inventarios
# Inventario a 30 dias con demanda Poisson y politica de reorden
set.seed(2025)

dias <- 30
inv <- 50
Dia <- numeric(dias)
Demanda <- numeric(dias)
Inventario <- numeric(dias)

for (d in 1:dias) {
  demanda <- rpois(1, 3)
  inv <- inv - demanda
  if (inv < 10) {          # politica de reorden: si baja de 10, se piden 40
    inv <- inv + 40
  }
  Dia[d] <- d
  Demanda[d] <- demanda
  Inventario[d] <- inv
}

df <- data.frame(Dia, Demanda, Inventario)
print(df)
cat("\nInventario promedio:", mean(df$Inventario), "\n")
