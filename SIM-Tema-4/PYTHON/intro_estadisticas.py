# Tema 4.1 - Lenguaje de simulacion y simuladores
# Estadisticas basicas de tiempos de servicio (datos de entrada de un simulador)
import pandas as pd

datos = {"Cliente": ["C1", "C2", "C3"],
         "TiempoServicio": [5, 7, 4]}

df = pd.DataFrame(datos)
print("Datos de servicio:")
print(df)

print("\nEstadisticas:")
print(df["TiempoServicio"].describe())
