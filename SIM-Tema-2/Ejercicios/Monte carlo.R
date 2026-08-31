curve(dunif(x), from=-1, to=2, col="violet",lwd=2,
      xlab="x",ylab="f(x)",main="Función de densidad uniforme")

curve(punif(x), from=-1, to=2, col="orange1", lwd=2,
      xlab="x",ylab="f(x)",main="Función de distribución uniforme")

datos=runif(1000)

plot(datos, xlab="numéro de dato", ylab = "valor del dato",
     col="blue")

hist(datos, prob = T, col="lightsalmon",main="Histograma",
     sub="Datos simulados de una exp(1)",ylab="f(x)",
     breaks = "FD")

curve(dexp(x), from=-1, to=5, add=T,col="violet",lwd=6,
      ylab="f(x)")