# Tema 4.4 - Validacion de un simulador
# Compara el resultado del simulador contra un valor real (valor_real es un dato de ejemplo)
import random
import statistics

random.seed(9)


def simulador(dias):
    inventario = 50
    for _ in range(dias):
        inventario -= random.randint(5, 15)
        if inventario < 20:
            inventario += 40
    return inventario


valor_real = 45
tolerancia = 5

resultado_sim = simulador(10)
print(f"Resultado de una corrida: {resultado_sim}")
print(f"Diferencia con valor real: {abs(resultado_sim - valor_real)}")

# Una sola corrida no basta para validar: se promedian 30 replicas
replicas = [simulador(10) for _ in range(30)]
promedio = statistics.mean(replicas)
print(f"Promedio de 30 replicas: {promedio:.2f}")
print(f"Diferencia con valor real: {abs(promedio - valor_real):.2f}")

if abs(promedio - valor_real) < tolerancia:
    print("Validacion exitosa")
else:
    print("Validacion fallida")
