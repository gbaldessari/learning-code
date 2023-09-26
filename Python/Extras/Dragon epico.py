#Giacomo Baldessari Marchant

import random
import time

def intro():
	print('-------------------------------------------------------------------------------------')
	print()
	print('Estás en un lugar repleto de dragones...')
	print()
	time.sleep(2)
	print('Y en búsqueda de un tesoro decides explorar...')
	print()
	time.sleep(2)
	print('Después de una ardua búsqueda finalmente hayas dos cuevas...')
	print()
	time.sleep(2)
	print('En una cueva se encuentra un dragón amigable que está dispuesto a compartir su tesoro')
	print()
	time.sleep(2)
	print('Pero en la otra, hay otro dragón que no será tan amable y te devorará apenas te vea.')
	print()
	print('-------------------------------------------------------------------------------------')
	time.sleep(2)

def elegirCueva():
	cueva = ''
	while cueva != '1' and cueva != '2':
		print()
		print('¿A qué cueva quieres entrar? (1 o 2)')
		print()
		print('-------------------------------------------------------------------------------------')
		cueva = input()
	return cueva

def explorarCueva(cuevaElegida):
	print('-------------------------------------------------------------------------------------')
	print()
	print('Te acercas a la cueva...')
	print()
	time.sleep(2)
	print('Es oscura y aterradora...')
	print()
	time.sleep(2)
	print('¡Un dragón enorme aparece repentinamente frente a ti!')
	print()
	time.sleep(2)
	print('Se acerca lentamente y...')
	print()
	time.sleep(2)
	
	cuevaDragon = random.randint(1, 2)
	
	if cuevaElegida == str(cuevaDragon):
		print('¡Comparte su tesoro sin problemas!')
		print()
		time.sleep(1)
		print('¡Felicidades!')
		print()
		print('-------------------------------------------------------------------------------------')
		print()
		print()
		time.sleep(2)
	else:
		print('¡Te come de un bocado!')
		time.sleep(1)
		print()
		print('Eso pasa por meterte donde no debias...')
		print('-------------------------------------------------------------------------------------')
		print()
		print()
		time.sleep(2)

		
jugardenuevo = 'si'
while jugardenuevo == 'si' or jugardenuevo == 's':
	intro()
	numerodeCueva = elegirCueva()
	explorarCueva(numerodeCueva)
	print()
	print('¿Quieres jugar de nuevo? (“si” o “no”)')
	print()
	print('-------------------------------------------------------------------------------------')
	jugardenuevo = input()

