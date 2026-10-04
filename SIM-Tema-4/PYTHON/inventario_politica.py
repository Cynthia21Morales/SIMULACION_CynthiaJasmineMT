# Tema 4.3.2 - Problemas con sistemas de inventarios
# Inventario a 10 dias con demanda uniforme (5 a 15) y reorden bajo 20
import random

random.seed(5)

inventario = 50

for dia in range(1, 11):
    inventario -= random.randint(5, 15)
    if inventario < 20:
        inventario += 40
    print(f"Dia {dia}: Inventario = {inventario}")
