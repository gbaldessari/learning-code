#Giacomo Baldessari Marchant

import random
import time

def intro():
	print('-------------------------------------------------------------------------------------')
	print()
	print('Estás en un lugar repleto de compañeros')
	print()
	time.sleep(2)
	print('Y en búsqueda de un rival decides explorar...')
	print()
	time.sleep(2)
	print('Después de una ardua búsqueda finalmente hayas a dos posibles rivales...')
	print()
	print('-------------------------------------------------------------------------------------')
	time.sleep(2)

def elegirRival():
	rival = ''
	while rival != '1' and rival != '2':
		print()
		print('¿A quien quieres desafiar? (1 o 2)')
		print()
		print('-------------------------------------------------------------------------------------')
		rival = input()
	return rival

def RivalElegido(rivalElegido):
	print('-------------------------------------------------------------------------------------')
	print()
	print('Te acercas al elegido...')
	print()
	time.sleep(2)
	print('Se siente la tension en el aire...')
	print()
	time.sleep(2)
	print('Lo miras a los ojos...')
	print()
	time.sleep(2)
	print('Lo desafias y...')
	print()
	time.sleep(2)
	
	rivalDesafiado = random.randint(1, 2)
	
	if rivalElegido == str(rivalDesafiado):
		print('¡Encontraste un rival en ICCI!')
		print()
		time.sleep(1)
		print('¡Welcum rival!')
		print()
		print('-------------------------------------------------------------------------------------')
		print()
		print()
		time.sleep(2)
	else:
		print('¡No encontraste un rival en ICCI!')
		time.sleep(1)
		print()
		print('Zzzzz')
		print('-------------------------------------------------------------------------------------')
		print()
        
		print()
		time.sleep(2)

		
jugardenuevo = 'si'
while jugardenuevo == 'si' or jugardenuevo == 's':
	intro()
	numerodeRival = elegirRival()
	RivalElegido(numerodeRival)
	print()
	print('¿Quieres buscar otro rival? (“si” o “no”)')
	print()
	print('-------------------------------------------------------------------------------------')
	jugardenuevo = input()

