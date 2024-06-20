.model small
.stack 100h
.data
    num1 dw 25
    num2 dw 42
    result dw ?
    msg db 'Mayor: $'
.code
main proc
    mov ax, @data
    mov ds, ax

    mov ax, num1
    mov bx, num2
    cmp ax, bx
    jg ax_is_greater
    mov result, bx
    jmp end_compare
ax_is_greater:
    mov result, ax
end_compare:

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
