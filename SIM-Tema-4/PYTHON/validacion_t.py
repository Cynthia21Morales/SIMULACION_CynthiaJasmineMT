# Tema 4.4.1 - Pruebas parametricas (validacion de datos simulados)
# Se valida que la media de tiempos de espera simulados coincida con la teorica (20 min)
import pandas as pd
import numpy as np

np.random.seed(1)
tiempos = np.random.normal(loc=20, scale=2, size=30)
df = pd.DataFrame({"Tiempo": tiempos})

print(df.describe())

mu_teorica = 20
media_muestral = df["Tiempo"].mean()
std_muestral = df["Tiempo"].std(ddof=1)
n = len(df)

t_stat = (media_muestral - mu_teorica) / (std_muestral / np.sqrt(n))
t_critico = 2.045   # gl = 29, alfa = 0.05, dos colas

print(f"t={t_stat:.3f}  (valor critico = {t_critico})")
if abs(t_stat) < t_critico:
    print("No se rechaza H0: el simulador reproduce la media teorica")
else:
    print("Se rechaza H0: el simulador NO reproduce la media teorica")
