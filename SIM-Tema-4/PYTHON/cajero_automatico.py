# Tema 4.3.1 - Problemas con lineas de espera
# Un cajero automatico (1 servidor), simulacion minuto a minuto
import random

random.seed(7)

tiempo_total = 20
tiempo = 0
cola = []
tiempo_cajero = 0
cliente_id = 0

print("Simulacion de un cajero automatico")
print("-----------------------------------")

while tiempo < tiempo_total:
    if random.random() < 0.5:                      # llega un cliente con prob. 0.5
        cliente_id += 1
        cola.append(cliente_id)
        print(f"Minuto {tiempo}: Llega el Cliente {cliente_id} (cola = {len(cola)})")

    if tiempo_cajero == 0 and cola:                # cajero libre y hay cola
        cliente = cola.pop(0)
        tiempo_cajero = random.randint(2, 5)
        print(f"Minuto {tiempo}: Cliente {cliente} empieza a usar el cajero (tarda {tiempo_cajero} min)")

    if tiempo_cajero > 0:
        tiempo_cajero -= 1
        if tiempo_cajero == 0:
            print(f"Minuto {tiempo}: El cliente termina su operacion")

    tiempo += 1

print(f"\nClientes que llegaron: {cliente_id}")
print(f"Clientes que quedaron en cola al final: {len(cola)}")
