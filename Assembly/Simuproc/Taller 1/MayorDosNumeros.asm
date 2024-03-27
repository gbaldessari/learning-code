MSG ===Menu===
MSG Ingrese el primer numero:
LDT
STA 02A
MSG Ingrese el segundo numero:
LDT
CMP 02A
JEQ 030
JMA 032
MSG El numero 1 es mayor.
STA 02B
HLT
#030
MSG Los numeros son iguales.
JMP 00A
MSG El numero 2 es mayor.
JMP 00A
