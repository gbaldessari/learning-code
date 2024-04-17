MSG ===Menu===
MSG Ingrese el primer numero:
LDT ;Ingreso el primer numero a ordenar
STA 02A ;Guardo en 02A
MSG Ingrese el segundo numero:
LDT ;Ingreso el segundo numero a ordenar
STA 02B ;Guardo en 02B
MSG Ingrese el tercer numero:
LDT ;Ingreso el tercer numero a ordenar
STA 02C ;Guardo en 02C

LDA 02A ;Muevo 02A a AX
CMP 02B ;Comparo AX con 02B
JMA 030 ;Si AX es mayor salta a 030
STA 02A ;Guardo AX en 02A

LDA 02B ;Muevo 02B a AX
CMP 02C ;Comparo AX con 02C
JMA 036 ;Si AX es mayor salta a 036
STA 02B ;Guardo AX en 02B

MSG Numeros ordenados:
CLN ;Reinicio las flags
LDA 02A ;Muevo 02A a AX
EAP ;Muestro AX en pantalla
LDA 02B ;Muevo 02B a AX

EAP ;Muestro AX en pantalla
LDA 02C ;Muevo 02C a AX
EAP ;Muestro AX en pantalla
STA 02C ;Guardo AX en 02C
HLT ;Fin del programa

#030
STA 02D ;Guardo AX en 02D
LDA 02B ;Muevo 02B a AX
STA 02A ;Guardo AX en 02A
LDA 02D ;Muevo 02D a AX
STA 02B ;Guardo AX en 02B
JMP 00E ;Salto a 00E

STA 02D ;Guardo AX en 02D
LDA 02C ;Muevo 02C a AX
STA 02B ;Guardo AX en 02B
LDA 02D ;Muevo 02D a AX
STA 02C ;Guardo AX en 02C
JMP 00A ;Salto a 00A
