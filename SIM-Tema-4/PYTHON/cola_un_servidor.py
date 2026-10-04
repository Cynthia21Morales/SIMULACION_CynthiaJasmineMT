# Tema 4.3.1 - Problemas con lineas de espera
# Cola de un servidor con llegadas y servicios exponenciales
import pandas as pd
import numpy as np

np.random.seed(123)
llegadas = np.cumsum(np.random.exponential(scale=4, size=50))   # llega 1 cliente cada 4 min en promedio
servicios = np.random.exponential(scale=3, size=50)             # se atiende en 3 min en promedio (rho = 3/4 = 0.75)

inicio, fin = [], []
actual = 0
for i in range(len(llegadas)):
    inicio_servicio = max(llegadas[i], actual)
    fin_servicio = inicio_servicio + servicios[i]
    inicio.append(inicio_servicio)
    fin.append(fin_servicio)
    actual = fin_servicio

df = pd.DataFrame({"Llegada": llegadas, "Inicio": inicio, "Fin": fin})
df["Espera"] = df["Inicio"] - df["Llegada"]
df["TiempoSistema"] = df["Fin"] - df["Llegada"]

print(df.head())
print("\nTiempo medio de espera en cola:", df["Espera"].mean())
print("Tiempo medio en sistema:", df["TiempoSistema"].mean())
