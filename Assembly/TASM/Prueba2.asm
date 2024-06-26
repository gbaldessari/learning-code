.model small
.stack 100h
.code
main proc
    mov ax,@data
    mov ds, ax
    mov CX,5
otro:
    
    mov ah,08h
    int 21h
    mov dl,al
    mov ah,02h
    int 21h
    loop otro
    
    mov al,0h
    mov ah, 4ch
    int 21h

main endp
end main