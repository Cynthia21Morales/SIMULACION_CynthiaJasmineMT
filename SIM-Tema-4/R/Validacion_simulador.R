replicas <- replicate(30, simulador(10))

valor_real <- 45
tolerancia <- 5

cat("=== VALIDACION INDIVIDUAL ===\n")

for (i in 1:length(replicas)) {
  diferencia <- abs(replicas[i] - valor_real)
  
  if (diferencia < tolerancia) {
    cat("Replica", i, "- Resultado:", replicas[i],
        "- Validacion exitosa\n")
  } else {
    cat("Replica", i, "- Resultado:", replicas[i],
        "- Validacion fallida\n")
  }
}
promedio <- mean(replicas)
diferencia_promedio <- abs(promedio - valor_real)

cat("\n=== VALIDACION GENERAL ===\n")
cat(sprintf("Promedio: %.2f\n", promedio))
cat(sprintf("Valor real: %.2f\n", valor_real))
cat(sprintf("Diferencia: %.2f\n", diferencia_promedio))

if (diferencia_promedio < tolerancia) {
  cat("Validacion general exitosa\n")
} else {
  cat("Validacion general fallida\n")
}