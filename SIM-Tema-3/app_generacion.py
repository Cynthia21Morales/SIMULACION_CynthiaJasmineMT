import random
import math

print("=== INICIO DE LA SIMULACIÓN Y GENERACIÓN DE VARIABLES ===\n")

# 3.2 Variables Aleatorias Discretas (Distribución Poisson analítica)
print("=== 3.2 VARIABLES DISCRETAS (Distribución Poisson) ===")
lambda_poisson = 3.5

def generar_poisson(l):
    p = math.exp(-l)
    s = p
    k = 0
    u = random.random()
    while u > s:
        k += 1
        p *= l / k
        s += p
    return k

muestra_discreta = [generar_poisson(lambda_poisson) for _ in range(10)]
media_disc = sum(muestra_discreta) / len(muestra_discreta)
print("Muestra generada:", muestra_discreta)
print(f"Media muestral: {media_disc:.4f}\n")


# 3.3 Variables Aleatorias Continuas (Distribución Exponencial)
print("=== 3.3 VARIABLES CONTINUAS (Distribución Exponencial) ===")
beta = 1.5
# Transformada inversa aplicada para la exponencial: X = -ln(1 - U) / beta
muestra_continua = [-math.log(1 - random.random()) / beta for _ in range(10)]
media_cont = sum(muestra_continua) / len(muestra_continua)
print("Muestra generada:", [round(v, 4) for v in muestra_continua])
print(f"Media muestral: {media_cont:.4f}\n")


# 3.4.1 Método de la Transformada Inversa
print("=== 3.4.1 MÉTODO DE LA TRANSFORMADA INVERSA ===")
u_vals = [random.random() for _ in range(5)]
lambda_inv = 2.0
x_trans = [-math.log(1 - u) / lambda_inv for u in u_vals]
print("Valores Uniformes Base (U):", [round(u, 4) for u in u_vals])
print("Valores transformados (X):", [round(x, 4) for x in x_trans], "\n")


# 3.4.2 Método de Convolución
print("=== 3.4.2 MÉTODO DE CONVOLUCIÓN ===")
# Teorema del Límite Central: suma de 12 uniformes menos 6
suma_u = sum(random.random() for _ in range(12))
z_convolucion = suma_u - 6
print(f"Valor Z generado por convolución (Normal Estándar): {z_convolucion:.4f}\n")


# 3.4.3 Método de Composición
print("=== 3.4.3 MÉTODO DE COMPOSICIÓN ===")
# Mezcla probabilística de dos componentes (60% Exponencial, 40% Uniforme)
if random.random() < 0.6:
    val_comp = -math.log(1 - random.random())
    componente_usada = "Exponencial (Peso: 60%)"
else:
    val_comp = random.uniform(0, 5)
    componente_usada = "Uniforme (Peso: 40%)"
print(f"Valor generado por Composición [{componente_usada}]: {val_comp:.4f}\n")


# 3.5 Procedimientos Especiales (Aceptación-Rechazo)
print("=== 3.5 PROCEDIMIENTOS ESPECIALES (Aceptación-Rechazo) ===")
intentos = 0
aceptado = False
valor_aceptado = 0
while not aceptado and intentos < 1000:
    intentos += 1
    u1 = random.random()
    u2 = random.random()
    if u2 <= (1 - u1):
        valor_aceptado = u1
        aceptado = True
print(f"Valor aceptado por Aceptación-Rechazo: {round(valor_aceptado, 4)} tras {intentos} intentos de prueba.\n")


# 3.6 Pruebas Estadísticas (Prueba de Uniformidad por Intervalos / Chi-Cuadrada básica)
print("=== 3.6 PRUEBAS ESTADÍSTICAS (Prueba de Frecuencias) ===")
muestra_prueba = [random.random() for _ in range(50)]
# Dividir el rango [0,1] en 5 intervalos
frecuencias = [0] * 5
for val in muestra_prueba:
    idx = min(int(val * 5), 4)
    frecuencias[idx] += 1

esperado = len(muestra_prueba) / 5
chi_cuadrada = sum((f - esperado) ** 2 / esperado for f in frecuencias)
print(f"Frecuencias observadas por intervalos: {frecuencias}")
print(f"Frecuencia esperada por intervalo: {esperado}")
print(f"Estadístico Chi-cuadrada calculado: {chi_cuadrada:.4f}")
print("Conclusión: Prueba de uniformidad por frecuencias completada exitosamente.")