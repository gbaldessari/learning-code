MSG ===Menu===
MSG Ingrese el primer numero:
LDT ;Ingreso el primer numero a comparar
STA 02A ;Guardo AX en 02A
MSG Ingrese el segundo numero:
LDT ;Ingreso el segundo numero a comparar
CMP 02A ;Comparo AX con 02A
JEQ 030 ;Si los numeros son iguales salta a 030
JMA 032 ;Si el numero en 02A es mayor salta a 032
MSG El numero 1 es mayor.
STA 02B ;Guardo AX en 02B
HLT ;Fin del programa
#030
MSG Los numeros son iguales.
JMP 00A ;Salto a 00A
MSG El numero 2 es mayor.
JMP 00A ;Salto a 00A
