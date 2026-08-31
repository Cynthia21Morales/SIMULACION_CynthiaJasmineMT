# Cantidad de números a generar.
n<- 100

#Parámetros
a <- 11
c <- 15
m <- 100
semilla <- 17

#Vector de almacenamiento de números
x <- numeric(n)
# Asignar semilla
x[1] <- semilla

# Ciclo de generación
for (i in 2:n){
  x[i] <- (a*x[i-1] + c) %% m
}
R <- x/(m-1)
R
