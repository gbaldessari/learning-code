.model small
.stack 100h
.data
    num1 dw 12
    num2 dw 34
    num3 dw 56
    result dw ?
    msg db 'Resultado: $'
.code
main proc
    mov ax, @data
    mov ds, ax

    mov ax, num1
    add ax, num2
    add ax, num3
    mov result, ax

    lea dx, msg
    mov ah, 09h
    int 21h

    mov ax, result
    call print_num

    mov ax, 4C00h
    int 21h
main endp

print_num proc
    mov bx, 10
    xor cx, cx
convert_loop:
    xor dx, dx
    div bx
    add dl, '0'
    push dx
    inc cx
    test ax, ax
    jnz convert_loop

print_loop:
    pop dx
    mov ah, 02h
    int 21h
    loop print_loop
    ret
print_num endp
end main
