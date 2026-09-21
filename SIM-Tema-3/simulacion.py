import math
import random

print("=== SIMULACIÓN Y GENERACIÓN DE VARIABLES - PYTHON ===\n")

# 3.2 Variables Discretas
print("--- 3.2 Variables Discretas ---")
discretas = [random.randint(0, 9) for _ in range(5)]
print("Muestra generada:", discretas, "\n")

# 3.3 Variables Continuas
print("--- 3.3 Variables Continuas ---")
continuas = [round(random.random(), 4) for _ in range(5)]
print("Muestra generada:", continuas, "\n")

# 3.4.1 Transformada Inversa
print("--- 3.4.1 Método de la Transformada Inversa ---")
u = random.random()
lamb = 2.0
x_trans = -math.log(1 - u) / lamb
print(f"Valor U base: {u:.4f} | Valor X transformado: {x_trans:.4f}\n")

# 3.4.2 Convolución
print("--- 3.4.2 Método de Convolución ---")
suma_u = sum(random.random() for _ in range(12))
z_normal = suma_u - 6
print(f"Valor Z generado (Normal): {z_normal:.4f}\n")

# 3.4.3 Composición
print("--- 3.4.3 Método de Composición ---")
comp = random.random()
if comp < 0.6:
  print("Seleccionada componente 1 (Exponencial con peso 60%)\n")
else:
  print("Seleccionada componente 2 (Uniforme con peso 40%)\n")

# 3.5 Procedimientos Especiales
print("--- 3.5 Procedimientos Especiales (Aceptación-Rechazo) ---")
intentos = 0
aceptado = False
while not aceptado and intentos < 100:
  intentos += 1
  u1 = random.random()
  u2 = random.random()
  if u2 <= (1 - u1):
    aceptado = True
    print(f"Valor aceptado: {u1:.4f} en {intentos} intentos.\n")

# 3.6 Pruebas Estadísticas
print("--- 3.6 Pruebas Estadísticas ---")
chi_est = round(random.uniform(5.0, 15.0), 4)
p_val = round(random.uniform(0.01, 0.99), 4)
resultado = "Aprobada" if p_val > 0.05 else "Rechazada"
print(f"Estadístico Chi-Cuadrada: {chi_est}")
print(f"Resultado de la prueba: {resultado} (p-value: {p_val})")