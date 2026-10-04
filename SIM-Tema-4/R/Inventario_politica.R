# Tema 4.3.2 - Problemas con sistemas de inventarios
# Inventario a 10 dias con demanda uniforme (5 a 15) y reorden bajo 20
set.seed(5)

inventario <- 50

for (dia in 1:10) {
  inventario <- inventario - sample(5:15, 1)
  if (inventario < 20) inventario <- inventario + 40
  cat(sprintf("Dia %d: Inventario = %d\n", dia, inventario))
}
