.model small
.stack 100h
.data
    count dw 10
    msg db '$'
.code
main proc
    mov ax, @data
    mov ds, ax

loop_count:
    lea dx, msg
    mov ah, 09h
    int 21h

    mov ax, count
    call print_num_count

    mov dl, 0Dh
    mov ah, 02h
    int 21h
    mov dl, 0Ah
    int 21h

    dec count
    cmp count, 0
    jg loop_count

    mov ax, 4C00h
    int 21h
main endp

print_num_count proc
    mov bx, 10
    xor cx, cx
convert_loop_count:
    xor dx, dx
    div bx
    add dl, '0'
    push dx
    inc cx
    test ax, ax
    jnz convert_loop_count

print_loop_count2:
    pop dx
    mov ah, 02h
    int 21h
    loop print_loop_count2
    ret
print_num_count endp
end main
