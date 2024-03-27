MSG ===Menu===
MSG Ingrese la base:
LDT ;Ingreso de la base del triangulo
STA 02A ;Guardo AX en 02A
MSG Ingrese la altura:
LDT ;Ingreso de la altura del triangulo

MUL 02A ;Multipico AX por el valor guardado en 02A
DIV 02B ;Divido AX por el valor guardado en 02B
MSG El area del Triangulo es:
EAP ;Muestro en pantalla el valor guardado en AX
HLT ;Fin del programa

#02B
10 ;Guardo el valor 2 (Bin) en 02B


