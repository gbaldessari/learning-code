MSG ===Menu===
MSG Escoja una opcion:
MSG 1)Opcion 1
MSG 2)Opcion 2
LDT ;Ingreso de valores

CMP 020 ;Compara AX con 020
JEQ 01C ;Si es igual salta a 01C
CMP 021 ;Compara AX con 021
JEQ 01E ;Si es igual salta a 01E

MSG Escoja una opcion valida
JMP 001 ;Salta al inicio de la ejecucion
HLT ;Fin de la ejecucion

#01C
MSG Escogio la opcion 1
JMP 00B ;Salta a 00B
MSG Escogio la opcion 2
JMP 00B ;Salta a 00B
1 ;Valor 1
10 ;Valor 2(bin)


