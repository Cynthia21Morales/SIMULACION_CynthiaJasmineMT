# Tema 4.4.1 - Pruebas parametricas
# Prueba t de una muestra: H0: mu = 50
import numpy as np

np.random.seed(1)
datos = np.random.normal(loc=50, scale=5, size=30)

media_muestral = np.mean(datos)
media_hipotesis = 50
desv_estandar = np.std(datos, ddof=1)   # desviacion muestral
n = len(datos)

t_stat = (media_muestral - media_hipotesis) / (desv_estandar / np.sqrt(n))
t_critico = 2.045   # t de tabla, alfa = 0.05 a dos colas, gl = n - 1 = 29

print("Media de los datos:", media_muestral)
print("Estadistico t:", t_stat)
print("Valor critico (gl = 29, alfa = 0.05):", t_critico)

print("\nInterpretacion:")
if abs(t_stat) < t_critico:
    print("|t| < valor critico -> no se rechaza H0: no hay diferencia significativa")
else:
    print("|t| >= valor critico -> se rechaza H0: hay diferencia significativa")
