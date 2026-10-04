# Tema 4.4.2 - Pruebas no parametricas
# U de Mann-Whitney para dos grupos independientes (n1 = n2 = 10)
set.seed(3)
grupoA <- rnorm(10, mean = 50, sd = 5)
grupoB <- rnorm(10, mean = 55, sd = 5)

datos <- c(grupoA, grupoB)
ranks <- rank(datos)          # rangos 1..20

n1 <- length(grupoA)
n2 <- length(grupoB)
R1 <- sum(ranks[1:n1])
U1 <- R1 - n1 * (n1 + 1) / 2
U2 <- n1 * n2 - U1
U <- min(U1, U2)

# Aproximacion normal
media_U <- n1 * n2 / 2
desv_U <- sqrt(n1 * n2 * (n1 + n2 + 1) / 12)
z <- (U - media_U) / desv_U

cat("U1 =", U1, " U2 =", U2, "\n")
cat("U =", U, " z =", round(z, 3), "\n")
if (abs(z) < 1.96) {
  cat("|z| < 1.96 -> no se rechaza H0: no hay diferencia entre los grupos\n")
} else {
  cat("|z| >= 1.96 -> se rechaza H0: los grupos son diferentes\n")
}
