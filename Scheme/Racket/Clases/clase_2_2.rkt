#lang racket

; ejercicio 4

(define suma (
  lambda (x y)
  (+ x y)
))

(println (suma 5 6))

; ejercicio 5

(define(double x)(suma x x))
(println (double 5))

; ejercicio 6

(define factorial (
  lambda (n) (
    if (< n 0)
      "no se puede calcular el factorial de un numero negativo"
      (if (= n 0)
        1
        (* n (factorial (- n 1)))
      )
    )
  )
)

(println(factorial 0))

; ejercicio 7

(define (esPrimo n) (
    esPrimoAux n (- n 1)
  )
)

(define (esPrimoAux n i) (
  if (= i 1)
    #t
    (if (= (remainder n i) 0)
      #f
      (esPrimoAux n (- i 1))
    )
  )
)

(println (esPrimo 9))

; ejercicio 8

(define fibonacci (
  lambda (n) (
    if (< n 0)
      "no se puede calcular el fibonacci de un numero negativo"
      (if (= n 0)
        0
        (if (= n 1)
          1
          (+ (fibonacci (- n 1)) (fibonacci (- n 2)))
        )
      )
    )
  )
)

(println (fibonacci 4))