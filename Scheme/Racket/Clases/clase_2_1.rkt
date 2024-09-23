#lang racket

; ejercicio 1
(define int 5)
(define float 5.1)
(define string "hola")
(define funcion (lambda (x y) (+ x y)))

; ejercicio 2
(define maximo (
  lambda (x y) (
    cond
      [(> x y) x]
      [(< x y) y]
      [else "son iguales"]
    )
  )
)

(print "valor 1: ")
(define valor1 (read))
(print "valor 2: ")
(define valor2 (read))

(println (maximo valor1 valor2))

; ejercicio 3
(println "dada una ecuacion cuadratica de la forma ax^2 + bx + c = 0")
(print "ingrese el valor de a: ")
(define a (read))
(print "ingrese el valor de b: ")
(define b (read))
(print "ingrese el valor de c: ")
(define c (read))

(define discriminante (- (* b b) (* 4 a c)))

(cond
  [(> discriminante 0) 
   (println (/ (- (- b) (sqrt discriminante)) (* 2 a)))
   (println (/ (+ (- b) (sqrt discriminante)) (* 2 a)))]
  [(= discriminante 0)
   (println (/ b (* 2 a)))]
  [else (println "la ecuacion no tiene raices reales")]
)
