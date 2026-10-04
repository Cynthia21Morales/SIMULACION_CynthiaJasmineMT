# Tema 4.2 - Aprendizaje y uso de un lenguaje de simulacion
# Replicas independientes de una simulacion (tiempos de espera exponenciales)
import pandas as pd
import numpy as np

np.random.seed(42)
datos = {"Replica": [], "TiempoEspera": []}

for r in range(1, 11):                      # 10 replicas
    tiempos = np.random.exponential(scale=5, size=20)   # 20 clientes, media 5 min
    for t in tiempos:
        datos["Replica"].append(r)
        datos["TiempoEspera"].append(t)

df = pd.DataFrame(datos)
print(df.head())

resumen = df.groupby("Replica")["TiempoEspera"].mean()
print("\nPromedio de cada replica:")
print(resumen)
print("\nPromedio global de las replicas:", resumen.mean())
