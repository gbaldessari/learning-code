#lang racket

(define (resolverOperacion operacion)
  (cond
    [(number? operacion) operacion]
    [(list? operacion)
     (let ([op (second operacion)]
           [x (resolverOperacion (first operacion))]
           [y (resolverOperacion (third operacion))])
       (cond
         [(equal? op '+) (+ x y)]
         [(equal? op '-) (- x y)]
         [(equal? op '*) (* x y)]
         [(equal? op '/) (/ (exact->inexact x) (exact->inexact y))]))]
    [else operacion]
  )
)

(define (resolverOperaciones lista)
  (if (empty? lista)
    0
    (resolverOperacion lista))
)

(println (resolverOperaciones '((1 + (4 * 12)) / 10)))
(println (resolverOperaciones '((1 + (2 * (3 + 4))) - 5)))
(println (resolverOperaciones '(((1 + 2) * (3 + 4)) / (8 - 4))))
(println (resolverOperaciones '()))
