# Tema 4.1 - Lenguaje de simulacion y simuladores
# Simulacion Monte Carlo: lanzamiento de un dado
import random

random.seed(42)  # semilla fija para que los resultados se puedan repetir


def simular_dado(n):
    resultados = [random.randint(1, 6) for _ in range(n)]
    print(f"Resultados de {n} lanzamientos: {resultados}")
    print("Frecuencias:", {i: resultados.count(i) for i in range(1, 7)})


simular_dado(20)
