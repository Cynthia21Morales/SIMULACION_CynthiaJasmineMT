# 1. Definir los datos (Faltaba esta parte)
numeros <- runif(10, min = 0, max = 1)

# 2. Mantener 4 intervalos
m <- ceiling(sqrt(10))

# 3. Recalcular las frecuencias
breaks <- seq(0, 1, length.out = m + 1)
histograma <- hist(numeros, breaks = breaks, plot = FALSE)
observados <- histograma$counts
prob_esperadas <- rep(1 / m, m)

# 4. Usar simulación
chisq.test(x = observados, p = prob_esperadas, simulate.p.value = TRUE, B = 2000)
