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

LDA 02B
CMP 02C
JMA 036
STA 02B

MSG Numeros ordenados:
CLN
LDA 02A
EAP
LDA 02B
EAP
LDA 02C
EAP
STA 02C
HLT

#030
STA 02D
LDA 02B
STA 02A
LDA 02D
STA 02B
JMP 00E

STA 02D
LDA 02C
STA 02B
LDA 02D
STA 02C
JMP 00A
