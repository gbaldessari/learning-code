#lang racket

(define (insertarIntercalado n lista)
  (cond
    [(empty? lista) (list)]
    [(empty? (rest lista)) (list (first lista))]
    [else (cons (first lista) (cons n (insertarIntercalado n (rest lista))))]
  )
)

(println (insertarIntercalado 0 '(1 2 3 4 5)))
