#lang racket

; ejercicio 9

(define lista (list 1 2 4))

(define sumarLista
  (lambda (l)
    (if (null? l)
      0
      (+ (car l) (sumarLista (cdr l)))
    )
  )
)

(println (sumarLista lista))

; ejercicio 10

(define lista2 (list 1 2 3 4 5 6 7 8 9 10))

(define sumarPares
  (lambda (l)
    (if (null? l)
      0
      (if (= (modulo (car l) 2) 0)
        (+ (car l) (sumarPares (cdr l)))
        (sumarPares (cdr l))
      )
    )
  )
)

(println (sumarPares lista2))

; ejercicio 11

(define listaEnteros 
  (lambda (n) 
    (if (= n 0)
      (list)
      (cons n (listaEnteros (- n 1)))
    )
  )
)

(println (listaEnteros 10))

; ejercicio 12

(define listaEnterosInv
  (lambda (n)
    (if (= n 0)
      (list)
      (append (listaEnterosInv (- n 1)) (list n))
    )
  )
)

(println (listaEnterosInv 10))