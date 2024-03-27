MSG ===Menu===
MSG Escoja una opcion:
MSG 1)Sas
MSG 2)Sos
LDT ;Ingreso de
CMP 020
JEQ  01C
CMP 021
JEQ 01E
HLT
#01C
MSG Sas
JMP 009
MSG Sos
JMP 009
1
10


