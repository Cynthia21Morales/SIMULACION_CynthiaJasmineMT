# Tema 4.4.2 - Pruebas no parametricas
# U de Mann-Whitney para dos grupos independientes (n1 = n2 = 10)
import numpy as np

np.random.seed(3)
grupoA = np.random.normal(50, 5, 10)
grupoB = np.random.normal(55, 5, 10)

datos = np.concatenate([grupoA, grupoB])
ranks = datos.argsort().argsort() + 1     # rangos 1..20

n1, n2 = len(grupoA), len(grupoB)
R1 = np.sum(ranks[:n1])
U1 = R1 - n1 * (n1 + 1) / 2
U2 = n1 * n2 - U1
U = min(U1, U2)

# Aproximacion normal
media_U = n1 * n2 / 2
desv_U = np.sqrt(n1 * n2 * (n1 + n2 + 1) / 12)
z = (U - media_U) / desv_U

print("U1 =", U1, " U2 =", U2)
print("U =", U, " z =", round(z, 3))
if abs(z) < 1.96:
    print("|z| < 1.96 -> no se rechaza H0: no hay diferencia entre los grupos")
else:
    print("|z| >= 1.96 -> se rechaza H0: los grupos son diferentes")
