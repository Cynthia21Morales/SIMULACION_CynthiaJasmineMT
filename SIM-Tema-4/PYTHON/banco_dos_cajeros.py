# Tema 4.3.1 - Problemas con lineas de espera
# Banco con 2 cajeros (2 servidores) y una sola cola
import random

random.seed(11)

tiempo_total = 30
tiempo = 0
cola = []
tiempos_cajeros = [0, 0]
cliente_id = 0

print("Simulacion de un banco con 2 cajeros")
print("------------------------------------")

while tiempo < tiempo_total:
    if random.random() < 0.6:                      # llegada con prob. 0.6 por minuto
        cliente_id += 1
        cola.append(cliente_id)
        print(f"Minuto {tiempo}: Llega el Cliente {cliente_id} (cola = {len(cola)})")

    for i in range(len(tiempos_cajeros)):
        if tiempos_cajeros[i] == 0 and cola:
            cliente = cola.pop(0)
            tiempos_cajeros[i] = random.randint(3, 6)
            print(f"Minuto {tiempo}: Cliente {cliente} empieza en Cajero {i+1} (tarda {tiempos_cajeros[i]} min)")

        if tiempos_cajeros[i] > 0:
            tiempos_cajeros[i] -= 1
            if tiempos_cajeros[i] == 0:
                print(f"Minuto {tiempo}: El Cajero {i+1} termina con un cliente")

    tiempo += 1

print(f"\nClientes que llegaron: {cliente_id}")
print(f"Clientes que quedaron en cola al final: {len(cola)}")
