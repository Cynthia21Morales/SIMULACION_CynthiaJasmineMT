# Tema 4.3.2 - Problemas con sistemas de inventarios
# Inventario a 30 dias con demanda Poisson y politica de reorden
import pandas as pd
import numpy as np

np.random.seed(2025)
dias = 30
inv = 50
hist = []

for d in range(1, dias + 1):
    demanda = np.random.poisson(3)
    inv -= demanda
    if inv < 10:          # politica de reorden: si baja de 10, se piden 40
        inv += 40
    hist.append([d, demanda, inv])

df = pd.DataFrame(hist, columns=["Dia", "Demanda", "Inventario"])
print(df)
print("\nInventario promedio:", df["Inventario"].mean())
