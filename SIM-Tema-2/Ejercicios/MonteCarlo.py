#IMPORTAR MODULO "RANDOM".
import random

#RANGO GENERAR.
INTERVAL = 20

circle_points = 0 #PUNTOS DENTRO DEL CIRCULO
square_points = 0 #PUNTOS DENTRO DEL CUADRADO

for i in range (INTERVAL**2):

    #GENERACION DE PUNTOS
    rand_x= random.uniform(-1, 1)
    rand_y= random.uniform(-1, 1)

    #DISTANCIA DE CADA PUNTO DEL ORIGEN
    origin_dist= (rand_x**2 + rand_y**2) **0.5

    #COMPROBAR SI EL PUNTO ESTA DENTRO DEL CIRCULO.
    if origin_dist<= 1:
        circle_points+= 1

    square_points+= 1

    #OBTENCION DEL VALOR DE PI.
    pi = 4* circle_points/ square_points

    #ESTIMACION FINAL.
    print("PI ESTIMACION: ", pi)
    print('TOTAL POINS: ',square_points)
