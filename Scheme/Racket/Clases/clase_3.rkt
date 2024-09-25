#lang racket

(define par (cons 1 2))

(define (aumentarPar par)
  (cons (+ (car par) 1) (+ (cdr par) 1))
)

(println (aumentarPar par))

(define (invertirPar par)
  (cons (cdr par) (car par))
)

(println (invertirPar par))

(define par2 (cons 3 4))

(define (sumarPares par par2)
  (cons
    (+ (car par) (car par2))
    (+ (cdr par) (cdr par2))
  )
)

(println (sumarPares par par2))
