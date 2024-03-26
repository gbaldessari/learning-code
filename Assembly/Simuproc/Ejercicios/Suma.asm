#SimuProc 1.4.3.0
msg Ingrese primer numero a sumar:
LDT
sta 00B
msg ingrese segundo numero a sumar:
LDT
ADD 00B
jo 00D
msg El resultado es :
EAP
HLT;
#00D
msg numero muy grande introdusca otro;
jmp 02; (salto incondicional)

