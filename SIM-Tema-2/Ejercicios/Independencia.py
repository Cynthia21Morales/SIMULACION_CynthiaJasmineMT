import numpy as np
import matplotlib.pyplot as plt
numeros = np.random.rand(100)
plt.acorr(numeros - np.mean(numeros), maxlags=20)
plt.show()