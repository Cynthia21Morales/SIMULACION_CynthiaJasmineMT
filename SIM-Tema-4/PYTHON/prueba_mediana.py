# Tema 4.4.2 - Pruebas no parametricas
# Prueba de la mediana: ji-cuadrada sobre la tabla 2x2 (grupo x arriba/abajo de la mediana)
import pandas as pd
import random

random.seed(42)
grupo_A = [random.randint(1, 10) for _ in range(15)]
grupo_B = [random.randint(1, 10) for _ in range(15)]

df = pd.DataFrame({
    "Grupo": ["A"] * len(grupo_A) + ["B"] * len(grupo_B),
    "Tiempo": grupo_A + grupo_B
})

mediana_global = df["Tiempo"].median()
print("Mediana global:", mediana_global)

menores_A = sum(v < mediana_global for v in grupo_A)
mayores_A = len(grupo_A) - menores_A
menores_B = sum(v < mediana_global for v in grupo_B)
mayores_B = len(grupo_B) - menores_B

print("\nGrupo A -> menores:", menores_A, " mayores o iguales:", mayores_A)
print("Grupo B -> menores:", menores_B, " mayores o iguales:", mayores_B)

# Ji-cuadrada
tabla = [[menores_A, mayores_A], [menores_B, mayores_B]]
total = 30
chi2 = 0.0
for i in range(2):
    for j in range(2):
        esperado = sum(tabla[i]) * (tabla[0][j] + tabla[1][j]) / total
        chi2 += (tabla[i][j] - esperado) ** 2 / esperado

print("\nJi-cuadrada =", round(chi2, 3), " (valor critico gl=1, alfa=0.05: 3.841)")
if chi2 < 3.841:
    print("No se rechaza H0: ambos grupos tienen la misma mediana")
else:
    print("Se rechaza H0: las medianas son diferentes")
