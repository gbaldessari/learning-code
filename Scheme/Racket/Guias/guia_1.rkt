#lang racket

(define (esPrimo valor)
  (define cont 2)
  (cond
    [(<= valor 1) #f]
    [(<= valor 3) #t]
    [else (auxPrimo valor cont)]
  )
)

(define (auxPrimo valor cont)
  (cond
    [(= 0 (remainder valor cont)) #f]
    [(= valor (+ 1 cont)) #t]
    [else (auxPrimo valor (+ 1 cont))]
  )
)

(println (esPrimo 5))