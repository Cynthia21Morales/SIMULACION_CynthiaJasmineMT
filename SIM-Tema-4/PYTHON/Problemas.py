import pandas as pd
import numpy as np

# Generamos 50 tiempos de llegada y servicio
np.random.seed(123)
llegadas = np.cumsum(np.random.exponential(scale=4, size=50))
servicios = np.random.exponential(scale=5, size=50)

# Calcular inicio y fin de servicio
inicio, fin = [], []
actual = 0
for i in range(len(llegadas)):
    inicio_servicio = max(llegadas[i], actual)  # se calcula directamente aquí
    fin_servicio = inicio_servicio + servicios[i]
    inicio.append(inicio_servicio)
    fin.append(fin_servicio)
    actual = fin_servicio

# Crear DataFrame
df = pd.DataFrame({
    "Llegada": llegadas,
    "Inicio": inicio,
    "Fin": fin
})
df["TiempoSistema"] = df["Fin"] - df["Llegada"]

# Mostrar resultados
print(df.head())
print("\nTiempo medio en sistema:", df["TiempoSistema"].mean())
