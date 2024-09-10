#lang racket

; ejercicio 9

(define lista (list 1 2 4))

(define sumarLista (
  lambda (l) (
    if (null? l)
      0
      (+ (car l) (sumarLista (cdr l)))
    )
  )
)

(println (sumarLista lista))