# Mantener 4 intervalos
m <- ceiling(sqrt(10))

# Recalcular las frecuencias
breaks <- seq(0, 1, length.out = m + 1)
histograma <- hist(numeros, breaks = breaks, plot = FALSE)
observados <- histograma$counts
prob_esperadas <- rep(1 / m, m)

# Usar simulación
chisq.test(x = observados, p = prob_esperadas, simulate.p.value = TRUE, B = 2000)

