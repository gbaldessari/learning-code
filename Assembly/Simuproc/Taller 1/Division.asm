MSG ===Menu===
MSG Ingrese el dividendo:
LDT ;Ingreso dividendo
STA 020 ;Guardo en 020
MSG Ingrese el divisor:
LDT ;Ingreso divisor
CMP 020 ;Comparo AX con 020
JMA 02A ;Si es mayor salta a 02A
STA 021 ;Si es menor o igual guardo en 021

LDA 020 ;Muevo 020 a AX
SUB 021 ;Resto 021 a AX
STA 020 ;Guardo AX en 020
INC 022 ;Sumo 1 a 022
LDA 021 ;Muevo 021 a AX
CMP 020 ;Comparo AX con 020
JMA 02C ;Si es mayor salta a 02C
STA 021 ;Guardo AX en 021
JMP 009 ;Salto a 009

HLT ;Fin de la ejecucion
#020
0 ;Dividendo/Resto
0 ;Divisor
0 ;Resultado

#02A
MSG ERROR: Divisor mayor que dividendo
JMP 001 ;Salta al inicio

MSG El resultado es:
LDA 022 ;Muevo 022 a AX
EAP ;Muestro AX en pantalla
STA 022 ;Guardo AX en 022
MSG El resto es:
LDA 020 ;Muevo 020 a AX
EAP ;Muestro AX en pantalla
STA 020 ;Guardo AX en 020
JMP 012 ;Salto a 012
